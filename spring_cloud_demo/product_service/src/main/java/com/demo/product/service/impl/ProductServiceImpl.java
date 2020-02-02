package com.demo.product.service.impl;

import com.demo.product.dao.ProductDao;
import com.demo.product.entity.Product;
import com.demo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Product findById(Long id) {
        return productDao.findById(id).get();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void updat(Product product) {
        productDao.save(product);

    }

    @Override
    public void delete(Long id) {
        productDao.deleteById(id);
    }
}
