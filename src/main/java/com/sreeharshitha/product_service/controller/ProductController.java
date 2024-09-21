package com.sreeharshitha.product_service.controller;


import com.sreeharshitha.product_service.model.Product;
import com.sreeharshitha.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("add")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        return productService.addProduct(product);

    }

    @GetMapping("get")
    public ResponseEntity<List<Product>> getProducts(){
        return productService.getProducts();
    }

        @PostMapping("getproductsById")
    public ResponseEntity<List<Product>> getProductsById(@RequestBody List<Integer> productIds){
        return productService.getProductsById(productIds);
    }


    @PostMapping("getamount")
    public ResponseEntity<Double> getAmount(@RequestBody List<Integer> productIds){
        return productService.getAmount(productIds);
    }





}
