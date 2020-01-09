package com.example.rabbitmq.config;

import com.example.rabbitmq.listener.TopicAllReceiver;
import com.example.rabbitmq.listener.TopicManReceiver;
import com.example.rabbitmq.listener.TopicWomanReceiver;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageListenerConfig {
    @Autowired
    private CachingConnectionFactory connectionFactory;
    @Autowired
    private TopicManReceiver topicManReceiver;
    @Autowired
    private TopicWomanReceiver topicWomanReceiver;
    @Autowired
    private TopicAllReceiver topicAllReceiver;

    @Autowired
    TopicRabbitConfig topicRabbitConfig;

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // RabbitMQ默认是自动确认，这里改为手动确认消息
        container.setQueues(topicRabbitConfig.firstQueue());
        container.setMessageListener(topicManReceiver);
//        container.addQueues(fanoutRabbitConfig.queueA());
//        container.setMessageListener(fanoutReceiverA);
        return container;
    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer2() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // RabbitMQ默认是自动确认，这里改为手动确认消息
        container.setQueues(topicRabbitConfig.secondQueue());
        container.setMessageListener(topicWomanReceiver);
//        container.addQueues(fanoutRabbitConfig.queueA());
//        container.setMessageListener(fanoutReceiverA);
        container.setPrefetchCount(1);

        return container;
    }
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer3() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // RabbitMQ默认是自动确认，这里改为手动确认消息
        container.setQueues(topicRabbitConfig.secondQueue());
        container.setMessageListener(topicAllReceiver);
//        container.addQueues(fanoutRabbitConfig.queueA());
//        container.setMessageListener(fanoutReceiverA);
        container.setPrefetchCount(1);
        return container;
    }



}
