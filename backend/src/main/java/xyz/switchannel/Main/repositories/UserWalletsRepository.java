package xyz.switchannel.Main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import xyz.switchannel.Main.models.UserWallet;

public interface UserWalletsRepository extends MongoRepository<UserWallet, String> {

    @Query("{userId: '?0'}")
    UserWallet getUserWalletByUserId(String userId);

}
