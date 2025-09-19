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
class RepositoryTopStatsImpl(
    @Value("\${database.apikey}") private val token:String,
    @Value("\${database.url}") private val url:String
): RepositoryTopStats {
    private val logger: Logger = LogManager.getLogger(RepositoryTopStatsImpl::class.java)
    override suspend fun getStatsByName(name: String, idCategory:String): Turso? {
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
                            "sql" to "SELECT\n" +
                                    "  r.rank,\n" +
                                    "  c.idCharacter,\n" +
                                    "  c.name,\n" +
                                    "  r.level,\n" +
                                    "  p.levels,\n" +
                                    "  p.gain_exp,\n" +
                                    "  p.progress,\n" +
                                    "  p.progress_percent,\n" +
                                    "  r.experience,\n" +
                                    "  r.experience_string,\n" +
                                    "  r.startDate,\n" +
                                    "  r.lastDate,\n" +
                                    "  r.startDateTimeStamp,\n" +
                                    "  r.lastDateTimeStamp,\n" +
                                    "  cat.name AS category_name\n" +
                                    "FROM Progress p\n" +
                                    "JOIN Character c ON c.idCharacter = p.idCharacter\n" +
                                    "JOIN Ranking r ON r.idCharacter = c.idCharacter AND r.idCategory = p.idCategory\n" +
                                    "JOIN Category cat ON p.idCategory = cat.idCategory\n" +
                                    "JOIN Date date on date.idDate = r.idDate\n" +
                                    "WHERE c.name = '$name' and cat.idCategory = '$idCategory'\n" +
                                    "ORDER BY date.date_timestamp DESC limit 7;"
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
                throw CustomError("Failed to obtain information")
            }
            response.body
        } catch (e: Exception){
            logger.error(e)
            throw CustomError("Failed to obtain information ")
        }
    }

    override suspend fun history(name: String, idDate:String): Turso? {
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
                            "sql" to "SELECT\n" +
                                    "  r.rank,\n" +
                                    "  cat.name AS category,\n" +
                                    "  c.name,\n" +
                                    "  r.level,\n" +
                                    "  p.levels,\n" +
                                    "  r.startDate,\n" +
                                    "  r.lastDate,\n" +
                                    "  r.startDateTimeStamp,\n" +
                                    "  r.lastDateTimeStamp\n" +
                                    "FROM Progress p\n" +
                                    "JOIN Character c ON c.idCharacter = p.idCharacter\n" +
                                    "JOIN Ranking r ON r.idCharacter = c.idCharacter AND r.idCategory = p.idCategory\n" +
                                    "JOIN Category cat ON p.idCategory = cat.idCategory\n" +
                                    "JOIN Date date on date.idDate = r.idDate\n" +
                                    "WHERE c.name = '$name' and date.idDate = '$idDate'\n" +
                                    "ORDER BY r.rank ASC;"
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
                throw CustomError("Failed to obtain information")
            }
            response.body
        } catch (e: Exception){
            logger.error(e)
            throw CustomError("Failed to obtain information ")
        }
    }
}