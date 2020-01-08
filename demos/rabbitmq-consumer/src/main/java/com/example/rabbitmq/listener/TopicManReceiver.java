package com.example.rabbitmq.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RabbitListener(queues = "topic.man")
public class TopicManReceiver implements ChannelAwareMessageListener {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("TopicManReceiver消费者收到消息  : " + testMessage.toString());
    }

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            //因为传递消息的时候用的map传递,所以将Map从Message内取出需要做些处理
            String msg = message.toString();
            String[] msgArray = msg.split("'");//可以点进Message里面看源码,单引号直接的数据就是我们的map消息数据
            Map<String, String> msgMap = mapStringToMap(msgArray[1].trim());
            String messageId=msgMap.get("messageId");
            String messageData=msgMap.get("messageData");
            String createTime=msgMap.get("createTime");
            System.out.println("messageId:"+messageId+"  messageData:"+messageData+"  createTime:"+createTime);
            /*
            -----channel.basicAck(deliveryTag, multiple);
            consumer处理成功后，通知broker删除队列中的消息，如果设置multiple=true，表示支持批量确认机制以减少网络流量。
            例如：有值为5,6,7,8 deliveryTag的投递
            如果此时channel.basicAck(8, true);则表示前面未确认的5,6,7投递也一起确认处理完毕。
            如果此时channel.basicAck(8, false);则仅表示deliveryTag=8的消息已经成功处理。
            -----channel.basicNack(deliveryTag, multiple, requeue);
            consumer处理失败后，例如：有值为5,6,7,8 deliveryTag的投递。
            如果channel.basicNack(8, true, true);表示deliveryTag=8之前未确认的消息都处理失败且将这些消息重新放回队列中。
            如果channel.basicNack(8, true, false);表示deliveryTag=8之前未确认的消息都处理失败且将这些消息直接丢弃。
            如果channel.basicNack(8, false, true);表示deliveryTag=8的消息处理失败且将该消息重新放回队列。
            如果channel.basicNack(8, false, false);表示deliveryTag=8的消息处理失败且将该消息直接丢弃。
            -----channel.basicReject(deliveryTag, requeue);
            相比channel.basicNack，除了没有multiple批量确认机制之外，其他语义完全一样。
            如果channel.basicReject(8, true);表示deliveryTag=8的消息处理失败且将该消息重新放回队列。
            如果channel.basicReject(8, false);表示deliveryTag=8的消息处理失败且将该消息直接丢弃。
             */
            channel.basicAck(deliveryTag, true);
        } catch (Exception e) {
            channel.basicReject(deliveryTag, false);
            e.printStackTrace();
        }

    }

    //{key=value,key=value,key=value} 格式转换成map
    private Map<String, String> mapStringToMap(String str) {
        str = str.substring(1, str.length() - 1);
        String[] strs = str.split(",");
        Map<String, String> map = new HashMap<String, String>();
        for (String string : strs) {
            String key = string.split("=")[0].trim();
            String value = string.split("=")[1];
            map.put(key, value);
        }
        return map;
    }


}
