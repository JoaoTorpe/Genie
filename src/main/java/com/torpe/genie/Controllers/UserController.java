package com.torpe.genie.Controllers;

import com.torpe.genie.DTOs.LoginUserDTO;
import com.torpe.genie.DTOs.RegisterUserDTO;
import com.torpe.genie.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody RegisterUserDTO u){
               return userServices.registerUser(u);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginUserDTO u){
        return userServices.login(u);
    }

}
