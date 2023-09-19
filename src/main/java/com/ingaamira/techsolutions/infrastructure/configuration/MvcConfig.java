package com.ingaamira.techsolutions.infrastructure.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Esta clase de configuración personaliza la configuración de MVC para la aplicación.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * Agrega un manejador de recursos para las imágenes de la aplicación.
     *
     * @param registry El registro de manejadores de recursos.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:images/");
    }

}
