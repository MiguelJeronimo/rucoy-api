package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CreatureProfileController {

    @GetMapping("api/v1/creature/{name}")
    fun getCreatureProfile(@PathVariable name: String): Any {
        return try {
            if (name != null){
                val searchCharacters = Repository().creatureProfile(name)
                return when(searchCharacters?.name){
                    null->{return responses.Errors(400, "Creature is not exist")}
                    else->{return responses.response(200, searchCharacters)}
                }
            } else{
                return responses.Errors(400, "Insert Name Character")
            }

        } catch (e: Exception){
            println("ERROR: ${e.stackTraceToString()}")
            return responses.Errors(500, e.stackTraceToString())
        }
    }
}