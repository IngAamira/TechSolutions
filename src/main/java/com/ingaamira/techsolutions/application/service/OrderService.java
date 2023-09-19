package com.ingaamira.techsolutions.application.service;

import com.icodeapp.ecommerce.application.repository.OrderRepository;
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

    /**
     * Obtiene todas las órdenes asociadas a un usuario específico.
     *
     * @param user El usuario para el cual se quieren obtener las órdenes.
     * @return Una colección de órdenes asociadas al usuario dado.
     */
    public Iterable<Order> getOrdersByuser(User user) {
        return orderRepository.getOrdersByUser(user);
    }

}
