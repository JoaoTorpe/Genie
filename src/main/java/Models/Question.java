package Models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
@Setter
@Getter
@Entity
public class Question {

    private String id;

    private User creator;

    private Date creationDate;

    private Date resolutionDate;

    private Boolean corret;

    private ArrayList<String> answersList  = new ArrayList<>();

    private String rightAnswer;


    public Question(User creator, Date creationDate, ArrayList<String> answersList, String rightAnswer) {
        this.creator = creator;
        this.creationDate = creationDate;
        this.answersList = answersList;
        this.rightAnswer = rightAnswer;
    }

}
