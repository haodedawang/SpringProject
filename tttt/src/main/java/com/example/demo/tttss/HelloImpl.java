package com.example.demo.tttss;


import com.example.demo.Hello;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class HelloImpl implements Hello , Serializable {
    @Override
    public void hi(String msg) {
        System.out.println("hello " + msg);
    }
}
