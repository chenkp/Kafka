package com.chenkp.kafka.consumer;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.support.SendResult;
import org.springframework.kafka.support.converter.MessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class Consumer{

    @KafkaListener(topics = {"test-topic"})
    public void onMessage(String record) {
//        Object result = record.value();
        System.out.println("收到的消息："+record);
//        System.out.println("收到的消息："+result);
    }
}
