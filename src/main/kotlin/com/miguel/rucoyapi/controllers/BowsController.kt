package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BowsController {

    @GetMapping("api/v1/bows")
    fun getBowsList(): Any {
        return try {
            val bowsList = Repository().bowsList()
            if(bowsList != null){
                return responses.response(200, bowsList)
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