package com.miguel.rucoyapi.presentation.controllers

import com.miguel.rucoyapi.data.network.API.Rucoy
import com.miguel.rucoyapi.data.repositories.RepositoryRucoyDatesImpl
import com.miguel.rucoyapi.data.repositories.RepositoryRucoyHighScoresImpl
import com.miguel.rucoyapi.domain.model.responses
import com.miguel.rucoyapi.domain.usecases.UseCaseRucoyDates
import com.miguel.rucoyapi.domain.usecases.UseCaseRucoyHighScores
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/v1")
class ControllerDatesHighScores {
    private val logger: Logger = LogManager.getLogger(ControllerDatesHighScores::class.java)
    private val rucoy = Rucoy()
    private val repository = RepositoryRucoyDatesImpl(rucoy)
    private val useCase = UseCaseRucoyDates(repository)
    @GetMapping("/dates/{type}")
    suspend fun dates(@PathVariable type:String): ResponseEntity<out Any?> {
        return try {
            val response = useCase.dates(type)
            if (response != null){
                logger.info("Final response success")
                ResponseEntity.ok().body(responses.response(200, response))
            } else {
                logger.error("Error: ${responses.Errors(400, "dates is not exist")}")
                ResponseEntity.badRequest().body(responses.Errors(400, "dates is not exist"))
            }
        } catch (e:Exception){
            logger.fatal("Failure by: ${e.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, e.stackTraceToString()))
        }
    }

    @GetMapping("/dates/by-year/{type}/{year}")
    suspend fun datesFindByYears(@PathVariable type: String, @PathVariable year: String): ResponseEntity<out Any?> {
        return try {
            val response = useCase.datesFindByYears(type, year)
            if (response != null){
                logger.info("Final response success")
                ResponseEntity.ok().body(responses.response(200, response))
            } else {
                logger.error("Error: ${responses.Errors(400, "dates is not exist")}")
                ResponseEntity.badRequest().body(responses.Errors(400, "dates is not exist"))
            }
        } catch (e:Exception){
            logger.fatal("Failure by: ${e.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, e.stackTraceToString()))
        }
    }

    @GetMapping("/dates/by-month/{type}/{month}")
    suspend fun datesFindByMonth(@PathVariable type: String, @PathVariable month: String): ResponseEntity<out Any?> {
        return try {
            val response = useCase.datesFindByMonth(type, month)
            if (response != null){
                logger.info("Final response success")
                ResponseEntity.ok().body(responses.response(200, response))
            } else {
                logger.error("Error: ${responses.Errors(400, "dates is not exist")}")
                ResponseEntity.badRequest().body(responses.Errors(400, "dates is not exist"))
            }
        } catch (e:Exception){
            logger.fatal("Failure by: ${e.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, e.stackTraceToString()))
        }
    }
}