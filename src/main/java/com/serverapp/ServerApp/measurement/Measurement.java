package com.serverapp.ServerApp.measurement;

import com.serverapp.ServerApp.device.Device;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Rappresenta una misurazione effettuata da un Device
 * Infatti assumiamo che un device possa effettuare N misurazioni.
 */
@Entity
@Table(name = "measurements")
public class Measurement {

    @Id //specifica che l'attributo è una chiave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //fa in modo che la chiave primaria si AUTO_INCREMENT
    @Column(name = "id")
    private Long measurementId;

    @ManyToOne  //serve a definire una relazione N a 1.
    @JoinColumn(name = "device_id") //nome della colonna che funge da chiave esterna
    private Device device;  // todo fai in modo di partire da una classe astratta e poi via via specializzare

    @Column(name = "measured_value")
    private float measuredValue;

    @Column(name = "data")
    private LocalDate dateStamp;

    @Column(name = "time")
    private LocalTime timeStamp;
}
