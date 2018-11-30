package com.mrwang.mqtt;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Slf4j
@Component
public class MyMqttClient {

    private MqttClient client;
    private MqttAsyncClient mqttAsyncClient;
    private MqttConfiguration mqttConfiguration;

    //    private static volatile MyMqttClient myMqttClient = null;
//    public static MyMqttClient getInstance(){
//
//        if(null == myMqttClient){
//            synchronized (MyMqttClient.class){
//                if(null == myMqttClient){
//                    myMqttClient = new MyMqttClient();
//                }
//            }
//
//        }
//        return myMqttClient;
//
//    }
    private MyMqttClient(MqttConfiguration mqttConfiguration) {
        this.mqttConfiguration = mqttConfiguration;
        connect();
    }

    private void connect() {
        try {
            client = new MqttClient(mqttConfiguration.getHost(), mqttConfiguration.getClientid(), new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(false);
            if (!StringUtils.isEmpty(mqttConfiguration.getUsername())) {
                options.setUserName(mqttConfiguration.getUsername());
            }
            if (!StringUtils.isEmpty(mqttConfiguration.getPassword())) {
                options.setPassword(mqttConfiguration.getPassword().toCharArray());
            }
            options.setConnectionTimeout(mqttConfiguration.getTimeout());
            options.setKeepAliveInterval(mqttConfiguration.getKeepalive());

            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    // 连接丢失后，一般在这里面进行重连
                    System.out.println("连接断开，可以做重连");
                    while (true) {
                        try {//如果没有发生异常说明连接成功，如果发生异常，则死循环
                            Thread.sleep(1000);
                            connect();
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                            continue;
                        }
                    }
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    // subscribe后得到的消息会执行到这里面
                    System.out.println("接收消息主题 : " + topic);
                    System.out.println("接收消息Qos : " + message.getQos());
                    System.out.println("接收消息内容 : " + new String(message.getPayload()));
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    System.out.println("deliveryComplete---------" + token.isComplete());
                }
            });
            while (true) {
                try {
                    Thread.sleep(1000);
                    client.connect(options);
                    client.subscribe(mqttConfiguration.getTopic().split(","));
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发布，默认qos为0，非持久化
     *
     * @param topic
     * @param pushMessage
     */
    public void publish(String topic, PushPayload pushMessage) {
        publish(0, false, topic, pushMessage);
    }

    /**
     * 发布
     *
     * @param qos
     * @param retained
     * @param topic
     * @param pushMessage
     */
    public void publish(int qos, boolean retained, String topic, PushPayload pushMessage) {
        MqttMessage message = new MqttMessage();
        message.setQos(qos);
        message.setRetained(retained);
        message.setPayload(pushMessage.toString().getBytes());
        MqttTopic mTopic = client.getTopic(topic);
        if (null == mTopic) {
            log.error("topic not exist");
        }
        MqttDeliveryToken token;
        try {
            token = mTopic.publish(message);
            token.waitForCompletion();
        } catch (MqttPersistenceException e) {
            e.printStackTrace();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /**
     * 订阅某个主题，qos默认为0
     *
     * @param topic
     */
    public void subscribe(String topic) {
        subscribe(topic, 0);
    }

    /**
     * 订阅某个主题
     *
     * @param topic
     * @param qos
     */
    public void subscribe(String topic, int qos) {
        try {
            client.subscribe(topic, qos);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }


//    public static void main(String[] args) throws Exception {
//        String kdTopic = "good";
//        PushPayload pushMessage = PushPayload.getPushPayloadBuider().setMobile("15345715326")
//                .setContent("designModel")
//                .bulid();
//        MyMqttClient.getInstance().publish(0, false, kdTopic, pushMessage);
//    }
}