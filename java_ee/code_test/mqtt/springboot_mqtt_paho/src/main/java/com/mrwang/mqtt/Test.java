package com.mrwang.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @Autowired
    private MqttService mqttService;

    @GetMapping("")
    public void test() {

        mqttService.publish("/World", new MqttPayload().setCode(MqttPayloadCode.DEVICE_SHARED));
    }
}
