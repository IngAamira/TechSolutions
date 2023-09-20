package com.ingaamira.techsolutions.application.service;

import com.ingaamira.techsolutions.domain.User;
import com.ingaamira.techsolutions.domain.UserType;
import com.ingaamira.techsolutions.infrastructure.dto.UserDto;

public class LoginService {
    private final UserService userService;

    public LoginService(UserService userService) {
        this.userService = userService;
    }


        public boolean existUser(UserDto userDto) {
        try {
            User user = userService.findByEmail(userDto.getEmail());
        }catch (Exception e) {
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
    public UserType getUserType(UserDto userDto){
        return userService.findByEmail(userDto.getEmail()).getUserType();
    }

    //obtenemos el user por email
    public User getuser(String email){
        try{
            return userService.findByEmail(email);
        }catch (Exception e){
            return new User();
        }
    }

}
