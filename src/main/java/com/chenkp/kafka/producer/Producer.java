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
        long time1 = System.currentTimeMillis();
        for(int i=1;i<=5000;i++){
            ListenableFuture<SendResult<String, Object>> result = kafkaTemplate.send("aaa", String.valueOf(i));
            SendResult<String, Object> sendResult = result.get();
            ProducerRecord<String, Object> producerRecord = sendResult.getProducerRecord();
            RecordMetadata recordMetadata = sendResult.getRecordMetadata();

            boolean flag = result.isDone();
        }
        long time2 = System.currentTimeMillis();
        long time = time2-time1;
        System.err.println("发送成功。使用时间："+time);
        return true;
    }
}
