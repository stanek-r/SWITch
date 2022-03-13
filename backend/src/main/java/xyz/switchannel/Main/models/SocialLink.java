package xyz.switchannel.Main.models;

import xyz.switchannel.Main.enums.Platform;

public class SocialLink {
    private Platform platform;
    private String link;

    public SocialLink(Platform platform, String link) {
        this.platform = platform;
        this.link = link;
    }

    public Platform getPlatform() {
        return platform;
    }

    public String getLink() {
        return link;
    }
}
