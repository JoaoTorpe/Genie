package com.torpe.genie.Services;

import com.torpe.genie.DTOs.RegisterUserDTO;
import com.torpe.genie.Models.User;
import com.torpe.genie.Repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;


import java.util.Optional;

import static org.mockito.Mockito.*;

class UserServicesTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtServices jwtServices;

    @Autowired
    @InjectMocks
    private UserServices services;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    @DisplayName("Should create user without any error")
    void registerUserSuccess(){
        RegisterUserDTO dto = new RegisterUserDTO("test@gmail.com","password","mytest");
        when(userRepository.findByEmail(dto.email())).thenReturn(Optional.empty());

        services.registerUser(dto);
        verify(userRepository,times(1)).save(any());
    }


}