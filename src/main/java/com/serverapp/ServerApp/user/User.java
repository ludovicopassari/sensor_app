package com.serverapp.ServerApp.user;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Definiamo una classe che verrà mappata sulla tabella "user" del DB.
 *
 * Non implementiamo un autenticazione in quanto non è tra i requisiti ma comunque, in un ottica futura, introduciamo gli attributi che eventualmente permettono di farlo
 */


@Data
@Entity // dice a Spring che questa classe verrà mappata su una entità del un DB
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"email", "username"})})

// todo qui puoi implemntare l'ereditarietà creando una classe persona che viene estesa da User
// todo implemntiamo anche il polimorfismo inventandoci qualche metodo di cui fare override
public class User {

    @Id //dice a Spring di usare questa variabile di istanza come chiave primaria dell'entità
    @Column(name = "id", nullable = false)  // todo non so se è necessario specificare "nullable = false" in quanto il concetto dovrebbe essere implicito nella definizione di chiave promaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //fa in modo che la chiave primaria si AUTO_INCREMENT
    private Long userId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

}
