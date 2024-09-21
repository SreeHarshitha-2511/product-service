package com.sreeharshitha.product_service.service;


import com.sreeharshitha.product_service.model.Product;
import com.sreeharshitha.product_service.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<String> addProduct(Product product) {
        productRepository.save(product);
        return new ResponseEntity<>("created product", HttpStatus.CREATED);
    }


    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productRepository.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<List<Product>> getProductsById(List<Integer> productIds) {
        List<Product> products=new ArrayList<>();
        for(Integer productid:productIds){
           Product product= productRepository.findById(productid).get();
           products.add(product);
        }
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    public ResponseEntity<Double> getAmount(List<Integer> productIds) {
        List<Product> products=new ArrayList<>();
        double amount=0.0;
        for(Integer productId:productIds){
           Product product=productRepository.findById(productId).get();
           products.add(product);
        }
        for(Product product:products){
            amount=amount+product.getPrice();
        }
        return new ResponseEntity<>(amount,HttpStatus.OK);
    }
}
