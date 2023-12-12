package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RingsControllers {
    @GetMapping("api/v1/rings")
    fun getRingsList(): Any {
        return try {
            val ringsList = Repository().getRings()
            if(ringsList != null){
                return responses.response(200, ringsList)
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