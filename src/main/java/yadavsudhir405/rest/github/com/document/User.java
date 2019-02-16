package yadavsudhir405.rest.github.com.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import java.lang.annotation.Documented;

/**
 * Created by sudhiry on 1/25/19.
 */
@Document
public class User {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String username;

    protected User(){

    }

    public User(String name, String username) {
        this.name = name;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }
}
