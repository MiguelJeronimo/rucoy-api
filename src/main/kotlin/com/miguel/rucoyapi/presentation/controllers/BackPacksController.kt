package com.miguel.rucoyapi.presentation.controllers

import com.miguel.rucoyapi.data.repositories.RepositoryRucoyWikiImp
import com.miguel.rucoyapi.domain.model.responses
import com.miguel.rucoyapi.domain.usecases.UseCaseRucoyWiki
import com.miguel.rucoyapi.repository.Rucoy
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BackPacksController {
    private val logger: Logger = LogManager.getLogger(BackPacksController::class.java)
    @GetMapping("api/v1/backpacks")
    fun getBackPacksList(): Any {
        logger.info("init petition: api/v1/backpacks")
        return try {
            val repositoryRucoyWikiImp = RepositoryRucoyWikiImp(Rucoy())
            val useCaseRucoyWiki = UseCaseRucoyWiki(repositoryRucoyWikiImp)
            val backpackList = useCaseRucoyWiki.backpacks()
            if(backpackList != null){
                logger.info("Final response success")
                ResponseEntity.ok().body(responses.response(200, backpackList))
            } else {
                logger.error("Error: ${ResponseEntity.badRequest().body(
                    responses.Errors(
                    400,
                    "no bows found"))}")
                ResponseEntity.badRequest().body(
                    responses.Errors(
                    400,
                    "no bows found"))
            }
        } catch (error: Exception){
            logger.fatal("Failure by: ${error.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, error.stackTraceToString()))
        }
    }
}