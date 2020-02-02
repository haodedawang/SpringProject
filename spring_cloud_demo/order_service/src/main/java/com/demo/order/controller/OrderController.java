package com.demo.order.controller;

import com.demo.order.entity.Product;
import com.demo.order.feign.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    ProductFeignClient productFeignClient;

    @GetMapping(value = "/buy/{id}")
    public Product findById(@PathVariable Long id) {
        return productFeignClient.findById(id);
    }


//    @Autowired
//    RestTemplate restTemplate;

//    @GetMapping(value = "/buy/{id}")
//    public Product findById(@PathVariable Long id) {
//        return restTemplate.getForObject("http://product-service/product/" + id, Product.class);
//    }

//    @GetMapping(value = "/buy/{id}")
//    public Product findById(@PathVariable Long id) {
//        return restTemplate.getForObject("http://localhost:9001/product/" + id, Product.class);
//    }
}
