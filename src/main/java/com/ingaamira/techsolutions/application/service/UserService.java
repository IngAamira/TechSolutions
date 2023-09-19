package com.ingaamira.techsolutions.application.service;

import com.icodeapp.ecommerce.application.repository.UserRepository;
import com.icodeapp.ecommerce.domain.User;


/**
 * Esta clase proporciona métodos para manejar los usuarios en la aplicación.
 */
public class UserService {
    private final UserRepository userRepository;

    /**
     * Constructor de la clase UserService.
     *
     * @param userRepository El repositorio de usuarios utilizado para acceder a los datos de los usuarios.
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Crea un nuevo usuario en la aplicación.
     *
     * @param user El usuario a crear.
     * @return El usuario creado.
     */
    public User createUser(User user) {
        return userRepository.createUser(user);
    }

    /**
     * Busca un usuario por su dirección de correo electrónico.
     *
     * @param email La dirección de correo electrónico del usuario a buscar.
     * @return El usuario correspondiente a la dirección de correo electrónico dada, o null si no se encuentra.
     */
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Busca un usuario por su ID.
     *
     * @param id El ID del usuario a buscar.
     * @return El usuario correspondiente al ID dado, o null si no se encuentra.
     */
    public User findById(Integer id) {
        return userRepository.findById(id);
    }

}
