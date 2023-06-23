package com.example.ShoppingApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public String addProduct(Product product){
        return productRepository.addProduct(product);
    }
    public String updateProduct(Product product){
        return productRepository.updateProduct(product);
    }

    public Product getProductByName(String productName){
        return productRepository.getProductByName(productName);
    }

    public String delProduct(String productName){
        return productRepository.delProduct(productName);
    }

    public List<Product> getAllproducts(){
        return productRepository.getAllproducts();
    }

    public List<String> getAllCategory(){
        return productRepository.getAllCategory();
    }

    public String delByCategory(String categoryName){
        return productRepository.delByCategory(categoryName);
    }

    public List<Product> getByCategory(String categoryName){
        return productRepository.getByCategory(categoryName);
    }
}
