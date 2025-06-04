package com.miguel.rucoyapi.controller;  // Ajusta el paquete

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    // Endpoint básico para Railway (ruta raíz "/")
    @GetMapping("/")
    public String home() {
        return "Rucoy API Online";  // Mensaje simple
    }

    // Health Check avanzado (para Actuator)
    @Bean
    public HealthIndicator customHealth() {
        return () -> Health.up()
                .withDetail("service", "rucoy-stats")
                .build();
    }
}
