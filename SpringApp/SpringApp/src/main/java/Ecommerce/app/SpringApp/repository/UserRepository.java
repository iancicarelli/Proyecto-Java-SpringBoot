package Ecommerce.app.SpringApp.repository;
import Ecommerce.app.SpringApp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findById(String id);
    User findByName(String name);
}
