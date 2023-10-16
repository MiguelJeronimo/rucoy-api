package com.miguel.rucoyapi.controllers

import API.guildss.GuildsData
import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GuilldsControllers {
    @GetMapping("api/v1/guild/{name}")
    fun getGuild(@PathVariable name: String): Any?{
        return try {
            if (name != null){
                val guild = Repository().SearchGuilds(name)
                return when(guild?.name){
                    ""->{responses.Errors(400, "Guild is not exist")}
                    else -> {responses.response(200, guild)}
                }
            } else{
                return responses.Errors(400, "Insert Guild Name")
            }
        } catch (e: Exception){
            println("ERROR: ${e.stackTraceToString()}")
            return responses.Errors(500, e.stackTraceToString())
        }
    }
}