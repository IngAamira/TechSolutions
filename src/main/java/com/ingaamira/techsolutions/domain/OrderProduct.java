package com.ingaamira.techsolutions.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Esta clase representa un producto asociado a una orden de compra en la aplicación.
 */
@Data
public class OrderProduct {

    private Product product;
    private Integer quantity;
    private Order order;

    /**
     * Constructor de la clase OrderProduct.
     *
     * @param product  El producto asociado al producto de orden.
     * @param quantity La cantidad del producto en la orden.
     * @param order    La orden a la que pertenece el producto de orden.
     */
    public OrderProduct(Product product, Integer quantity, Order order) {
        this.product = product;
        this.quantity = quantity;
        this.order = order;
    }

    /**
     * Calcula el precio total del producto de orden multiplicando el precio del producto por la cantidad.
     *
     * @return El precio total del producto de orden.
     */
    public BigDecimal getTotalPrice() {
        return this.product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

}
