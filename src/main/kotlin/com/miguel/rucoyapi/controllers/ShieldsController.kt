package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.math.log

@RestController
class ShieldsController {
    private val logger: Logger = LogManager.getLogger(ShieldsController::class.java)
    @GetMapping("api/v1/shields")
    fun getRingsList(): Any {
        logger.info("init petition: api/v1/shields")
        return try {
            val shieldsList = Repository().getShields()
            if(shieldsList != null){
                logger.info("Final response success")
                ResponseEntity.ok().body(responses.response(200, shieldsList))
            } else {
                logger.error("Error: ${responses.Errors(
                    400,
                    "no bows found")}")
                ResponseEntity.badRequest().body(responses.Errors(
                    400,
                    "no bows found"))
            }
        } catch (error: Exception){
            logger.fatal("Failure by: ${error.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, error.stackTraceToString()))
        }
    }
}