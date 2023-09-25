package com.ingaamira.techsolutions.infrastructure.configuration;

import com.ingaamira.techsolutions.application.repository.*;
import com.ingaamira.techsolutions.application.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.WebApplicationContext;


/**
 * Esta clase de configuración define y configura los beans utilizados en la aplicación.
 */
@Configuration
public class BeanConfiguration {

    /**
     * Define un bean para el servicio de productos.
     *
     * @param productRepository El repositorio de productos.
     * @param uploadFile El servicio de carga de archivos.
     * @return El servicio de productos configurado.
     */
    @Bean
    public ProductService productService(ProductRepository productRepository, UploadFile uploadFile){
        return new ProductService(productRepository, uploadFile);
    }

    @Bean
    public UploadFile uploadFile(){
        return new UploadFile();
    }

    @Bean
    public StockService stockService(StockRepository stockRepository){
        return new StockService(stockRepository);
    }

    @Bean
    public ValidateStock validateStock(StockService stockService){
        return new ValidateStock(stockService);
    }

    @Bean
    public OrderService orderService(OrderRepository orderRepository){
        return new OrderService(orderRepository);
    }

    @Bean
    public OrderProductService orderProductService(OrderProductRepository orderProductRepository){
        return  new OrderProductService(orderProductRepository);
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public  CartService cartService(){
        return  new CartService();
    }

    @Bean
    public UserService userService(UserRepository userRepository){
        return  new UserService(userRepository);
    }

    /**
     * Define un bean para el servicio de registro de usuarios.
     *
     * @param userService El servicio de usuarios.
     //* @param passwordEncoder El codificador de contraseñas.
     * @return El servicio de registro de usuarios configurado.
     */
    @Bean
    public RegistrationService registrationService(UserService userService, PasswordEncoder passwordEncoder){
        return  new RegistrationService(userService, passwordEncoder);
    }

    /**
     * Define un bean para el servicio de inicio de sesión.
     *
     * @param userService El servicio de usuarios.
     * @return El servicio de inicio de sesión configurado.
     */
    @Bean
    public LoginService loginService(UserService userService){
        return new LoginService(userService);
    }

    /**
     * Define un bean para el servicio de cierre de sesión.
     *
     * @return El servicio de cierre de sesión configurado.
     */
    @Bean
    public LogoutService logoutService(){
        return  new LogoutService();
    }

}
