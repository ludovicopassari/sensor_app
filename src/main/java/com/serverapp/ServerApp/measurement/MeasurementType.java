package com.serverapp.ServerApp.measurement;

import com.serverapp.ServerApp.sensor.Sensor;
import jakarta.persistence.*;
import java.util.List;



@Entity
@Table(name = "measurement_type")
public class MeasurementType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMeasurementType;

    @Enumerated(EnumType.STRING)
    @Column(name = "measurement_type")
    private MeasurementTypes measurementType;

    @ManyToMany(mappedBy = "measurementTypes")
    private List<Sensor> sensors;
}
