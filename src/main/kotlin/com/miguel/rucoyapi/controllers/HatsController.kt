package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HatsController {
    @GetMapping("api/v1/hats")
    fun getHatsList(): Any {
        return try {
            val hatsList = Repository().getHats()
            if(hatsList != null){
                return responses.response(200, hatsList)
            } else {
                return responses.Errors(
                    400,
                    "no bows found")
            }
        } catch (error: Exception){
            return responses.Errors(500, error.stackTraceToString())
        }
    }
}