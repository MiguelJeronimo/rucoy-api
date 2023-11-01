package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PotionsController {
    @GetMapping("api/v1/potions")
    fun getPotions(): Any {
        return try {
            val postionsList = Repository().getPotions()
            if(postionsList != null){
                return responses.response(200, postionsList)
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