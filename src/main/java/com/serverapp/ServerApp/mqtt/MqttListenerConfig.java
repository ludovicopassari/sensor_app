package com.serverapp.ServerApp.mqtt;

import com.serverapp.ServerApp.measurement.MeasurementService;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttListenerConfig {

    @Autowired
    private MeasurementService measurementService;

    @Autowired
    private MqttClient mqttClient;

    @Bean
    public MqttListenerConfig subscribeToTopic() throws Exception {
        mqttClient.subscribe("/test", (topic, message) -> {
            String payload = new String(message.getPayload());
            measurementService.saveData(payload);
        });
        return this;
    }
}
