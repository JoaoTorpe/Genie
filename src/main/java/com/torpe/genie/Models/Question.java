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

    private String subject;

    private String topic;

    private String difficulty;

    private String hint;
    @Column(length = 500)
    private List<String> resolution;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Options> answersList  = new ArrayList<>();



    public Question(){}
    public Question(User creator, List<Options> answersList,String subject,String topic,String hint,List<String>resolution,String command,String difficulty) {

        this.creator = creator;
        this.creationDate = LocalDateTime.now();
        this.answersList = answersList;
        this.subject = subject;
        this.topic = topic;
        this.hint = hint;
        this.resolution = resolution;
        this.command = command;
        this.difficulty = difficulty;

    }

    public List<Options> getAnswersList(){
        return this.answersList;
    }

}
