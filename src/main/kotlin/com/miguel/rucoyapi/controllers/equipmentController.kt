package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class equipmentController {
    @GetMapping("api/v1/equipment")
    fun getEquipment(): Any {
        return try {
            val equipement = Repository().getEquipment()
            if(equipement != null){
                return responses.response(200, equipement)
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