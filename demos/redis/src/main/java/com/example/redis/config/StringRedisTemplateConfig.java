package com.example.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class StringRedisTemplateConfig {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Bean
    public StringRedisTemplate stringRedisTemplate() {
        //设置序列化Key的实例化对象
        stringRedisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        stringRedisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return stringRedisTemplate;
    }
}
