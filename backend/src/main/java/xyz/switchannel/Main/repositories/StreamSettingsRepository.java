package xyz.switchannel.Main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import xyz.switchannel.Main.models.StreamSettings;

public interface StreamSettingsRepository extends MongoRepository<StreamSettings, String> {

    @Query("{userId: '?0'}")
    StreamSettings findStreamSettingsByUserId(String userId);
}
