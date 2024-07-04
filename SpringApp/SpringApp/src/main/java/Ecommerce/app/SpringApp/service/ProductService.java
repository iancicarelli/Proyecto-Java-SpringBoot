package Ecommerce.app.SpringApp.service;

import Ecommerce.app.SpringApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
        // Aquí puedes agregar productos de ejemplo o cargarlos desde una base de datos
        products.add(new Product("Zapatilla Nike Air Max", List.of("40", "41", "42"), "/images/nike_air_max.jpg", 120.0, "Una descripción de la Zapatilla Nike Air Max"));
        products.add(new Product("Zapatilla Nike Revolution", List.of("40", "41", "42"), "/images/nike_revolution.jpg", 100.0, "Una descripción de la Zapatilla Nike Revolution"));
        products.add(new Product("Zapatilla Nike Zoom", List.of("40", "41", "42"), "/images/nike_zoom.jpg", 110.0, "Una descripción de la Zapatilla Nike Zoom"));
        // Agrega más productos según sea necesario
    }

    public Product getProductByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
