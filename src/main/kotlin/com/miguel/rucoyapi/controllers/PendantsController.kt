package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PendantsController {
    private val logger: Logger = LogManager.getLogger(PendantsController::class.java)
    @GetMapping("api/v1/pendants")
    fun getPendantsArmorList(): Any {
        logger.info("init petition: api/v1/pendants")
        return try {
            val pendantsList = Repository().getPendants()
            if(pendantsList != null){
                logger.info("Final response success")
                ResponseEntity.ok().body(responses.response(200, pendantsList))
            } else {
                logger.fatal("Error: ${responses.Errors(
                    400,
                    "no bows found")}")
                ResponseEntity.badRequest().body(responses.Errors(
                    400,
                    "no bows found")
                )
            }
        } catch (error: Exception){
            logger.fatal("Failure by: ${error.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, error.stackTraceToString()))
        }
    }
}