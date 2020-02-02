package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import sun.security.action.PutAllAction;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class RedisApplication {

    private static RedisTemplate redisTemplate;
    private static StringRedisTemplate stringRedisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);

        for (int i = 1; i < 10; i++) {
            User u = new User(i, "王伟", 20 + i);
            redisTemplate.opsForHash().put("myuser", u.getId(), u);
            redisTemplate.opsForHash();
        }
        ArrayList<User> list = (ArrayList<User>) redisTemplate.opsForHash().values("myuser");
        list.forEach(user->{
            System.out.println(user.toString());
        });
        System.out.println("---------------------------");
        System.out.println(redisTemplate.opsForHash().get("myuser",1).toString());


        String[] ss ={"w","w"};
        ArrayList arrayList=new ArrayList(Arrays.asList(ss));

    }

}
