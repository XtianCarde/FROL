package com.riwi.frol.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Api para administracion de reservas entre compañias y clientes",
        version = "1.0",
        description = "Esta api es creada para el desarrollo e implementación de springboot"
    )
)
public class OpenApiConfig {
    
}
