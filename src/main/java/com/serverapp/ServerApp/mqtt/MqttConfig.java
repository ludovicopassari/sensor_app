package com.serverapp.ServerApp.mqtt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.context.annotation.Bean;


@Configuration
public class MqttConfig {

    @Value("${mqtt.broker.url}")
    private String brokerURL;


    @Bean
    public MqttClient mqttClient() throws Exception {
        MqttClient client = new MqttClient(brokerURL, MqttClient.generateClientId(), new MemoryPersistence());
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);
        client.connect(options);
        return client;
    }
}
