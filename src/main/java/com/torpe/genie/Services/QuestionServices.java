package com.torpe.genie.Services;

import com.torpe.genie.DTOs.GetUserDTO;
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

import java.util.Optional;

@Service
public class QuestionServices {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OptionsRepository optionsRepository;
    @Autowired
    JwtServices jwtServices;



    public ResponseEntity createQuestion(QuestionDTO newQuestionData, User creator){

        for (Options o : newQuestionData.alternativas()){
            optionsRepository.save(o);
        }

        Question newQuestion = new Question(creator,newQuestionData.alternativas(),newQuestionData.materia(),newQuestionData.assunto(), newQuestionData.dica(),newQuestionData.resolucao(), newQuestionData.enunciado(), newQuestionData.dificuldade());
        questionRepository.save(newQuestion);
        return ResponseEntity.ok().body(newQuestion);

    }


}
