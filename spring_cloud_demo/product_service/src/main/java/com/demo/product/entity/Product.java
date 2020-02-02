package com.demo.product.entity;

import lombok.Data;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    private Long id;
    private Integer status;
    private BigDecimal price;
    private String productDesc;
    private String caption;
    private String inventory;
    private String productName;
}
