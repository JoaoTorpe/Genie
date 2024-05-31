package com.torpe.genie.Services;

import com.torpe.genie.DTOs.RegisterUserDTO;
import com.torpe.genie.Models.User;
import com.torpe.genie.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity registerUser(RegisterUserDTO u){

        Optional<User> checkIfUserExists = userRepository.findByEmail(u.email());

        if (checkIfUserExists.isEmpty()) {

            try {
                String encryptedPassword = new BCryptPasswordEncoder().encode(u.password());
                User user = new User(u.email(), encryptedPassword, u.name());
                userRepository.save(user);
            } catch (RuntimeException exception) {
                throw new RuntimeException();
            }
            return ResponseEntity.ok().body("Usuario criado com sucesso");
        }
    else {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("O usuario ja existe no banco");
        }

    }

}
