package com.miguel.rucoyapi.data.repositories.db

import com.miguel.rucoyapi.data.entities.Turso
import com.miguel.rucoyapi.utils.enviroment.Enviroment
import com.miguel.rucoyapi.utils.execeptions.CustomError
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.postForEntity

@Repository
class RepositoryCategoryImpl(
    @Value("\${database.apikey}") private val token:String,
    @Value("\${database.url}") private val url:String
): RepositoryCategory, Enviroment() {
    private val logger: Logger = LogManager.getLogger(RepositoryCategoryImpl::class.java)
    private val tokenTurso = enviroment("apikey", token)
    private val urlTurso = enviroment("url", url)

    override suspend fun getAllCategory(): Turso? {
        return try {
            val header = HttpHeaders().apply {
                setBearerAuth(tokenTurso!!)
                contentType = MediaType.APPLICATION_JSON
            }
            val body =  mapOf(
                "requests" to listOf(
                    mapOf(
                        "type" to "execute",
                        "stmt" to mapOf(
                            "sql" to "select * from category"
                        )
                    ),
                    mapOf("type" to "close")
                )
            )
            logger.info("Body: $body")
            val request = HttpEntity(body,header)
            val response  = RestTemplate().postForEntity<Turso>(urlTurso!!, request = request, Turso::class.java)
            if (!response.statusCode.is2xxSuccessful){
                logger.error("Error: ${response.body}")
                throw CustomError("Failed to obtain category information")
            }
            response.body
        } catch (e: Exception){
            logger.error(e)
            throw CustomError("Failed to obtain category information ")
        }
    }
}