package com.serverapp.ServerApp.mqtt;

import org.springframework.context.annotation.Configuration;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.context.annotation.Bean;


@Configuration
public class MqttConfig {

    @Bean
    public MqttClient mqttClient() throws Exception {
        MqttClient client = new MqttClient("tcp://node-101.duckdns.org:1883", MqttClient.generateClientId(), new MemoryPersistence());
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);
        client.connect(options);
        return client;
    }
}
