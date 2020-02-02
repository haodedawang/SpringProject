package com.example.jpa.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    private int id;
    private String enName;
    private String zhName;
    private Date lastDate;
}
