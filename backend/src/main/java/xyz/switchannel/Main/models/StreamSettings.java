package xyz.switchannel.Main.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import xyz.switchannel.Main.enums.Restrictions;
import xyz.switchannel.Main.enums.StreamCategory;
import xyz.switchannel.Main.enums.Tag;

@Document("stream-settings")
public class StreamSettings {
    @Id
    private String _id;
    @Indexed
    private String userId;

    private String liveKey;

    private String title;
    private String language;
    private Restrictions restrictions;
    private StreamCategory streamCategory; // StreamCategory enum
    private Tag[] tags;

    public StreamSettings(String userId, String liveKey, String title, String language, Restrictions restrictions, StreamCategory streamCategory, Tag[] tags) {
        this.userId = userId;
        this.liveKey = liveKey;
        this.title = title;
        this.language = language;
        this.restrictions = restrictions;
        this.streamCategory = streamCategory;
        this.tags = tags;
    }

    public String getUserId() {
        return userId;
    }

    public String getLiveKey() {
        return liveKey;
    }

    public void setLiveKey(String liveKey) {
        this.liveKey = liveKey;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public StreamCategory getStreamCategory() {
        return streamCategory;
    }

    public Tag[] getTags() {
        return tags;
    }
}
