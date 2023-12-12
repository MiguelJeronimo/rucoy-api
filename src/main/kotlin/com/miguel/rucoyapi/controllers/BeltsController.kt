package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BeltsController {
    @GetMapping("api/v1/belts")
    fun getBeltsList(): Any {
        return try {
            val beltsList = Repository().getBelts()
            if(beltsList != null){
                return responses.response(200, beltsList)
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