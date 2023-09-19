package com.ingaamira.techsolutions.application.service;

import com.ingaamira.techsolutions.domain.User;
import com.ingaamira.techsolutions.domain.UserType;
import com.icodeapp.ecommerce.infrastructure.dto.UserDto;

public class LoginService {
    private final com.icodeapp.ecommerce.application.service.UserService userService;

    public LoginService(com.icodeapp.ecommerce.application.service.UserService userService) {
        this.userService = userService;
    }

    //retorna true si encuentra el user
    public boolean existUser(String email){
        try {
            User user = userService.findByEmail(email);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    //obtenemos el id del usuario
    public Integer getUserId(String email){
        try{
            return userService.findByEmail(email).getId();
        }catch (Exception e){
            return 0;
        }
    }

    //obtener tipo de usuario
    public UserType getUserType(String email){
        return userService.findByEmail(email).getUserType();
    }

    //obtenemos el user por email
    public User getuser(String email){
        try{
            return userService.findByEmail(email);
        }catch (Exception e){
            return new User();
        }
    }

    //obtenemos el user por id
    public User getUser(Integer id){
        try{
            return userService.findById(id);
        }catch (Exception e){
            return new User();
        }
    }

}
