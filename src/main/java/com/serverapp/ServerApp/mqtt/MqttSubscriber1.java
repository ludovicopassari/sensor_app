package com.serverapp.ServerApp.mqtt;


/**
import java.util.Iterator;
import java.util.Map;

@Configuration
public class MqttSubscriber {

    String broker = "tcp://node-101.duckdns.org:1883"; // Cambia con l'URL del tuo broker MQTT
    String clientId = "JavaSubscriber";
    String topic = "/test"; // Cambia con il topic a cui vuoi iscriverti

    @Bean
    public MqttClient mqttClient() {
        try {
            MqttClient client = new MqttClient(broker, clientId);
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    System.out.println("Connessione persa: " + cause.getMessage());
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    String payload = new String(message.getPayload());
                    parseAndPrintJson(payload);
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    // Non utilizzato per il subscriber
                }
            });

            client.connect();
            client.subscribe(topic);

            System.out.println("Iscritto al topic: " + topic);

            return client;

        } catch (MqttException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void parseAndPrintJson(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                System.out.println("Chiave: " + field.getKey() + ", Valore: " + field.getValue().toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
 */