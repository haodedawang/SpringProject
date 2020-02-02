package com.demo.product.controller;

import com.demo.product.entity.Product;
import com.demo.product.service.ProductService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Value("${server.port}")
    private String port;
    @Value("${spring.cloud.client.ip-address}")
    private String ip; //springcloud会自动的获取当前应用的IP地址

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {

        Product product = productService.findById(id);
        product.setProductName("访问的地址是："+ip + ":" + port);
        return product;
    }

}
