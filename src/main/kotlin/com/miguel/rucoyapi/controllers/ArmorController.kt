package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class ArmorController {
    private val logger: Logger = LogManager.getLogger(ArmorController::class.java)
    @GetMapping("api/v1/armors")
    fun getArmorList(): Any {
        return try {
            val amorList = Repository().getArmors()
            logger.info("init petition: api/v1/armors")
            if(amorList != null){
                logger.info("Final response success")
                ResponseEntity.ok().body(
                        responses.response(200, amorList)
                    )
            } else {
                logger.error("Error: " +ResponseEntity.badRequest().body(responses.Errors(
                    400,
                    "no bows found")))
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
