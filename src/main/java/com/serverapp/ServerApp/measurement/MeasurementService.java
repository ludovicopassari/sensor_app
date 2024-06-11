package com.serverapp.ServerApp.measurement;

import com.fasterxml.jackson.databind.JsonNode;
import com.serverapp.ServerApp.device.Device;
import com.serverapp.ServerApp.mqtt.JsonParserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// todo in questa classe si possono usare delle interfacce Misurable
@Service
public class MeasurementService implements Measurable {

    private static final Logger logger = LoggerFactory.getLogger(MeasurementService.class);

    @Autowired
    private MeasurementRepository measurementRepository;

    @Autowired
    private JsonParserService jsonParserService;

    @Override
    public void saveData(String payload) {

        Device device = new Device();
        device.setId(Long.valueOf(1));


        JsonNode node = jsonParserService.getJson(payload);


        Double tempValue  = node.get("temperature").asDouble();
        Double pressureValue  = node.get("pressure").asDouble();
        String timeValue = node.get("time").asText();
        String dateValue = node.get("date").asText();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m:s");
        LocalTime localTime = LocalTime.parse(timeValue, formatter);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("y-M-d");
        LocalDate localDate = LocalDate.parse(dateValue, dateFormatter);

        Measurement tempMeasurement = new Measurement();
        tempMeasurement.setMeasuredValue(tempValue);
        tempMeasurement.setDevice(device);
        tempMeasurement.setDateStamp(localDate);
        tempMeasurement.setTimeStamp(localTime);

        MeasurementType meas = new MeasurementType();
        meas.setIdMeasurementType(1);
        meas.setMeasurementType(MeasurementTypes.TEMPERATURE);

        tempMeasurement.setType(meas);

        measurementRepository.save(tempMeasurement);


    }

    public String printData(String payload) {
        return payload;
    }



}
