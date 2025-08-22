package com.miguel.rucoyapi.presentation.controllers

import com.miguel.rucoyapi.data.repositories.RepositoryRucoyWikiImp
import com.miguel.rucoyapi.domain.model.responses
import com.miguel.rucoyapi.domain.usecases.UseCaseRucoyWiki
import com.miguel.rucoyapi.data.network.API.Rucoy
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LightArmorController {
    private val logger: Logger = LogManager.getLogger(com.miguel.rucoyapi.presentation.controllers.LightArmorController::class.java)
    @GetMapping("api/v1/lightarmor")
    suspend fun getLightArmorList(): Any {
        logger.info("init petition: api/v1/lightarmor")
        return try {
            val repositoryRucoyWikiImp = RepositoryRucoyWikiImp(Rucoy())
            val useCaseRucoyWiki = UseCaseRucoyWiki(repositoryRucoyWikiImp)
            val lightArmorList = useCaseRucoyWiki.lightArmor()
            if(lightArmorList != null){
                logger.info("Final response success")
                return responses.response(200, lightArmorList)
            } else {
                logger.error("Error: ${
                    responses.Errors(
                    400,
                    "no bows found")}")
                return responses.Errors(
                    400,
                    "no bows found")
            }
        } catch (error: Exception){
            logger.fatal("Failure by: ${error.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, error.stackTraceToString()))
        }
    }
}