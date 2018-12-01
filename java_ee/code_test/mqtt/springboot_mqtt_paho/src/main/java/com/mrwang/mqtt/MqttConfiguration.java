package com.mrwang.mqtt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mqtt")
@Data
public class MqttConfiguration {

    private String host;
    private String clientid;
    private String topic;
    private String username;
    private String password;
    private Integer timeout;
    private Integer keepalive;

}