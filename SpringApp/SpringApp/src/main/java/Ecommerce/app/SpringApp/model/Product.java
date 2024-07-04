package Ecommerce.app.SpringApp.model;
import java.util.List;

public class Product {
    private String name;
    private List<String> sizes;
    private String imageUrl;
    private double price;
    private String description;

    public Product(String name, List<String> sizes, String imageUrl, double price, String description) {
        this.name = name;
        this.sizes = sizes;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
