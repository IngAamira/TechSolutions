package com.ingaamira.techsolutions.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Entidad que representa una orden en la base de datos.
 */
@Entity
@Table(name = "orders")
@Data
public class OrderEntity {

    /**
     * Identificador único de la orden.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * La fecha en que se creó la orden.
     */
    private LocalDateTime dateCreated;

    /**
     * El usuario asociado a esta orden.
     */
    @ManyToOne
    private UserEntity user;

}
