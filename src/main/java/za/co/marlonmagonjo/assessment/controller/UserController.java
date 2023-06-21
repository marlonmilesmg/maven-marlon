package za.co.marlonmagonjo.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.co.marlonmagonjo.assessment.model.User;
import za.co.marlonmagonjo.assessment.service.UserService;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @PostMapping("/{userId}")
    public void updateUser(@PathVariable("userId") String userId, @RequestBody User user) {
        userService.updateUser(userId, user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId) throws FileNotFoundException {
        return userService.getUser(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") String userId) throws FileNotFoundException {
        userService.deleteUser(userId);
    }
}
