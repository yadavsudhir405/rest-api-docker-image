package yadavsudhir405.rest.github.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yadavsudhir405.rest.github.com.document.User;
import yadavsudhir405.rest.github.com.service.UserService;

import java.util.List;

/**
 * Created by sudhiry on 1/25/19.
 */
@RestController()
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll(){
        return this.userService.getAll();
    }
}
