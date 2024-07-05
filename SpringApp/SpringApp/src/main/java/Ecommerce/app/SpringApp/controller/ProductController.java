package Ecommerce.app.SpringApp.controller;

import Ecommerce.app.SpringApp.model.Product;
import Ecommerce.app.SpringApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/add")
    public String showAddProductForm() {
        return "addProduct"; // Esto retornará el nombre del archivo HTML que contiene el formulario de agregar producto
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam("name") String name,
                             @RequestParam("sizes") String sizes,
                             @RequestParam("imageUrl") String imageUrl,
                             @RequestParam("price") Double price,
                             @RequestParam("description") String description) {
        Product product = new Product(name, List.of(sizes.split(",")), imageUrl, price, description);
        productService.addProduct(product);
        return "redirect:/menu"; // Redirigir al menú después de agregar el producto
    }

    @GetMapping("/catalog")
    public String catalog(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "catalog";
    }

    @GetMapping("/menu")
    public String showMenu(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "menu";
    }

    @GetMapping("/details/{name}")
    public String productDetails(@PathVariable("name") String name, Model model) {
        Product product = productService.getProductByName(name);
        if (product != null) {
            model.addAttribute("product", product);
            return "productDetails";
        } else {
            return "error/404";
        }
    }

    @ExceptionHandler(Exception.class)
    public String handleError() {
        return "error/404";
    }

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
}