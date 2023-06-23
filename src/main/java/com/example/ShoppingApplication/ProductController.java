package com.example.ShoppingApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        String ans = productService.addProduct(product);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<String> updateProduct(@RequestBody Product product){
        String ans = productService.updateProduct(product);
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    @GetMapping("/getProduct")
    public ResponseEntity<Product> getProductByName(@RequestParam("productName") String productName){
        Product product = productService.getProductByName(productName);
        return new ResponseEntity<>(product, HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteProduct")
    public ResponseEntity<String> delProduct(@RequestParam("productName") String productName){
        String ans = productService.delProduct(productName);
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    @GetMapping("/getAllproducts")
    public ResponseEntity<List<Product>> getAllproducts(){
        List<Product> list = productService.getAllproducts();
        if(list!=null){
            return new ResponseEntity<>(list, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllCategory")
    public ResponseEntity<List<String>> getAllCategory(){
            List<String> list = productService.getAllCategory();
            if(!list.isEmpty()){
                return new ResponseEntity<>(list, HttpStatus.FOUND);
            }
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    @DeleteMapping("/delByCategory")
    public ResponseEntity<String>  delByCategory(@RequestParam("categoryName") String categoryName){
        String ans = productService.delByCategory(categoryName);
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    @GetMapping("/getByCategory")
    public ResponseEntity<List<Product>> getByCategory(@RequestParam("categoryName") String categoryName){
        List<Product> list = productService.getByCategory(categoryName);
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }
}
