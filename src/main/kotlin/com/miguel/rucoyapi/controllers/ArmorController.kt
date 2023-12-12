package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ArmorController {
    @GetMapping("api/v1/armors")
    fun getArmorList(): Any {
        return try {
            val amorList = Repository().getArmors()
            if(amorList != null){
                return responses.response(200, amorList)
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
