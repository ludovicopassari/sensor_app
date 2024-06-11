package com.serverapp.ServerApp.measurement;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Map;

@Service
public class MeasurementService {

    @Autowired
    private FakeMeasurementRepo measurementRepository;

    public void saveData(String payload) {
        FakeMeasurement data = new FakeMeasurement();

        data.setPayload(payload);
        measurementRepository.save(data);
    }

    public String printData(String payload) {
        return payload;
    }



}
