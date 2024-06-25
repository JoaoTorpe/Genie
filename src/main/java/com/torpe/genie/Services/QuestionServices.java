package com.torpe.genie.Services;

import com.torpe.genie.DTOs.InsightsDTO;
import com.torpe.genie.DTOs.QuestionDTO;
import com.torpe.genie.Models.Options;
import com.torpe.genie.Models.Question;
import com.torpe.genie.Models.User;
import com.torpe.genie.Repositories.OptionsRepository;
import com.torpe.genie.Repositories.QuestionRepository;
import com.torpe.genie.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class QuestionServices {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    OptionsRepository optionsRepository;



    public ResponseEntity createQuestion(QuestionDTO newQuestionData, User creator){

        for (Options o : newQuestionData.alternativas()){

            optionsRepository.save(o);
        }

        Question newQuestion = new Question(creator,newQuestionData.alternativas(),newQuestionData.assunto(), newQuestionData.dica(), newQuestionData.enunciado());


        questionRepository.save(newQuestion);

        for (Options o : newQuestion.getAnswersList()){

            o.setQuestion(newQuestion);
            optionsRepository.save(o);

        }


        return ResponseEntity.ok().body(newQuestion);

    }

    public ResponseEntity<List<Question>> findAllQuestions(Long userID){

                 return ResponseEntity.ok().body(questionRepository.findByCreator_id(userID));
    }

    public ResponseEntity putCorrect(Long id,Boolean correct){

        Optional<Question> questionOp = questionRepository.findById(id);
           Question question =  questionOp.get();
           question.setCorrect(correct);

           questionRepository.save(question);

        return ResponseEntity.ok().body("");
    }

    public ResponseEntity getInsights(Long id){

    Long correctQuestion = questionRepository.countQuestionByCreator_idAndCorrect(id,true);
    Long wrongQuestions = questionRepository.countQuestionByCreator_idAndCorrect(id,false);
    Long totalAnsweredQuestions = correctQuestion + wrongQuestions;
        InsightsDTO insightsDTO = new InsightsDTO(totalAnsweredQuestions,correctQuestion,wrongQuestions);
    return ResponseEntity.ok().body(insightsDTO);
    }

}
