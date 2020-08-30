package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products;

    private ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("Ser żółty", 3.5));
        products.add(new Product("Mleko", 2.1));
        products.add(new Product("Salami", 4.99));
        products.add(new Product("Polędwica", 5.49));
        products.add(new Product("Tost", 5.0));
        products.add(new Product("Cola", 5.9));
        products.add(new Product("Woda", 1.7));
        products.add(new Product("Czekolada", 3.8));
        products.add(new Product("Żelki", 2.5));
    }

    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    public void add(Product product) {
        products.add(product);
    }
}
