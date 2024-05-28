package Models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class User {

    private String id;
    private String email;
    private String password;
    private String name;

    public User(String email , String password,String name){

        this.email = email;
        this.password = password;
        this.name = name;


    }

}
