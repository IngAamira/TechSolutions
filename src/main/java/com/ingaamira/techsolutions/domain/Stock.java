package com.ingaamira.techsolutions.domain;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Esta clase representa un registro de inventario de productos en la aplicación.
 */
@Data
@ToString
public class Stock {

    private Integer id;
    private LocalDateTime dateCreated;
    private Integer unitIn;
    private Integer unitOut;
    private String description;
    private Integer balance;
    private Product product;

}
