package com.ingaamira.techsolutions.application.service;

import com.ingaamira.techsolutions.application.repository.OrderRepository;
import com.ingaamira.techsolutions.domain.Order;
import com.ingaamira.techsolutions.domain.User;

/**
 * Esta clase proporciona métodos para manejar las órdenes en la aplicación.
 */
public class OrderService {

    private final OrderRepository orderRepository;

    /**
     * Constructor de la clase OrderService.
     *
     * @param orderRepository El repositorio de órdenes utilizado para acceder a los datos.
     */
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Crea una nueva orden.
     *
     * @param order La orden a crear.
     * @return La orden creada.
     */
    public Order createOrder(Order order) {
        return orderRepository.createOrder(order);
    }

    /**
     * Obtiene todas las órdenes almacenadas.
     *
     * @return Una colección de órdenes.
     */
    public Iterable<Order> getOrders() {
        return orderRepository.getOrders();
    }

    public Iterable<Order> getOrdersByUser(User user) {
        return orderRepository.getOrdersByUser(user);
    }

}
