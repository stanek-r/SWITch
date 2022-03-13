package xyz.switchannel.Main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import xyz.switchannel.Main.models.User;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{id: '?0'}")
    User findUserById(String id);

    @Query("{name: '?0'}")
    User findUserByName(String name);

}
