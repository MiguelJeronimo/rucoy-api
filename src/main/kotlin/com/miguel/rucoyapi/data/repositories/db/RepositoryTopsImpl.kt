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
class RepositoryTopsImpl(
    @Value("\${database.apikey}") private val token:String,
    @Value("\${database.url}") private val url:String
): RepositoryTops, Enviroment() {
    private val logger: Logger = LogManager.getLogger(RepositoryTopsImpl::class.java)
    private val tokenTurso = enviroment("apikey", token)
    private val urlTurso = enviroment("url", url)

    override suspend fun experience(page: Int, size: Int, id:String, idSnapshot:String): Turso? {
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
                            "sql" to "SELECT\n" +
                                    "  r.rank,\n" +
                                    "  c.idCharacter,\n" +
                                    "  c.name,\n" +
                                    "  r.level,\n" +
                                    "  r.startDateTimeStamp,\n" +
                                    "  r.lastDateTimeStamp,\n" +
                                    "  r.startDate,\n" +
                                    "  r.lastDate,\n" +
                                    "  r.experience,\n" +
                                    "  r.experience_string,\n" +
                                    "  p.levels,\n" +
                                    "  p.gain_exp,\n" +
                                    "  p.progress_percent,\n" +
                                    "  cat.name AS category_name\n" +
                                    "FROM Progress p\n" +
                                    "JOIN Character c ON c.idCharacter = p.idCharacter\n" +
                                    "JOIN Ranking r ON r.idCharacter = c.idCharacter AND r.idCategory = p.idCategory\n" +
                                    "JOIN Category cat ON p.idCategory = cat.idCategory\n" +
                                    "JOIN Date date on date.idDate = r.idDate\n" +
                                    "WHERE cat.idCategory = '$id' and date.idDate = '$idSnapshot'\n" +
                                    "ORDER BY r.level DESC\n" +
                                    "  LIMIT $size OFFSET $page;"
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
                throw CustomError("Failed to obtain information")
            }
            response.body
        } catch (e: Exception){
            logger.error(e)
            throw CustomError("Failed to obtain information ")
        }
    }

    override suspend fun melee(page: Int, size: Int, id:String, idSnapshot:String): Turso? {
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
                            "sql" to "SELECT\n" +
                                    "  r.rank,\n" +
                                    "  c.idCharacter,\n" +
                                    "  c.name,\n" +
                                    "  r.level,\n" +
                                    "  r.startDateTimeStamp,\n" +
                                    "  r.lastDateTimeStamp,\n" +
                                    "  r.startDate,\n" +
                                    "  r.lastDate,\n" +
                                    "  r.experience,\n" +
                                    "  r.experience_string,\n" +
                                    "  p.levels,\n" +
                                    "  p.gain_exp,\n" +
                                    "  p.progress_percent,\n" +
                                    "  cat.name AS category_name\n" +
                                    "FROM Progress p\n" +
                                    "JOIN Character c ON c.idCharacter = p.idCharacter\n" +
                                    "JOIN Ranking r ON r.idCharacter = c.idCharacter AND r.idCategory = p.idCategory\n" +
                                    "JOIN Category cat ON p.idCategory = cat.idCategory\n" +
                                    "JOIN Date date on date.idDate = r.idDate\n" +
                                    "WHERE cat.idCategory = '$id' and date.idDate = '$idSnapshot'\n" +
                                    "ORDER BY r.level DESC\n" +
                                    "  LIMIT $size OFFSET $page;"
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
                throw CustomError("Failed to obtain information")
            }
            response.body
        } catch (e: Exception){
            logger.error(e)
            throw CustomError("Failed to obtain information ")
        }
    }

    override suspend fun distance(page: Int, size: Int, id:String, idSnapshot:String): Turso? {
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
                            "sql" to "SELECT\n" +
                                    "  r.rank,\n" +
                                    "  c.idCharacter,\n" +
                                    "  c.name,\n" +
                                    "  r.level,\n" +
                                    "  r.startDateTimeStamp,\n" +
                                    "  r.lastDateTimeStamp,\n" +
                                    "  r.startDate,\n" +
                                    "  r.lastDate,\n" +
                                    "  r.experience,\n" +
                                    "  r.experience_string,\n" +
                                    "  p.levels,\n" +
                                    "  p.gain_exp,\n" +
                                    "  p.progress_percent,\n" +
                                    "  cat.name AS category_name\n" +
                                    "FROM Progress p\n" +
                                    "JOIN Character c ON c.idCharacter = p.idCharacter\n" +
                                    "JOIN Ranking r ON r.idCharacter = c.idCharacter AND r.idCategory = p.idCategory\n" +
                                    "JOIN Category cat ON p.idCategory = cat.idCategory\n" +
                                    "JOIN Date date on date.idDate = r.idDate\n" +
                                    "WHERE cat.idCategory = '$id' and date.idDate = '$idSnapshot'\n" +
                                    "ORDER BY r.level DESC\n" +
                                    "  LIMIT $size OFFSET $page;"
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
                throw CustomError("Failed to obtain information")
            }
            response.body
        } catch (e: Exception){
            logger.error(e)
            throw CustomError("Failed to obtain information ")
        }
    }

    override suspend fun magic(page: Int, size: Int, id:String, idSnapshot:String): Turso? {
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
                            "sql" to "SELECT\n" +
                                    "  r.rank,\n" +
                                    "  c.idCharacter,\n" +
                                    "  c.name,\n" +
                                    "  r.level,\n" +
                                    "  r.startDateTimeStamp,\n" +
                                    "  r.lastDateTimeStamp,\n" +
                                    "  r.startDate,\n" +
                                    "  r.lastDate,\n" +
                                    "  r.experience,\n" +
                                    "  r.experience_string,\n" +
                                    "  p.levels,\n" +
                                    "  p.gain_exp,\n" +
                                    "  p.progress_percent,\n" +
                                    "  cat.name AS category_name\n" +
                                    "FROM Progress p\n" +
                                    "JOIN Character c ON c.idCharacter = p.idCharacter\n" +
                                    "JOIN Ranking r ON r.idCharacter = c.idCharacter AND r.idCategory = p.idCategory\n" +
                                    "JOIN Category cat ON p.idCategory = cat.idCategory\n" +
                                    "JOIN Date date on date.idDate = r.idDate\n" +
                                    "WHERE cat.idCategory = '$id' and date.idDate = '$idSnapshot'\n" +
                                    "ORDER BY r.level DESC\n" +
                                    "  LIMIT $size OFFSET $page;"
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
                throw CustomError("Failed to obtain information")
            }
            response.body
        } catch (e: Exception){
            logger.error(e)
            throw CustomError("Failed to obtain information ")
        }
    }

    override suspend fun defense(page: Int, size: Int, id:String, idSnapshot:String): Turso? {
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
                            "sql" to "SELECT\n" +
                                    "  r.rank,\n" +
                                    "  c.idCharacter,\n" +
                                    "  c.name,\n" +
                                    "  r.level,\n" +
                                    "  r.startDateTimeStamp,\n" +
                                    "  r.lastDateTimeStamp,\n" +
                                    "  r.startDate,\n" +
                                    "  r.lastDate,\n" +
                                    "  r.experience,\n" +
                                    "  r.experience_string,\n" +
                                    "  p.levels,\n" +
                                    "  p.gain_exp,\n" +
                                    "  p.progress_percent,\n" +
                                    "  cat.name AS category_name\n" +
                                    "FROM Progress p\n" +
                                    "JOIN Character c ON c.idCharacter = p.idCharacter\n" +
                                    "JOIN Ranking r ON r.idCharacter = c.idCharacter AND r.idCategory = p.idCategory\n" +
                                    "JOIN Category cat ON p.idCategory = cat.idCategory\n" +
                                    "JOIN Date date on date.idDate = r.idDate\n" +
                                    "WHERE cat.idCategory = '$id' and date.idDate = '$idSnapshot'\n" +
                                    "ORDER BY r.level DESC\n" +
                                    "  LIMIT $size OFFSET $page;"
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
                throw CustomError("Failed to obtain information")
            }
            response.body
        } catch (e: Exception){
            logger.error(e)
            throw CustomError("Failed to obtain information ")
        }
    }

}