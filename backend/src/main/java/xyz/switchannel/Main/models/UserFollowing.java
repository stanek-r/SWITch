package xyz.switchannel.Main.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("user-followings")
public class UserFollowing {
    @Id
    private String _id;
    @Indexed
    private String userId;
    @Indexed
    private String followedId;

    private Date followed;

    public UserFollowing(String userId, String followedId) {
        this.userId = userId;
        this.followedId = followedId;
        this.followed = new Date();
    }

    public String getUserId() {
        return userId;
    }

    public String getFollowedId() {
        return followedId;
    }

    public Date getFollowed() {
        return followed;
    }
}
