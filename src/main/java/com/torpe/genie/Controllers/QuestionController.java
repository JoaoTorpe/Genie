package com.torpe.genie.Controllers;

import com.torpe.genie.DTOs.GetUserDTO;
import com.torpe.genie.DTOs.QuestionDTO;
import com.torpe.genie.Models.Question;
import com.torpe.genie.Models.User;
import com.torpe.genie.Services.JwtServices;
import com.torpe.genie.Services.QuestionServices;
import com.torpe.genie.Services.UserServices;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionServices questionServices;

    @Autowired
    JwtServices jwtServices;

    @Autowired
    UserServices userServices;

    @PostMapping
    public ResponseEntity createQuestion(@RequestBody QuestionDTO questionData, HttpServletRequest request){
                User creator =  userServices.currentUser(request);
                return questionServices.createQuestion(questionData,creator);
    }

    @GetMapping
    public ResponseEntity<List<Question>> findAllQuestions(HttpServletRequest request){

        User currentUser = userServices.currentUser(request);
        return questionServices.findAllQuestions(currentUser.getId());
    }

}
