package com.ingaamira.techsolutions.application.service;

import com.ingaamira.techsolutions.domain.User;

/**
 * Esta clase proporciona métodos para manejar el proceso de registro de usuarios en la aplicación.
 */
public class RegistrationService {

    private final UserService userService;

    /**
     * Constructor de la clase RegistrationService.
     *
     * @param userService     El servicio de usuarios utilizado para acceder a los datos de usuarios.
     //* @param passwordEncoder El codificador de contraseñas utilizado para cifrar las contraseñas de los usuarios.
     */
    public RegistrationService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Registra a un nuevo usuario en la aplicación.
     *
     * @param user El usuario a registrar.
     */
    public void register(User user) {
        userService.createUser(user);
    }

}
