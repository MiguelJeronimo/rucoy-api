package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelmetsController {
    @GetMapping("api/v1/helmets")
    fun getHatsList(): Any {
        return try {
            val helmetsList = Repository().getHelmets()
            if(helmetsList != null){
                return responses.response(200, helmetsList)
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