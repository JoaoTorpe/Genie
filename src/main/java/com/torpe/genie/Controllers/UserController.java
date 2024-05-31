package com.torpe.genie.Controllers;

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

    @PostMapping
    public ResponseEntity registerUser(@RequestBody RegisterUserDTO u){
            try {
                userServices.registerUser(u);
            }
            catch (RuntimeException exception){
                throw new RuntimeException("Erro ao registrar usuario",exception);
            }


        return ResponseEntity.ok().build();

    }

}
