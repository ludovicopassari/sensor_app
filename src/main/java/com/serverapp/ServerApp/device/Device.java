package com.serverapp.ServerApp.device;

/*DEPENDENCIES IMPORT*/
import com.serverapp.ServerApp.sensor.Sensor;
import com.serverapp.ServerApp.measurement.Measurement;
import com.serverapp.ServerApp.user.User;
import jakarta.persistence.*;

/*ANNOTATION IMPORT*/
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import  java.util.List;


/**
 * Definiamo una classe che verrà mappata sulla tabella device del DB"
 * In questa implementazione assumiamo che un Device possa essere posseduto da un User ne possa possedere N.
 */


@Entity
@Table(name = "device")
public class Device {

    @Id //specifica che questa variabile di istanza verrà mappata sulla chiave primaria dell'entità
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //questo specifica la chiave primaria come AUTO_INCREMENT
    private Long id;

    @Column(name = "device_name")
    private String deviceName;

    @ManyToOne      //specifica una relazione N a 1 verso l'utente e quindi specifica piu Device possono essere posseduti da un utente
    @JoinColumn(name = "user_id", nullable = false)     //JoinColumn serve a definire una colonna che è una chiave esterna.
    private User user;

    @ManyToMany //specifica una relazione N a N. In questo caso specifica che un device puo montare piu sensori
    @JoinTable(name = "mounted_sensors", joinColumns = @JoinColumn(name = "device_id"), inverseJoinColumns = @JoinColumn(name = "sensor_id"))   //serve a definire la terza tabella(JoinTable) i cui appariranno
    private List<Sensor> sensors;

    @OneToMany(mappedBy = "device") //questo specifica una relazione 1 a N per rappresentare il fatto che un Device effettuà N misurazioni
    private List<Measurement> measurements;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

}
