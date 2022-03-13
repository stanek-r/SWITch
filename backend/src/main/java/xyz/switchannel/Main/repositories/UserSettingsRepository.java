package xyz.switchannel.Main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import xyz.switchannel.Main.models.UserSettings;

public interface UserSettingsRepository extends MongoRepository<UserSettings, String> {

    @Query("{userId: '?0'}")
    UserSettingsRepository findUserSettingsByUserId(String userId);

}
