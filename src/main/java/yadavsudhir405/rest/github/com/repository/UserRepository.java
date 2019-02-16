package yadavsudhir405.rest.github.com.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import yadavsudhir405.rest.github.com.document.User;

/**
 * Created by sudhiry on 1/25/19.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
