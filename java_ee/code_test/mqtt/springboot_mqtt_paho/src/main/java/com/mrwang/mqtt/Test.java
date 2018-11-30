package com.mrwang.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @Autowired
    private MyMqttClient myMqttClient;

    @Autowired
    private MqttConfiguration mqttConfiguration;

    @GetMapping("")
    public void test() {
        PushPayload pushPayload = PushPayload.getPushPayloadBuider().setContent("test")
                .setMobile("119")
                .setType("2018")
                .bulid();
        myMqttClient.publish("/World", pushPayload);
    }
}
