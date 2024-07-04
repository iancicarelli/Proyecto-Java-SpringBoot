package Ecommerce.app.SpringApp.service;

import Ecommerce.app.SpringApp.model.User;
import Ecommerce.app.SpringApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }
    public List<User> getAllUser(){
       return userRepository.findAll();
    }
}
