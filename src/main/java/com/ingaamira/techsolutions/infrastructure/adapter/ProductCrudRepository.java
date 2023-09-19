package com.ingaamira.techsolutions.infrastructure.adapter;

import com.ingaamira.techsolutions.infrastructure.entity.ProductEntity;
import com.ingaamira.techsolutions.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Esta interfaz proporciona métodos para acceder a los datos de productos en la base de datos.
 */
public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {

    /**
     * Busca y devuelve una lista de productos asociados a un usuario específico.
     *
     * @param userEntity El usuario para el cual se desean buscar los productos.
     * @return Una lista de productos asociados al usuario dado.
     */
    Iterable<ProductEntity> findByUserEntity(UserEntity userEntity);

}
