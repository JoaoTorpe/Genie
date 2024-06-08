package com.torpe.genie.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Options {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
     String texto;
     Boolean correta;

     public Options(){}

     public Options(String texto,Boolean correta){
          this.texto = texto;
          this.correta = correta;


     }
}
