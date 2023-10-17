package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SwordsController {
    @GetMapping("api/v1/swords")
    fun getSwords(): Any {
        return try {
            val swordsList = Repository().swordsList()
            if(swordsList != null){
                return responses.response(200, swordsList)
            } else {
                return responses.Errors(
                    400,
                    "no swords found")
            }
        } catch (error: Exception){
            return responses.Errors(500, error.stackTraceToString())
        }
    }

}