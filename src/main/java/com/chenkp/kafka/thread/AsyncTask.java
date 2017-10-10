package com.chenkp.kafka.thread;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTask {
    @Async("myAsync")  //myAsync即配置线程池的方法名，此处如果不写自定义线程池的方法名，会使用默认的线程池
    public void doTask(ConsumerRecord<?, ?> record) throws InterruptedException{
        System.err.println("开始睡眠");
        Thread.sleep(5000);
        System.err.println("醒来啦");
    }
}
