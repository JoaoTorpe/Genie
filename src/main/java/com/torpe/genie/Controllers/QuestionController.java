package com.torpe.genie.Controllers;

import com.torpe.genie.DTOs.GetUserDTO;
import com.torpe.genie.DTOs.QuestionDTO;
import com.torpe.genie.Models.User;
import com.torpe.genie.Services.JwtServices;
import com.torpe.genie.Services.QuestionServices;
import com.torpe.genie.Services.UserServices;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
