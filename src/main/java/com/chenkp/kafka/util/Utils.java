package com.chenkp.kafka.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class Utils {

    //字符串转换为json对象
    //cls-->Bean.class
    public static Object strToJson(String JsonStr,Class<?> cls){
        ObjectMapper mapper = new ObjectMapper();
        Object obj = null;
        try {
            obj = mapper.readValue(JsonStr, cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }

    //java对象转换为json字符串
    public static String objToJson(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    public static Map<String, String> readValue(String jsonStr, TypeReference<Map<String, String>> valueType) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonStr, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
