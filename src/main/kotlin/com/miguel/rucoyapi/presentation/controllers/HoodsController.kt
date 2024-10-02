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
class HoodsController {
    private val logger: Logger = LogManager.getLogger(HoodsController::class.java)
    @GetMapping("api/v1/hoods")
    fun getHoodsList(): Any {
        logger.info("init petition: api/v1/hoods")
        return try {
            val repositoryRucoyWikiImp = RepositoryRucoyWikiImp(Rucoy())
            val useCaseRucoyWiki = UseCaseRucoyWiki(repositoryRucoyWikiImp)
            val hoodsList = useCaseRucoyWiki.hoods()
            if(hoodsList != null){
                logger.info("Final response success")
                ResponseEntity.ok().body(responses.response(200, hoodsList))
            } else {
                logger.error("Error: ${
                    responses.Errors(
                        400,
                        "no bows found")
                }")
                ResponseEntity.badRequest().body(
                    responses.Errors(
                    400,
                    "no bows found")
                )
            }
        } catch (error: Exception){
            ResponseEntity.internalServerError().body(responses.Errors(500, error.stackTraceToString()))
        }
    }
}