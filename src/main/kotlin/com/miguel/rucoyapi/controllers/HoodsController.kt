package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HoodsController {
    @GetMapping("api/v1/hoods")
    fun getHoodsList(): Any {
        return try {
            val hoodsList = Repository().getHoods()
            if(hoodsList != null){
                return responses.response(200, hoodsList)
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