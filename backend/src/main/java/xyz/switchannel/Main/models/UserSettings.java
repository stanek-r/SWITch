package xyz.switchannel.Main.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user-settings")
public class UserSettings {
    @Id
    private String _id;
    @Indexed
    private String userId;

    private String displayName;
    private String description;
    private SocialLink[] socialLinks;

    private boolean darkMode;

    public UserSettings(String userId, String displayName, String description, SocialLink[] socialLinks, boolean darkMode) {
        this.userId = userId;
        this.displayName = displayName;
        this.description = description;
        this.socialLinks = socialLinks;
        this.darkMode = darkMode;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    public SocialLink[] getSocialLinks() {
        return socialLinks;
    }

    public boolean isDarkMode() {
        return darkMode;
    }
}
