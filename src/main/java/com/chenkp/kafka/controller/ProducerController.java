package com.chenkp.kafka.controller;

import com.chenkp.kafka.producer.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private Producer producer;

    @RequestMapping("/test")
    public String test(){
        String result = "";
        try {
            Map<String, String> resultMap = new HashMap<>();
            boolean flag = producer.sendMessage();
            if(flag == true){
                resultMap.put("code", "0");
                resultMap.put("msg", "发送成功");
            }else{
                resultMap.put("code", "1");
                resultMap.put("msg", "发送失败");
            }
            result = new ObjectMapper().writeValueAsString(resultMap);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
