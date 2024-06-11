package com.serverapp.ServerApp.measurement;

import com.serverapp.ServerApp.device.Device;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Rappresenta una misurazione effettuata da un Device
 * Infatti assumiamo che un device possa effettuare N misurazioni.
 */

// todo puoi implementare il polimorfismo creando una classe measurement che poi si specializza nei vari tipi e quando usi un tipo specifico lo metti nella classe padre

@Entity
@Table(name = "measurements")
@Data //Genera automaticamente getter, setter, toString, equals, hashCode e un costruttore con tutti i campi della classe.
public class Measurement {

    @Id //specifica che l'attributo è una chiave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //fa in modo che la chiave primaria si AUTO_INCREMENT
    @Column(name = "id")
    private Long measurementId;


    @ManyToOne  //serve a definire una relazione N a 1.
    @JoinColumn(name = "device_id") //nome della colonna che funge da chiave esterna
    private Device device;  // todo fai in modo di partire da una classe astratta e poi via via specializzare

    @Column(name = "measured_value")
    private Double measuredValue;

    @ManyToOne
    @JoinColumn(name = "id_type", referencedColumnName = "id")
    private MeasurementType type;


    @Column(name = "data")
    private LocalDate dateStamp;


    @Column(name = "time")
    private LocalTime timeStamp;

    public void setTimeStamp(LocalTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setDateStamp(LocalDate dateStamp) {
        this.dateStamp = dateStamp;
    }

    public void setMeasuredValue(Double measuredValue) {
        this.measuredValue = measuredValue;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void setMeasurementId(Long measurementId) {
        this.measurementId = measurementId;
    }

    public void setType(MeasurementType type) {
        this.type = type;
    }
}
