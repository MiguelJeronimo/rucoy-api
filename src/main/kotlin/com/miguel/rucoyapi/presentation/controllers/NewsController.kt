package com.miguel.rucoyapi.presentation.controllers

import com.miguel.rucoyapi.data.repositories.RepositoryRucoyImp
import com.miguel.rucoyapi.domain.model.responses
import com.miguel.rucoyapi.domain.usecases.UseCaseRucoy
import com.miguel.rucoyapi.data.network.API.Rucoy
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NewsController {
    private val logger: Logger = LogManager.getLogger(NewsController::class.java)
    @GetMapping("api/v1/news")
    suspend fun getNews(): Any {
        logger.info("init petition")
        return try {
            val repositoryRucoy = RepositoryRucoyImp(Rucoy())
            val useCaseRucoy = UseCaseRucoy(repositoryRucoy)
            val news = useCaseRucoy.news()
            if(news != null){
                logger.info("Final response success")
                ResponseEntity.ok().body(responses.response(200, news))
            } else {
                logger.error("Error: ${
                    responses.Errors(
                        400,
                        "no news found")
                }")
                ResponseEntity.badRequest().body(
                    responses.Errors(
                    400,
                    "no news found"))
            }
        } catch (error: Exception){
            logger.fatal("Failure by: ${error.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, error.stackTraceToString()))
        }
    }
}