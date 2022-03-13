package xyz.switchannel.Main.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import xyz.switchannel.Main.enums.SubscriptionTier;

import java.time.LocalDate;

@Document("user-subscriptions")
public class UserSubscription {
    @Id
    private String _id;
    @Indexed
    private String userId;
    @Indexed
    private String subscribedId;

    private boolean gifted;
    private SubscriptionTier tier;
    private LocalDate subscribed;
    private LocalDate validUntil;

    public UserSubscription(String userId, String subscribedId, boolean gifted, SubscriptionTier tier, LocalDate subscribed, LocalDate validUntil) {
        this.userId = userId;
        this.subscribedId = subscribedId;
        this.gifted = gifted;
        this.tier = tier;
        this.subscribed = subscribed;
        this.validUntil = validUntil;
    }

    public String getUserId() {
        return userId;
    }

    public String getSubscribedId() {
        return subscribedId;
    }

    public LocalDate getSubscribed() {
        return subscribed;
    }

    public SubscriptionTier getTier() {
        return tier;
    }

    public boolean isGifted() {
        return gifted;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }
}
