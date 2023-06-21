package za.co.marlonmagonjo.assessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.marlonmagonjo.assessment.model.User;
import za.co.marlonmagonjo.assessment.repository.UserRepository;

import java.io.FileNotFoundException;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.saveUser(user);
    }

    public void updateUser(String userId, User user) {
        userRepository.updateUser(userId, user);
    }

    public User getUser(String userId) throws FileNotFoundException {
        return userRepository.getUser(userId);
    }

    public void deleteUser(String userId) throws FileNotFoundException {
        userRepository.deleteUser(userId);
    }
}
