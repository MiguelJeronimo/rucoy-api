package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.apache.coyote.Response
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import kotlin.math.log

@RestController
class CreatureProfileController {
    private val logger: Logger = LogManager.getLogger(CreatureProfileController::class.java)
    @GetMapping("api/v1/creature/{name}")
    fun getCreatureProfile(@PathVariable name: String): Any {
        logger.info("init petition: api/v1/creature/${name}")
        return try {
            if (name != null){
                val searchCharacters = Repository().creatureProfile(name)
                return when(searchCharacters?.name){
                    null->{
                        logger.error("Error: ${responses.Errors(400, "Creature is not exist")}")
                        ResponseEntity.badRequest().body(responses.Errors(400, "Creature is not exist"))
                    }
                    else->{
                        logger.info("Final response success:")
                        ResponseEntity.ok().body(responses.response(200, searchCharacters))
                    }
                }
            } else{
                logger.error("Error: ${responses.Errors(400, "Insert Name Character")}")
                ResponseEntity.badRequest().body(responses.Errors(400, "Insert Name Character"))
            }

        } catch (e: Exception){
            logger.fatal("Failure by: ${e.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, e.stackTraceToString()))
        }
    }
    @GetMapping("api/v1/creature")
    fun getCreature(): Any {
        logger.info("init petition: api/v1/creature")
        return try {
            logger.error("Error: ${responses.Errors(400, "Not creature name valid")}")
            ResponseEntity.badRequest().body(responses.Errors(400, "Not creature name valid"))
        } catch (e: Exception){
            logger.fatal("Failure by: ${e.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, e.stackTraceToString()))
        }
    }
}