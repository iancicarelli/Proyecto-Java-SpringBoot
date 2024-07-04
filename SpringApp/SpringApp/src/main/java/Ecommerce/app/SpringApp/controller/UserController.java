package Ecommerce.app.SpringApp.controller;

import Ecommerce.app.SpringApp.model.User;
import Ecommerce.app.SpringApp.repository.UserRepository;
import Ecommerce.app.SpringApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class UserController {

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

}
