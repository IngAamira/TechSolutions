package com.ingaamira.techsolutions.infrastructure.controller;

import com.ingaamira.techsolutions.application.service.LoginService;
import com.ingaamira.techsolutions.infrastructure.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para gestionar el proceso de inicio de sesión y redireccionar según el tipo de usuario.
 */
@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * Maneja la solicitud para mostrar la página de inicio de sesión.
     *
     * @return La vista de inicio de sesión.
     */
    @GetMapping
    public String login(){
        return "login";
    }

    @PostMapping
    public String access(UserDto userDto, HttpSession httpSession) {
        userDto.setEmail(userDto.getUsername());
        log.info("userDto email: {}", userDto.getEmail());
        log.info("userDto pass: {}", userDto.getPassword());
        //userDto.setPassword(userDto.getPassword());
        if (loginService.existUser(userDto)) {
            httpSession.setAttribute("iduser", loginService.getUserId(userDto.getEmail()));
            if (loginService.getUserType(userDto).name().equals("ADMIN")){
                return "redirect:/admin";
            } else {
                return "redirect:/home";
            }
        }
        return "redirect:/home";
     }

}