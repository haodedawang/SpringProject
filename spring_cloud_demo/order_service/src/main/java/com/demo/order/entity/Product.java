package com.demo.order.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private Long id;
    private Integer status;
    private BigDecimal price;
    private String productDesc;
    private String caption;
    private String inventory;
    private String productName;

}
