package xyz.switchannel.Main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import xyz.switchannel.Main.models.UserSubscription;

public interface UserSubscriptionsRepository extends MongoRepository<UserSubscription, String> {

    @Query("{userId: '?0'}")
    UserSubscription getUserSubscriptionsByUserI(String userId);

    @Query("{subscribedId: '?0'}")
    UserSubscription getUserSubscriptionsBySubscribedId(String subscribedId);

    @Query("{userId: '?0', subscribedId: '?1'}")
    UserSubscription getUserSubscriptionsByUserIdAndSubscribedId(String userId, String subscribedId);

}
