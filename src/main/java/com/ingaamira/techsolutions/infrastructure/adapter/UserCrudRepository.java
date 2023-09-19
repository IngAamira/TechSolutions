package com.ingaamira.techsolutions.infrastructure.adapter;

import com.ingaamira.techsolutions.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Esta interfaz proporciona métodos para acceder a los datos de usuarios en la base de datos.
 */
public interface UserCrudRepository extends CrudRepository<UserEntity, Integer> {

    /**
     * Busca y devuelve un usuario asociado a un correo electrónico específico.
     *
     * @param email El correo electrónico del usuario que se desea buscar.
     * @return Un Optional que contiene el usuario si se encuentra, o vacío si no se encuentra.
     */
    Optional<UserEntity> findByEmail(String email);

}
