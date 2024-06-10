package com.serverapp.ServerApp.api.model;


import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long sensorId;

    @Column(name = "sensor_name")
    String sensorName;

    @ManyToMany(mappedBy = "sensors")
    private List<Device> devices;

    @ManyToMany
    @JoinTable(name = "measurament_details", joinColumns = @JoinColumn(name = "sensor_id"), inverseJoinColumns = @JoinColumn(name = "measurement_type_id"))
    private List<MeasurementType> measurementTypes;


}
