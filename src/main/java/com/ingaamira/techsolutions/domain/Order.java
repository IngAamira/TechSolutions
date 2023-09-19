package com.ingaamira.techsolutions.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Esta clase representa una orden de compra en la aplicación.
 */
@Data
public class Order {

    private Integer id;
    private LocalDateTime dateCreated;
    private List<OrderProduct> orderProducts;
    private User user;

    /**
     * Agrega los productos de orden a la orden.
     *
     * @param orderProducts La lista de productos de orden a agregar.
     */
    public void addOrdersProduct(List<OrderProduct> orderProducts) {
        this.setOrderProducts(orderProducts);
    }

    /**
     * Calcula el precio total de la orden sumando los precios totales de los productos de orden.
     *
     * @return El precio total de la orden.
     */
    public BigDecimal getTotalOrderPrice() {
        return getOrderProducts().stream()
                .map(OrderProduct::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}
