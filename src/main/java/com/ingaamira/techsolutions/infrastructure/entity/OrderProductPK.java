package com.ingaamira.techsolutions.infrastructure.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * Clase que representa la clave primaria compuesta de la entidad OrderProductEntity.
 */
@Data
@Embeddable
public class OrderProductPK {

    /**
     * La entidad OrderEntity que forma parte de la clave primaria.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderEntity orderEntity;

    /**
     * La entidad ProductEntity que forma parte de la clave primaria.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity productEntity;

    // Resto de los atributos, constructores y métodos si los hubiera.

}
