package com.miguel.rucoyapi.presentation.controllers

import com.miguel.rucoyapi.data.repositories.RepositoryRucoyImp
import com.miguel.rucoyapi.domain.model.responses
import com.miguel.rucoyapi.domain.usecases.UseCaseRucoy
import com.miguel.rucoyapi.data.network.API.Rucoy
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.jetbrains.annotations.NotNull
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CharactersController {
    private val logger: Logger = LogManager.getLogger(CharactersController::class.java)
    @GetMapping("api/v1/characters/{name}")
    @NotNull
    fun getCharacters(@PathVariable name: String): Any {
        logger.info("init petition: api/v1/characters/$name")
        return try {
            if (name != null){
                val repositoryRucoy = RepositoryRucoyImp(Rucoy())
                val useCaseRucoy = UseCaseRucoy(repositoryRucoy)
                val searchCharacters = useCaseRucoy.character(name)
                if (searchCharacters?.name != null){
                    logger.info("Final response success")
                    ResponseEntity.ok().body(responses.response(200, searchCharacters))
                } else{
                    logger.error("Error: ${responses.Errors(400, "Character is not exist")}")
                    ResponseEntity.badRequest().body(responses.Errors(400, "Character is not exist"))
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
    @GetMapping("api/v1/characters")
    @NotNull
    fun getCharacter(): Any {
        return try {
            logger.error("Error: ${responses.Errors(400, "Not character name valid")}")
            ResponseEntity.badRequest().body(responses.Errors(400, "Not character name valid"))
        } catch (e: Exception){
            logger.fatal("Failure by: ${e.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, e.stackTraceToString()))
        }
    }
}