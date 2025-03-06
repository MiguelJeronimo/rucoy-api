package com.miguel.rucoyapi.presentation.controllers

import com.miguel.rucoyapi.data.repositories.RepositoryRucoyImp
import com.miguel.rucoyapi.domain.model.responses
import com.miguel.rucoyapi.domain.usecases.UseCaseRucoy
import com.miguel.rucoyapi.data.network.API.Rucoy
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GuildsController {
    private val logger: Logger = LogManager.getLogger(GuildsController::class.java)
    @GetMapping("/api/v1/guilds/{pager}")
    fun getArmorList(@PathVariable pager: String): Any {
        logger.info("init petition: /api/v1/guilds/$pager")
        return try {
            if (pager != null && pager !="0"){
                val repositoryRucoyImp = RepositoryRucoyImp(Rucoy())
                val useCaseRucoy = UseCaseRucoy(repositoryRucoyImp)
                val guilds = useCaseRucoy.guilds(pager)
                if(guilds != null){
                    logger.info("Final response success")
                    if (guilds.guild_list?.isNotEmpty() == true){
                        ResponseEntity.ok().body(responses.response(200, guilds))
                    }else{
                        guilds.guild_list = null
                        ResponseEntity.ok().body(responses.response(200, guilds))
                    }

                } else {
                    logger.error("Error: ${
                        responses.Errors(
                        400,
                        "no guidls found")}")
                    return responses.Errors(
                        400,
                        "no guidls found")
                }
            } else {
                logger.error("Error: ${responses.Errors(400, "Add pager number")}")
                ResponseEntity.badRequest().body(responses.Errors(400, "Add pager number"))
            }
        } catch (error: Exception){
            logger.fatal("Failure by: ${error.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, error.stackTraceToString()))
        }
    }
}