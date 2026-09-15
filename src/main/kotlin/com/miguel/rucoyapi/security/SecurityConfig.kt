package com.miguel.rucoyapi.security

import com.miguel.rucoyapi.utils.enviroment.Environment
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.SecurityWebFiltersOrder
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain


@Configuration
@EnableWebFluxSecurity
class SecurityConfig(
    private val jwtFilter: JwtFilter   // Spring inyecta la instancia del @Component
): Environment() {

    @Value("\${rucoy.api.pathToken}")
    lateinit var pathToken: String
    @Value("\${rucoy.api.paths}")
    lateinit var paths: String

    @Bean
    fun securityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http
            .csrf { it.disable() }
            .authorizeExchange {
                it.pathMatchers("/auth/**").permitAll()
                it.pathMatchers(environment("pathToken", pathToken)).permitAll()
                it.pathMatchers(environment("paths", paths)).authenticated()
                it.anyExchange().authenticated()
            }
            .addFilterAt(jwtFilter, SecurityWebFiltersOrder.AUTHENTICATION)
            .build()
    }
}