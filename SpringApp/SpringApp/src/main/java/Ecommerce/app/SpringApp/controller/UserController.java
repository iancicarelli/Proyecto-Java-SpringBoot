package Ecommerce.app.SpringApp.controller;

import Ecommerce.app.SpringApp.model.Product;
import Ecommerce.app.SpringApp.model.User;
import Ecommerce.app.SpringApp.repository.UserRepository;
import Ecommerce.app.SpringApp.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import java.util.List;
import java.util.Optional;



@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        if (user.getPassword() == null) {
            model.addAttribute("error", "Password cannot be null");
            return "register";
        }

        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/details")
    public String Showusers(Model model){
        try {
            List<User> users = userService.getAllUser();
            model.addAttribute("users", users);
        } catch (Exception e) {
            model.addAttribute("error", "Error retrieving users: " + e.getMessage());
        }
        return "details";
    }

    @GetMapping("/login")
    public String showLogin(){
        return "login";
    }


   @GetMapping("/userSearch")
    public String showUserSearch(Model model) {
        return "userSearch";
    }
    @GetMapping("/userDetails")
    public String showuserDetails(Model model) {
        return "userDetails";
    }

/*
    @GetMapping("/resource/{id}")
    public String getUserById(@PathVariable String id, Model model) {
        Optional<User> user = userService.getUserByid(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "userDetails";
        } else {
            model.addAttribute("error", "User not found");
            return "userDetails";
        }
    }

 */
    @PostMapping("/userSearch")
    public String userSearch(@RequestParam("name") String name, Model model) {
        logger.info("Buscando usuario por nombre: {}", name);
        User user = userService.getUserName(name);
        if (user != null) {
            model.addAttribute("user", user);
            return "redirect:/userDetails?name=";
        } else {
            return "userDetails";
        }
    }

    @GetMapping("/userDelete")
    public String userdelete(Model model) {
        return "userDelete";
    }


    @PostMapping("/userDelete")
    public String deleteUserByName(@RequestParam String name, Model model) {
        try {
            userService.deleteUserByName(name);
            return "redirect:/details";
        } catch (Exception e) {
            return "redirect:/menu";
        }
    }
     /*
    @DeleteMapping("/userDelete")
    public String deleteUserByName(@RequestParam String name, Model model) {
        try {
            userService.deleteUserByName(name);
            return "redirect:/details";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/menu";
        }
    }

      */




}
