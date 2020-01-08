package com.example.rabbitmq.listener;

import com.alibaba.fastjson.JSON;
import com.example.rabbitmq.utils.MessageHelper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "topic.woman")
public class TopicWomanReceiver {
    @RabbitHandler
    public void process(Message testMessage) {
        //System.out.println("TopicWomanReceiver消费者收到消息  : " + testMessage.toString());
        System.out.println("TopicWomanReceiver消费者收到消息  : " + MessageHelper.msgToObj(testMessage,Map.class).toString());

    }
}
