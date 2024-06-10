package com.serverapp.ServerApp.api.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

/**
 * Rappresenta una misurazione effettuata da un Device
 */
@Entity
@Table(name = "measurements")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //fa in modo che la chiave primaria si AUTO_INCREMENT
    @Column(name = "id")
    private Long measurementId;

    @ManyToOne
    @JoinColumn(name = "device_id") //nome della colonna che funge da chiave esterna
    private Device device;  // todo fai in modo di partire da una classe astratta e poi via via specializzare

    @Column(name = "measured_value")
    private float measuredValue;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

}
