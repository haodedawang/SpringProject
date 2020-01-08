package com.example.demo;


import com.example.demo.tttss.HelloImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class TestApplication {

    public static String sss;

    public static Hello hello;

    @Autowired
    public void setHello(Hello hello1) {
        hello = hello1;
    }

    @Value("${abc}")
    public void setSss(String sss) {
        TestApplication.sss = sss;
    }

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
        System.out.println(Singleton.INSTANCE.max(1, 8));
       /* //---------------------------------------------------------
        Integer a = new Integer(5);
        Integer b = new Integer(5);
        Integer c = 5;
        Integer d = 5;
        Integer e = 128;
        Integer f = 128;
        int g = 128;
		System.out.println(a==b);
		System.out.println(b==c);
		System.out.println(c==d);
		System.out.println(e==f);
		System.out.println(f==g);
		//------------------------------------*/
//        Map map=new HashMap();
//        map.put(null,"ddddd");
//
//        System.out.println("i = "+map.get(null));
        //------------------------------------*/
        //hello.hi("ss");
//        Hello hello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(), new Class[]{Hello.class}, new HelloProxy(new HelloImpl()));
//        hello.hi("world");


        Thread t1 = new Thread() {
            @Override
            public void run() {
                testSyn();
            }
        };
        t1.setName("t1");
        Thread t2 = new Thread() {
            @Override
            public void run() {
                testSyn();
            }
        };
        t2.setName("t2");
        t1.start();
        t2.start();


    }

    public static void testSyn() {
        System.out.println("1111111111");
        synchronized (TestApplication.class) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
