package xyz.switchannel.Main.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import xyz.switchannel.Main.Utils;

@Document("users")
public class User {
    @Id
    private String _id;
    @Indexed
    private String id;

    @Indexed
    private String name;
    private String password;
    private String email;

    public User(String id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
