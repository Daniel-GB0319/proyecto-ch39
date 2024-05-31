package com.codegaiden.barro_on;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Configuracion global para el CORS (en especifico seria con @CrossOrigin para endpoint en Controller)


@Configuration
public class CorsGlobalConfig {

    @Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://127.0.0.1:5501") // Aquí pon la URL de tu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}}

//     @Bean
//     public WebMvcConfigurer corsConfigurer() {
//         return new WebMvcConfigurer() {
//             @Override
//             public void addCorsMappings(CorsRegistry registry) {
//                 registry.addMapping("/**") // Endpoints del backend que se permiten con CORS
//                         .allowedOrigins("http://localhost:8080", "http://example.com") // Permite acceso desde estos orígenes específicos
//                         .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
//                         .allowedHeaders("Content-Type", "Authorization", "X-Requested-With", "Accept") // Headers permitidos
//                         .allowCredentials(true) // Permite credenciales
//                         .maxAge(3600); // Tiempo máximo que se pueden cachear las respuestas de preflight
//             }
//         };
//     }
// }


// @Configuration
// public class CorsGlobalConfig {

//     @Bean
//     public WebMvcConfigurer corsConfigurer() {
//         return new WebMvcConfigurer() {
//             @Override
//             public void addCorsMappings(CorsRegistry registry) {
//                 registry.addMapping("/**") // Endpoints del back que se permiten con CORS (/api/usuarios, etc)
//                         .allowedOrigins("*") // Permite acceso desde cualquier origen (http://172.0.0.1/8080...)
//                         .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                         .allowedHeaders("*") // Permite todos los headers (content-type/json, etc)
//                         .allowCredentials(true) // Permite credenciales
//                         .maxAge(3600); // Tiempo máximo que se pueden cachear las respuestas de preflight
//             }
//         };
//     }
// }



