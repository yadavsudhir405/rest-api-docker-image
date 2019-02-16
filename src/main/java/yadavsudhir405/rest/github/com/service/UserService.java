package yadavsudhir405.rest.github.com.service;

import org.springframework.stereotype.Service;
import yadavsudhir405.rest.github.com.document.User;
import yadavsudhir405.rest.github.com.repository.UserRepository;

import java.util.List;

/**
 * Created by sudhiry on 1/25/19.
 */
@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User save(User user){
         return this.userRepository.save(user);
    }
}
