package com.mrwang.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @Autowired
    private MqttService mqttService;

    @Autowired
    private MqttConfiguration mqttConfiguration;

    @GetMapping("")
    public void test() {
        PushPayload pushPayload = PushPayload.getPushPayloadBuider().setContent("test")
                .setMobile("119")
                .setType("2018")
                .bulid();
        mqttService.publish("/World", pushPayload);
    }
}
