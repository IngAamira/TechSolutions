package com.ingaamira.techsolutions.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

/**
 * Clase que representa la entidad Stock en la base de datos.
 */
@Entity
@Table(name = "stock")
@NoArgsConstructor
@Data
public class StockEntity {
    /**
     * Identificador único del registro de stock.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Fecha en que se creó el registro de stock.
     */
    private LocalDateTime dateCreated;

    /**
     * Cantidad de unidades que ingresaron.
     */
    private Integer unitIn;

    /**
     * Cantidad de unidades que salieron.
     */
    private Integer unitOut;

    /**
     * Descripción del registro de stock.
     */
    private String description;

    /**
     * Saldo actual de unidades en stock.
     */
    private Integer balance;

    /**
     * Producto asociado a este registro de stock.
     */
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProductEntity productEntity;

}