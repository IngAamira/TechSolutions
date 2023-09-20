package com.ingaamira.techsolutions.infrastructure.controller;

import com.ingaamira.techsolutions.application.service.RegistrationService;
import com.ingaamira.techsolutions.infrastructure.dto.UserDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/register")
@Slf4j
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    /**
     * Muestra la vista de registro de usuario.
     *
     * @param userDto El DTO del usuario a ser registrado.
     * @return La vista de registro.
     */
    @GetMapping
    public String register(UserDto userDto){
        return "register";
    }


    /**
     * Procesa la solicitud de registro de usuario.
     *
     * @param userDto           El DTO del usuario a ser registrado.
     * @param bindingResult     Resultado de la validación del formulario.
     * @param redirectAttributes Atributos para redireccionamiento y mensajes flash.
     * @return Redirige al usuario a la página de registro después de completar el registro.
     */
    @PostMapping
    public String registerUser(@Valid UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(
                    e -> { log.info( "Error {}", e.getDefaultMessage() ); }
            );
            return "register";
        }

        registrationService.register(userDto.userDtoToUser());
        redirectAttributes.addFlashAttribute("success", "Usuario creado correctamente");
        return "redirect:/register";
    }

}
