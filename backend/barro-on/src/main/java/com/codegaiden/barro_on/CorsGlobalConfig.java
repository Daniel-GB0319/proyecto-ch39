package com.codegaiden.barro_on;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Configuracion global para el CORS (en especifico seria con @CrossOrigin para endpoint en Controller)
@Configuration
public class CorsGlobalConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Endpoints del back que se permiten con CORS (/api/usuarios, etc)
                        .allowedOrigins("*") // Permite acceso desde cualquier origen (http://172.0.0.1/8080...)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*") // Permite todos los headers (content-type/json, etc)
                        .allowCredentials(false) // Permite credenciales
                        .maxAge(3600); // Tiempo máximo que se pueden cachear las respuestas de preflight
            }
        };
    }
}
