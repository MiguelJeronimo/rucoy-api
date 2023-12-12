package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BackPacksController {
    @GetMapping("api/v1/backpacks")
    fun getBackPacksList(): Any {
        return try {
            val backpackList = Repository().getBackPacks()
            if(backpackList != null){
                return responses.response(200, backpackList)
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