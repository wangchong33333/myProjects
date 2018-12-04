package com.mrwang.mqtt;

import com.alibaba.fastjson.JSON;

/**
 * 统一API响应结果封装
 */
public class MqttPayload {
    private int code;
    private String message;
    private Object data;

    public MqttPayload setCode(MqttPayloadCode mqttPayloadCode) {
        this.code = mqttPayloadCode.code();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public MqttPayload setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public MqttPayload setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
