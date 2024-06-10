package com.serverapp.ServerApp.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


public class MqttCallBackHandler implements MqttCallback {
    final Logger logger = LoggerFactory.getLogger(MqttCallBackHandler.class);


    @Override
    public void connectionLost(Throwable cause) {
        System.out.println("Connessione persa: " + cause.getMessage());

    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        String payload = new String(message.getPayload());
        logger.info(payload);

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // Non utilizzato per il subscriber
    }
}
