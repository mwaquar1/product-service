package com.waquar.springcloud.productservice.controller;

import com.waquar.springcloud.productservice.model.Product;
import com.waquar.springcloud.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productapi")
public class ProductController {

    @Autowired
    ProductRepository productRepo;

    @RequestMapping("/add-product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return ResponseEntity.ok(productRepo.save(product));
    }

    @RequestMapping("get-product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
        return ResponseEntity.ok(productRepo.findById(id).get());
    }
}
