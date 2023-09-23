package com.ingaamira.techsolutions.application.service;

import jakarta.servlet.http.HttpSession;

/**
 * Esta clase proporciona un método para gestionar el cierre de sesión de un usuario.
 */
public class LogoutService {

    /**
     * Constructor de la clase LogoutService.
     */
    public LogoutService() {
    }

    /**
     * Cierra la sesión del usuario removiendo el atributo "iduser" de la sesión.
     *
     * @param httpSession La sesión HTTP del usuario que se va a cerrar.
     */
    public void logout(HttpSession httpSession) {
        httpSession.removeAttribute("iduser");
    }

}