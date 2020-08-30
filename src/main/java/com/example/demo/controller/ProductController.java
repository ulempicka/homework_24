package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/dodaj")
    public String add(@RequestParam String name, @RequestParam double price) {

        Product product = new Product(name, price);
        productRepository.add(product);
        return "redirect:/lista";
    }

    @GetMapping("/lista")
    public String list(Model model) {
        getProductDetails(model);
        return "list";
    }

    @GetMapping("/tabela")
    public String table(Model model) {
        getProductDetails(model);
        return "table";
    }

    private void getProductDetails(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        double sum = sumPrices(products);
        model.addAttribute("priceSum", sum);
    }

    private double sumPrices(List<Product> products) {
        return products.stream()
                .mapToDouble(product -> product.getPrice())
                .sum();
    }
}
