package com.serverapp.ServerApp.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MqttConfiguration {

    final Logger logger = LoggerFactory.getLogger(MqttConfiguration.class);


    @Bean
    public MqttService mqttService(){

        String broker = "tcp://192.168.1.101:1883"; // Cambia con l'URL del tuo broker MQTT
        String clientId = "JavaSubscriber";
        String topic = "/test"; // Cambia con il topic a cui vuoi iscriverti

        final Logger logger = LoggerFactory.getLogger(MqttService.class);

            try {

                MqttClient client = new MqttClient(broker, clientId);

                logger.info("Connecting to broker: " + broker);

                client.setCallback(new MqttCallBackHandler());
                client.connect();

                client.subscribe(topic);
                logger.info("Connected");

                return new MqttService();

            } catch (MqttException e) {
                e.printStackTrace();
                return null;
            }
    }
}
