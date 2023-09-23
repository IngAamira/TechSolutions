package com.ingaamira.techsolutions.infrastructure.adapter;

import com.ingaamira.techsolutions.application.repository.OrderRepository;
import com.ingaamira.techsolutions.domain.Order;
import com.ingaamira.techsolutions.domain.User;
import com.ingaamira.techsolutions.infrastructure.mapper.OrderMapper;
import com.ingaamira.techsolutions.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * Esta clase implementa la interfaz OrderRepository y proporciona acceso a los datos de órdenes en la base de datos.
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderCrudRepository orderCrudRepository;
    private final OrderMapper orderMapper;
    private final UserMapper userMapper;

    public OrderRepositoryImpl(OrderCrudRepository orderCrudRepository, OrderMapper orderMapper, UserMapper userMapper) {
        this.orderCrudRepository = orderCrudRepository;
        this.orderMapper = orderMapper;
        this.userMapper = userMapper;
    }

    @Override
    public Order createOrder(Order order) {
        return orderMapper.toOrder(orderCrudRepository.save(orderMapper.toOrderEntity(order)));
    }

    @Override
    public Iterable<Order> getOrders() {
        return orderMapper.toOrders(orderCrudRepository.findAll());
    }


}
