package com.torpe.genie.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    private String password;
    private String name;

    public User(String email , String password,String name){

        this.email = email;
        this.password = password;
        this.name = name;


    }

}
