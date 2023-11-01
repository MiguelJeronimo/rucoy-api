package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ItemProfileController {
    @GetMapping("api/v1/item/{name}")
    fun getItemProfile(@PathVariable name: String): Any {
        return try {
            if (name != null){
                val item = Repository().itemProfile(name)
                if (item != null){
                    return responses.response(200, item)
                } else{
                    return responses.Errors(400, "Item is not exist")
                }
            } else{
                return responses.Errors(400, "Insert Name Item")
            }

        } catch (e: Exception){
            println("ERROR: ${e.stackTraceToString()}")
            return responses.Errors(500, e.stackTraceToString())
        }
    }
    @GetMapping("api/v1/item")
    @NotNull
    fun getItem(): Any {
        return try {
            return responses.Errors(400, "Not item name valid")
        } catch (e: Exception){
            println("ERROR: ${e.stackTraceToString()}")
            return responses.Errors(500, e.stackTraceToString())
        }
    }
}