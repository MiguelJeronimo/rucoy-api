package com.miguel.rucoyapi.security

import com.miguel.rucoyapi.utils.enviroment.Environment
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.util.Date
import javax.crypto.SecretKey

@Component
class Config(
    @Value("\${rucoy.api.secret}") var secret: String
): Environment() {
    private val logger = LogManager.getLogger()
    val environmentSecret = environment("secret", secret)?: throw IllegalStateException("Secret key not found in environment variables")
    val key: SecretKey = Keys.hmacShaKeyFor(environmentSecret.toByteArray(StandardCharsets.UTF_8))

    //esto no se esta usando
    fun generateToken(username:String): String? {
        // 1 hora de expiración
        val currentDate = Date()
        val now = System.currentTimeMillis()
        val expiresAt = Date(now + 3600 * 1000) // 1 hora
        return Jwts.builder()
            .subject(username)
            .claim("role","ROLE_USER")
            .issuedAt(currentDate)
            .expiration(expiresAt)
            .signWith(key)
            .compact()
    }

    fun validateToken(token:String): Boolean {
        return try {
            val claims = Jwts.parser().verifyWith(key).build().parseSignedClaims(token)
            val exp = claims.payload.expiration
            exp == null || !exp.before(Date())//Validate token without defeat time or defeat token
        }catch (e: JwtException){
            logger.info("Token invalid: ${e.message}")
            false
        }catch (e: Exception){
            logger.info("Token invalid: ${e.message}")
            false
        }
    }

    fun getUsuario(token: String): String? {
        return try {
            val claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
            claims.payload.subject
        } catch (e: Exception) {
            null
        }
    }
}