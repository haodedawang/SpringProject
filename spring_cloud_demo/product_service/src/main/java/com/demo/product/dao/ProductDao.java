package com.demo.product.dao;

import com.demo.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductDao extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {
}
