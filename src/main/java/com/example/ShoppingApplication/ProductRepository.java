package com.example.ShoppingApplication;

import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PrimitiveIterator;

@Repository
public class ProductRepository {

    HashMap<String, Product> productDB = new HashMap<>();
    HashMap<String, List<Product>> categoryDB = new HashMap<>();
    public String addProduct(Product product){
        if(productDB.containsKey(product.getName())){
            return "Product Already Exist";
        }
        productDB.put(product.getName(), product);
        if(categoryDB.containsKey(product.getCategory())){
            List<Product> categoryList = categoryDB.get(product.getCategory());
            categoryDB.put(product.getCategory(), categoryList);
        }
        else{
            List<Product> list = new ArrayList<>();
            list.add(product);
            categoryDB.put(product.getCategory(),list);
        }
            return "product Added Successfully";
    }

    public String updateProduct(Product product){
        Product updatedProduct = product;
        if(productDB.containsKey(product.getName())){
            productDB.put(product.getName(), updatedProduct);
            return "Product Updated Successfully";
        }
        return "Enter correct product name";
    }

    public Product getProductByName(String productName){
        if(productDB.containsKey(productName)){
            return productDB.get(productName);
        }
        return null;
    }

    public String delProduct(String productName){
        if(productDB.containsKey(productName)){
            productDB.remove(productName);
            return "Product Deleted Successfully";
        }
        return "Enter correct product name";
    }

    public List<Product> getAllproducts(){
        List<Product> list = new ArrayList<>();
        for(Product product : productDB.values()){
            list.add(product);
        }
        return list;
    }

    public List<String> getAllCategory(){
        List<String> list = new ArrayList<>();
        if(!categoryDB.isEmpty()){
            for(String category : categoryDB.keySet()){
                list.add(category);
            }
            return list;
        }
        return null;
    }

    public String delByCategory(String categoryName){
        if(categoryDB.containsKey(categoryName)){
            categoryDB.remove(categoryName);
            for(Product product : productDB.values()){
                if(product.getCategory() == categoryName){
                    productDB.remove(product.getName());
                }
                return "Deleted Successfully";
        }
        }
        return "Category doesnt Exist";
    }

    public List<Product> getByCategory(String categoryName){
        if(categoryDB.containsKey(categoryName)){
            return categoryDB.get(categoryName);
        }
        return null;
    }

}
