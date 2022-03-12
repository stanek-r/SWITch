package xyz.switchannel.Main.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class User {
    @Id
    private String id;

    private String name;
    private String liveId;
    private String key;

    public User(String id, String name, String liveId, String key) {
        super();
        this.id = id;
        this.name = name;
        this.liveId = liveId;
        this.key = key;
    }
}
