package Ecommerce.app.SpringApp.service;

import Ecommerce.app.SpringApp.model.Product;
import Ecommerce.app.SpringApp.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products;
    @Autowired
    private ProductRepository productRepository;


    public Product getProductByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
