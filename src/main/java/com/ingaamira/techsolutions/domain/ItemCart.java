package com.ingaamira.techsolutions.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Esta clase representa un elemento en el carrito de compras.
 */
@Data
@AllArgsConstructor
@ToString
public class ItemCart {

    private Integer idProduct;
    private String nameProduct;
    private Integer quantity;
    private BigDecimal price;

    /**
     * Calcula el precio total del elemento en el carrito.
     *
     * @return El precio total del elemento en el carrito.
     */
    public BigDecimal getTotalPriceItem() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

}
