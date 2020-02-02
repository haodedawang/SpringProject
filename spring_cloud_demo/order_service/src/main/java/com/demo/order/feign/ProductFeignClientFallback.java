package com.demo.order.feign;

import com.demo.order.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignClientFallback implements ProductFeignClient {

    public Product findById(Long id) {
        Product product = new Product();
        product.setCaption("降级方法");
        return product;
    }
}
