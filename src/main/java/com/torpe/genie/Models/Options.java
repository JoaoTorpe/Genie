package com.torpe.genie.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Options {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
    private String texto;
    private Boolean correta;
     @ManyToOne
     @JsonIgnore
     private Question question;

     public Options(){}

     public Options(String texto,Boolean correta){
          this.texto = texto;
          this.correta = correta;

     }
     public void setQuestion(Question question){
          this.question = question;
     }

}
