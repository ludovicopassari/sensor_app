package com.serverapp.ServerApp.api;

import com.serverapp.ServerApp.mqtt.MqttCallBackHandler;
import com.serverapp.ServerApp.mqtt.MqttConfiguration;
import com.serverapp.ServerApp.mqtt.MqttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerREST {
    @Autowired
    public MqttService mqttService;


    public String ciao(){

        return "ciao";
    }





}
