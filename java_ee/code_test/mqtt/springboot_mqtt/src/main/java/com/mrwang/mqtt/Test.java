package com.mrwang.mqtt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    private MqttPushClient mqttPushClient = MqttPushClient.getInstance();

    @GetMapping("")
    public void test() {

        PushPayload pushPayload = PushPayload.getPushPayloadBuider().setContent("test")
                .setMobile("119")
                .setType("2018")
                .bulid();
        mqttPushClient.publish("yes", pushPayload);
    }
}
