package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PendantsController {
    @GetMapping("api/v1/pendants")
    fun getPendantsArmorList(): Any {
        return try {
            val pendantsList = Repository().getPendants()
            if(pendantsList != null){
                return responses.response(200, pendantsList)
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