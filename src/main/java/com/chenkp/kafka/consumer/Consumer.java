package com.chenkp.kafka.consumer;


import com.chenkp.kafka.thread.AsyncTask;
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

/**
 * Chenkp
 * 消费者，@KafkaListener 监听消息
 */

@Component
public class Consumer{

    @Autowired
    private AsyncTask asyncTask;

//    @KafkaListener(topics = {"test_topic"})
//    public void onMessage(String record) {
//        System.out.println("收到的消息："+record);
//    }

    @KafkaListener(topics = {"aaa"})
    public void onMessage(ConsumerRecord<?, ?> record){
//        System.out.println("收到的topic："+record.topic());
//        System.out.println("收到的key："+record.key());
//        System.out.println("收到的partitioner："+record.partition());
//        System.out.println("收到的offset："+record.offset());
        System.out.println("收到的value："+record.value().toString());
        try {
            asyncTask.doTask(record);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.err.println("接受结束");
    }
}
