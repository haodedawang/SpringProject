package com.example.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@PropertySource(value = "classpath:dev.properties")
@ConfigurationProperties(prefix = "com.forezp")
@Data
public class User {
    private String name;
    private int age;

}
