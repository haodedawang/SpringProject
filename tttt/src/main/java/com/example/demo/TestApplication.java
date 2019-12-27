package com.example.demo;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TestApplication {

	public static String sss;

	@Value("${abc}")
	public void setSss(String sss) {
		TestApplication.sss = sss;
	}
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		System.out.println(Singleton.INSTANCE.max(1,8));
	}

}
