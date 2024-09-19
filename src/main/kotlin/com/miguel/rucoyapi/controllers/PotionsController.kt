package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PotionsController {
    private val logger: Logger = LogManager.getLogger(PotionsController::class.java)
    @GetMapping("api/v1/potions")
    fun getPotions(): Any {
        logger.info("init petition: api/v1/potions")
        return try {
            val postionsList = Repository().getPotions()
            if(postionsList != null){
                logger.info("Final response success")
                ResponseEntity.ok().body(responses.response(200, postionsList))
            } else {
                logger.error("Error: ${
                    responses.Errors(
                        400,
                        "no wands found")
                }")
                ResponseEntity.badRequest().body(responses.Errors(
                    400,
                    "no wands found")
                )
            }
        } catch (error: Exception){
            logger.fatal("Failure by: ${error.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, error.stackTraceToString()))
        }
    }
}