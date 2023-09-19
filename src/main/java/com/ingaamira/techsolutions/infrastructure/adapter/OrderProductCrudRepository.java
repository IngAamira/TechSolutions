package com.ingaamira.techsolutions.infrastructure.adapter;

import com.ingaamira.techsolutions.infrastructure.entity.OrderEntity;
import com.ingaamira.techsolutions.infrastructure.entity.OrderProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Esta interfaz proporciona métodos para acceder a los datos de productos de órdenes en la base de datos.
 */
public interface OrderProductCrudRepository extends CrudRepository<OrderProductEntity, Integer> {

    /**
     * Busca y devuelve una lista de productos de órdenes asociados a una orden específica.
     *
     * @param orderEntity La orden para la cual se desean buscar los productos de órdenes.
     * @return Una lista de productos de órdenes asociados a la orden dada.
     */
    List<OrderProductEntity> findByPkOrderEntity(OrderEntity orderEntity);

}
