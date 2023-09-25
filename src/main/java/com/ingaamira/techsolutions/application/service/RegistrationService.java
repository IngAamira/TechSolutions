package com.ingaamira.techsolutions.application.service;

import com.ingaamira.techsolutions.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Esta clase proporciona métodos para manejar el proceso de registro de usuarios en la aplicación.
 */
public class RegistrationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createUser(user);
    }

}