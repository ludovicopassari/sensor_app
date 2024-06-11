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

    @OneToMany(mappedBy = "type")
    private List <Measurement> measurements;

    public long getIdMeasurementType() {
        return idMeasurementType;
    }

    public void setIdMeasurementType(long idMeasurementType) {
        this.idMeasurementType = idMeasurementType;
    }

    public MeasurementTypes getMeasurementType() {
        return measurementType;
    }

    public MeasurementType setMeasurementType(MeasurementTypes measurementType) {
        this.measurementType = measurementType;
        return null;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }
}
