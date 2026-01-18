package com.miguel.rucoyapi.data.repositories

import com.miguel.rucoyapi.domain.model.WikiModels
import com.miguel.rucoyapi.utils.execeptions.CustomError
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity

@Repository
class RepositoryWikiInfoImpl: RepositoryWikiInfo {
    private val response = RestTemplate()
    private val logger = LogManager.getLogger()
    override suspend fun infoWikiCreatures(name:String): WikiModels {
        return try {
            val response = response.getForEntity<WikiModels>(url = "https://rucoy-online.fandom.com/api.php?action=parse&page=$name&prop=text&format=json")
            //logger.info("Response: $response")
            if (response.statusCode.isError){
                throw CustomError("Wiki creatures not found")
            }
            response.body ?: throw CustomError("Wiki creatures not found")
        } catch (e:Exception) {
            logger.fatal(e)
            throw CustomError("Fail get creature info")
        }
    }
}