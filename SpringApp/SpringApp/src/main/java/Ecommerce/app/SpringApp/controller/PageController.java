package Ecommerce.app.SpringApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/addProduct")
    public String addProduct() {
        return "addProduct";
    }
}
