package Ecommerce.app.SpringApp.service;

import Ecommerce.app.SpringApp.model.Product;
import Ecommerce.app.SpringApp.model.User;
import Ecommerce.app.SpringApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<User> getUserByid(String id){
        return userRepository.findById(id);
    }

   /* public Optional<User> getUserbyname(String name){
        return userRepository.findByName(name);
    }

    */
    public User getUserName(String name) {
        return userRepository.findByName(name);
    }

    public void deleteUserByName(String name) {
        User user = userRepository.findByName(name);
          if (user != null){
              userRepository.delete(user);
          }else {
              throw new RuntimeException("No se pudo eliminar ");
          }
    }
}
