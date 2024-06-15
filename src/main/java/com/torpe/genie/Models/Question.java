package com.torpe.genie.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "question_table")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User creator;

    private LocalDateTime creationDate;

    private LocalDateTime resolutionDate;

    private Boolean correct;
    @Column(length = 500)
    private String command;

    private String topic;

    private String hint;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Options> answersList  = new ArrayList<>();



    public Question(){}
    public Question(User creator, List<Options> answersList,String topic,String hint,String command) {

        this.creator = creator;
        this.creationDate = LocalDateTime.now();
        this.answersList = answersList;
        this.topic = topic;
        this.hint = hint;
        this.command = command;


    }

    public List<Options> getAnswersList(){
        return this.answersList;
    }

    public void setCorrect(Boolean correct){
        this.correct = correct;
    }

}
