package com.chenkp.kafka.producer;

import com.chenkp.kafka.util.Utils;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Chenkp
 * 生产者
 */
@Service
public class Producer {

    @Autowired
    KafkaTemplate kafkaTemplate;

    public boolean sendMessage() throws ExecutionException, InterruptedException {
//        Map<String, String> map = new HashMap<>();
//        map.put("key1", "value1");
//        map.put("key2", "value2");
        ListenableFuture<SendResult<String, Object>> result = kafkaTemplate.send("test_topic", "This is my message!");
        SendResult<String, Object> sendResult = result.get();
        ProducerRecord<String, Object> producerRecord = sendResult.getProducerRecord();
        RecordMetadata recordMetadata = sendResult.getRecordMetadata();

        boolean flag = result.isDone();
        System.err.println("发送成功!!!");
        return flag;
    }
}
