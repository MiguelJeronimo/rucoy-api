package com.miguel.rucoyapi.presentation.controllers

import com.miguel.rucoyapi.domain.model.responses
import com.miguel.rucoyapi.domain.usecases.UseCaseRucoyWiki
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EquipmentController(private val useCaseRucoyWiki: UseCaseRucoyWiki) {
    private val logger: Logger = LogManager.getLogger(EquipmentController::class.java)

    @GetMapping("api/v1/equipment")
    suspend fun getEquipment(): Any {
        logger.info("init petition: api/v1/equipment")
        return try {
            val equipment = useCaseRucoyWiki.equipment()
            if(!equipment.isNullOrEmpty()){
                logger.info("Final response success")
                ResponseEntity.ok().body(responses.response(200, equipment))
            } else {
                logger.error("Error: ${
                    responses.Errors(
                    400,
                    "no wands found")}")
                ResponseEntity.badRequest().body(
                    responses.Errors(
                    400,
                    "no wands found"))
            }
        } catch (error: Exception){
            logger.fatal("Failure by: ${error.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, error.stackTraceToString()))
        }
    }
}