package Ecommerce.app.SpringApp.controller;

import Ecommerce.app.SpringApp.model.Product;
import Ecommerce.app.SpringApp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Controller
@RequestMapping("/")
public class PageController {
    private final ProductService productService;

    @Autowired
    public PageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/menu")
    public String showMenu(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "menu";
    }

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/addProduct")
    public String addProduct() {return "addProduct";}

    @GetMapping("/productDetails")
    public String productDetails(@RequestParam("name") String name, Model model) {
        Product product = productService.getProductByName(name);
        model.addAttribute("product", product);
        return "productDetails";
    }


}
