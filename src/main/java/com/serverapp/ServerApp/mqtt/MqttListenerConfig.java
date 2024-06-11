package com.serverapp.ServerApp.mqtt;

import com.serverapp.ServerApp.measurement.MeasurementService;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttListenerConfig {

    @Autowired
    private MeasurementService measurementService;

    @Autowired
    private MqttClient mqttClient;

    @Value("${mqtt.topic}")
    private String topic;

    @Bean
    public MqttListenerConfig subscribeToTopic() throws Exception {
        mqttClient.subscribe(topic, (topic, message) -> {
            String payload = new String(message.getPayload());
            measurementService.saveData(payload);
        });
        return this;
    }
}
