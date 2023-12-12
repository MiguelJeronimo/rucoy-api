package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RobesController {
    @GetMapping("api/v1/robes")
    fun getRobesList(): Any {
        return try {
            val robesList = Repository().getRobes()
            if(robesList != null){
                return responses.response(200, robesList)
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
