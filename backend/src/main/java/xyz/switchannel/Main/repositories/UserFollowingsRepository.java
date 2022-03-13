package xyz.switchannel.Main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import xyz.switchannel.Main.models.UserFollowing;

public interface UserFollowingsRepository extends MongoRepository<UserFollowing, String> {

    @Query("{userId: '?0'}")
    UserFollowing getUserFollowingsByUserId(String userId);

    @Query("{followedId: '?0'}")
    UserFollowing getUserFollowingsByFollowedId(String followedId);

    @Query("{userId: '?0', followedId: '?1'}")
    UserFollowing getUserFollowingsByUserIdAndFollowedId(String userId, String followedId);

}
