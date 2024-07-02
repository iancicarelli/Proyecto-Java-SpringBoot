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


@Controller
@RequestMapping("/register")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping
    public String registerUser(@ModelAttribute User user, Model model) {
        if (user.getPassword() == null) {
            model.addAttribute("error", "Password cannot be null");
            return "register";
        }

        userService.saveUser(user);
        return "redirect:/login";
    }
}
