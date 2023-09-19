package com.ingaamira.techsolutions.application.repository;

import com.icodeapp.ecommerce.domain.Order;
import com.icodeapp.ecommerce.domain.User;

/**
 * Esta interfaz define las operaciones para acceder a las órdenes en el repositorio.
 */
public interface OrderRepository {

    /**
     * Crea una nueva orden en el repositorio.
     *
     * @param order La orden a crear.
     * @return La orden creada.
     */
    Order createOrder(Order order);

    /**
     * Obtiene todas las órdenes almacenadas en el repositorio.
     *
     * @return Una colección de órdenes.
     */
    Iterable<Order> getOrders();

    /**
     * Obtiene todas las órdenes asociadas a un usuario específico.
     *
     * @param user El usuario para el cual se quieren obtener las órdenes.
     * @return Una colección de órdenes asociadas al usuario dado.
     */
    Iterable<Order> getOrdersByUser(User user);
}
