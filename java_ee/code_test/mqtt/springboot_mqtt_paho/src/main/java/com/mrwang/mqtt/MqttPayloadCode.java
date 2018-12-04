package com.mrwang.mqtt;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum MqttPayloadCode {
    DEVICE_SHARED(1);//已关注过此设备


    private final int code;

    MqttPayloadCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
