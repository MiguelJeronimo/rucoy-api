package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WandsController {
    @GetMapping("api/v1/wands")
    fun getWands(): Any {
        return try {
            val wandsList = Repository().wandsList()
            if(wandsList != null){
                return responses.response(200, wandsList)
            } else {
                return responses.Errors(
                    400,
                    "no wands found")
            }
        } catch (error: Exception){
            return responses.Errors(500, error.stackTraceToString())
        }
    }
}