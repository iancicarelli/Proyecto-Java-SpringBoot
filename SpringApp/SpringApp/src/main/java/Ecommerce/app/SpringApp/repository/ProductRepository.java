package Ecommerce.app.SpringApp.repository;


import Ecommerce.app.SpringApp.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
