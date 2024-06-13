package com.torpe.genie.Services;

import com.torpe.genie.DTOs.LoginUserDTO;
import com.torpe.genie.DTOs.RegisterUserDTO;
import com.torpe.genie.DTOs.TokenDTO;
import com.torpe.genie.Models.User;
import com.torpe.genie.Repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtServices jwtServices;

    public ResponseEntity registerUser(RegisterUserDTO u){

        Optional<User> checkIfUserExists = userRepository.findByEmail(u.email());

        if (checkIfUserExists.isEmpty()) {
            if(u.password().isEmpty() || u.name().isEmpty()){
                throw new RuntimeException("Usuario invalido");
            }

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

public ResponseEntity login(LoginUserDTO u){
    try {
        var loginPasswordToken = new UsernamePasswordAuthenticationToken(u.email(),u.password());
        var auth = this.authenticationManager.authenticate(loginPasswordToken);
        String token = jwtServices.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new TokenDTO(token));
    }
    catch(RuntimeException exception){
        throw new RuntimeException("Falaha ao logar",exception);
    }
    }

    public User currentUser(HttpServletRequest request){
        String token = jwtServices.recoveryToken(request);
        String subject = jwtServices.getSubjectFromToken(token);
        Optional<User> user = userRepository.findByEmail(subject);
        return user.get();

    }

}
