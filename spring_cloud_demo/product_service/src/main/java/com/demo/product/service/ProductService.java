package com.demo.product.service;

import com.demo.product.entity.Product;

public interface ProductService {

    Product findById(Long id);

    void save(Product product);

    void updat(Product product);

    void delete(Long id);
}
