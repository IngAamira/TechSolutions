package com.ingaamira.techsolutions.application.repository;

import com.ingaamira.techsolutions.domain.User;

/**
 * Esta interfaz define las operaciones para acceder a los usuarios en el repositorio.
 */
public interface UserRepository {

    /**
     * Crea un nuevo usuario en el repositorio.
     *
     * @param user El usuario a crear.
     * @return El usuario creado.
     */
    User createUser(User user);

    /**
     * Busca un usuario por su dirección de correo electrónico.
     *
     * @param email La dirección de correo electrónico del usuario a buscar.
     * @return El usuario correspondiente a la dirección de correo electrónico dada, o null si no se encuentra.
     */
    User findByEmail(String email);

    /**
     * Busca un usuario por su ID.
     *
     * @param id El ID del usuario a buscar.
     * @return El usuario correspondiente al ID dado, o null si no se encuentra.
     */
    User findById(Integer id);

}
