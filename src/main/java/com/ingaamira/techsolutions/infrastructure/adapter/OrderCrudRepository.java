package com.ingaamira.techsolutions.infrastructure.adapter;

import com.ingaamira.techsolutions.infrastructure.entity.OrderEntity;
import com.ingaamira.techsolutions.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Esta interfaz proporciona métodos para acceder a los datos de órdenes en la base de datos.
 */
public interface OrderCrudRepository extends CrudRepository<OrderEntity, Integer> {

    /**
     * Busca y devuelve una lista de órdenes asociadas a un usuario específico.
     *
     * @param userEntity El usuario para el cual se desean buscar las órdenes.
     * @return Una lista de órdenes asociadas al usuario dado.
     */
    Iterable<OrderEntity> findByUser(UserEntity userEntity);

}
