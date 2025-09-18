package com.miguel.rucoyapi.data.repositories.db

import com.miguel.rucoyapi.data.entities.Turso
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
class RepositoryDateImpl(
    @Value("\${database.apikey}") private val token:String,
    @Value("\${database.url}") private val url:String
): RepositoryDate {
    private val logger: Logger = LogManager.getLogger(RepositoryDateImpl::class.java)
    override suspend fun getCurrentDate(): Turso? {
        return try {
            val header = HttpHeaders().apply {
                setBearerAuth(token)
                contentType = MediaType.APPLICATION_JSON
            }
            val body =  mapOf(
                "requests" to listOf(
                    mapOf(
                        "type" to "execute",
                        "stmt" to mapOf(
                            "sql" to "SELECT * FROM Date d ORDER BY d.date_timestamp DESC LIMIT 1"
                        )
                    ),
                    mapOf("type" to "close")
                )
            )
            logger.info("Body: $body")
            val request = HttpEntity(body,header)
            val response  = RestTemplate().postForEntity<Turso>(url, request = request, Turso::class.java)
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