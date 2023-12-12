package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BootsController {
    @GetMapping("api/v1/boots")
    fun getBootsList(): Any {
        return try {
            val bootsList = Repository().getBoots()
            if(bootsList != null){
                return responses.response(200, bootsList)
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