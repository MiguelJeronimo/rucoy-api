package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LightArmorController {
    private val logger: Logger = LogManager.getLogger(LightArmorController::class.java)
    @GetMapping("api/v1/lightarmor")
    fun getLightArmorList(): Any {
        logger.info("init petition: api/v1/lightarmor")
        return try {
            val lightArmorList = Repository().getLightArmor()
            if(lightArmorList != null){
                logger.info("Final response success")
                return responses.response(200, lightArmorList)
            } else {
                logger.error("Error: ${responses.Errors(
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