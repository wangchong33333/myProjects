//package com.mrwang.mqtt;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
//
//public class PropertiesUtil {
//
//   public static String MQTT_HOST;
//   public static String MQTT_CLIENTID;
//   public static String MQTT_USER_NAME;
//   public static String MQTT_PASSWORD;
//   public static int MQTT_TIMEOUT;
//   public static int MQTT_KEEP_ALIVE;
//
//
//   public static final String ELASTIC_SEARCH_HOST;
//
//   public static final int ELASTIC_SEARCH_PORT;
//
//   public static final String ELASTIC_SEARCH_CLUSTER_NAME;
//
//   static {
//      MQTT_HOST = loadMqttProperties().getProperty("mqtt.host");
//      MQTT_CLIENTID = loadMqttProperties().getProperty("mqtt.clientid");
//      MQTT_USER_NAME = loadMqttProperties().getProperty("mqtt.username");
//      MQTT_PASSWORD = loadMqttProperties().getProperty("mqtt.password");
//      MQTT_TIMEOUT = Integer.valueOf(loadMqttProperties().getProperty("mqtt.timeout"));
//      MQTT_KEEP_ALIVE = Integer.valueOf(loadMqttProperties().getProperty("mqtt.keepalive"));
//
//   }
//
//   static {
//      ELASTIC_SEARCH_HOST = loadEsProperties().getProperty("ES_HOST");
//      ELASTIC_SEARCH_PORT = Integer.valueOf(loadEsProperties().getProperty("ES_PORT"));
//      ELASTIC_SEARCH_CLUSTER_NAME = loadEsProperties().getProperty("ES_CLUSTER_NAME");
//   }
//
//   private static Properties loadMqttProperties() {
//      InputStream inputstream = PropertiesUtil.class.getResourceAsStream("/application.yml");
//      Properties properties = new Properties();
//      try {
//         properties.load(inputstream);
//         return properties;
//      } catch (IOException e) {
//         throw new RuntimeException(e);
//      } finally {
//         try {
//            if (inputstream != null) {
//               inputstream.close();
//            }
//         } catch (IOException e) {
//            throw new RuntimeException(e);
//         }
//      }
//   }
//
//   private static Properties loadEsProperties() {
//      InputStream inputstream = PropertiesUtil.class.getResourceAsStream("/elasticsearch.properties");
//      Properties properties = new Properties();
//      try {
//         properties.load(inputstream);
//         return properties;
//      } catch (IOException e) {
//         throw new RuntimeException(e);
//      } finally {
//         try {
//            if (inputstream != null) {
//               inputstream.close();
//            }
//         } catch (IOException e) {
//            throw new RuntimeException(e);
//         }
//      }
//   }
//
//
//}