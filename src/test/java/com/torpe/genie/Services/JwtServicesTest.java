package com.torpe.genie.Services;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;

class JwtServicesTest {

    @Autowired
    @InjectMocks
    JwtServices jwtServices;
    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    @DisplayName("Should return the right token value")
    void recoveryToken(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("Authorization","Bearer tokenvalue");
    String result  = jwtServices.recoveryToken(request);
        assertEquals("tokenvalue",result);
    }

}