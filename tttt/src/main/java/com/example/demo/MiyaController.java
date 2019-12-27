package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
public class MiyaController {
    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private int age;
    @RequestMapping(value = "/miya")
    public String miya(){
        return name+":"+age;
    }

    @Autowired
    ConfigBean configBean;

    @RequestMapping(value = "/lucy")
    public String miyaa(){
        return configBean.getGreeting()+" >>>>"+configBean.getName()+" >>>>"+ configBean.getUuid()+" >>>>"+configBean.getMax();
    }


    @Autowired
    User user;
    @RequestMapping(value = "/user")
    public String user(){
        Map map=new HashMap();
        map.put(null,123);
        return user.getName()+user.getAge()+map.get(null);

    }

}
