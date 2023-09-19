package com.ingaamira.techsolutions.infrastructure.entity;

import com.ingaamira.techsolutions.domain.UserType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Clase que representa la entidad User en la base de datos.
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity {
    /**
     * Identificador único del usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nombre de usuario.
     */
    private String username;

    /**
     * Primer nombre del usuario.
     */
    private String firstName;

    /**
     * Apellido del usuario.
     */
    private String lastName;

    /**
     * Dirección de correo electrónico del usuario.
     */
    private String email;

    /**
     * Dirección del usuario.
     */
    private String address;

    /**
     * Número de teléfono celular del usuario.
     */
    private String cellphone;

    /**
     * Contraseña del usuario.
     */
    private String password;

    /**
     * Tipo de usuario (por ejemplo, ADMIN o USER).
     */
    @Enumerated(EnumType.STRING)
    private UserType userType;

    /**
     * Fecha en que se creó el registro de usuario.
     */
    private LocalDateTime dateCreated;

    // Resto de los atributos, constructores y métodos si los hubiera.

}
