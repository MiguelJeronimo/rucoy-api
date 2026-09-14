package com.miguel.rucoyapi.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.miguel.rucoyapi.utils.execeptions.CustomError
import com.miguel.rucoyapi.utils.execeptions.ErrorAuthorizer
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.ReactiveSecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono


@Component
class JwtFilter(private val config: Config): WebFilter {
    private val  mapper = ObjectMapper()
    /**
     * Filters the incoming request to validate the JWT token.
     * @param exchange The server web exchange.
     * @param chain The web filter chain.
     * @return A mono indicating the completion of the filter.
     */
    override fun filter(
        exchange: ServerWebExchange,
        chain: WebFilterChain
    ): Mono<Void?> {
        val path = exchange.request.uri.path
        if (path.startsWith("/auth")) {
            return chain.filter(exchange)
        }

        val authHeader = exchange.request.headers.getFirst("Authorization")
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return unauthorized(exchange, "Required token")
        }

        val token = authHeader.substring(7)
        return try {
            if (config.validateToken(token)) {
                val username = config.getUsuario(token) ?: "guest"
                val auth = UsernamePasswordAuthenticationToken(
                    username,
                    null,
                    listOf(SimpleGrantedAuthority("ROLE_USER"))
                )
                chain.filter(exchange)
                    .contextWrite(ReactiveSecurityContextHolder.withAuthentication(auth))
            } else {
                unauthorized(exchange, "Invalid token")
            }
        } catch (e: Exception) {
            unauthorized(exchange, "Invalid token: ${e.message}")
        }
    }

    private fun unauthorized(exchange: ServerWebExchange, message: String): Mono<Void?> {
        val response = exchange.response
        response.statusCode = HttpStatus.UNAUTHORIZED
        response.headers.contentType = MediaType.APPLICATION_JSON
        val errorJson = mapper.writeValueAsBytes(
            ErrorAuthorizer(error = "Unauthorized", message = message)
        )
        val buffer = response.bufferFactory().wrap(errorJson)
        return response.writeWith(Mono.just(buffer))
    }
}