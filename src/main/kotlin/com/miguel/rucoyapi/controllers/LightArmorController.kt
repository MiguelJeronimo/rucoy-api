package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LightArmorController {
    @GetMapping("api/v1/lightarmor")
    fun getLightArmorList(): Any {
        return try {
            val lightArmorList = Repository().getLightArmor()
            if(lightArmorList != null){
                return responses.response(200, lightArmorList)
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