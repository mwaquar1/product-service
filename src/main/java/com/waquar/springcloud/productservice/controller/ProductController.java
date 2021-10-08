package com.waquar.springcloud.productservice.controller;

import com.waquar.springcloud.productservice.dto.CouponDTO;
import com.waquar.springcloud.productservice.dto.ProductDTO;
import com.waquar.springcloud.productservice.model.Product;
import com.waquar.springcloud.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
@RequestMapping("/productapi")
public class ProductController {

    @Autowired
    ProductRepository productRepo;

    @Autowired
    RestTemplate restTemplate;

    @Value("${coupon-service.url}")
    String couponServiceUrl;

    @RequestMapping("/add-product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return ResponseEntity.ok(productRepo.save(product));
    }

    @RequestMapping("get-product/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("id") Long id,
                                                 @RequestParam(required = false) String coupon){
        Product product = productRepo.findById(id).get();
        ProductDTO productDTO = new ProductDTO(product);
        if(coupon != null && coupon != ""){
            CouponDTO couponDTO = restTemplate.getForEntity(couponServiceUrl + coupon, CouponDTO.class).getBody();
            if(couponDTO != null){
                productDTO.setDiscountedPrice(product.getPrice()
                        .subtract(product.getPrice().multiply(couponDTO.getDiscount().divide(BigDecimal.valueOf(100)))));
            } else{
                productDTO.setDiscountedPrice(product.getPrice());
            }
        } else{
            productDTO.setDiscountedPrice(product.getPrice());
        }
        return ResponseEntity.ok(productDTO);
    }
}
