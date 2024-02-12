package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GuildsController {
    @GetMapping("/api/v1/guilds/{pager}")
    fun getArmorList(@PathVariable pager: String): Any {
        return try {
            if (pager != null && pager !="0"){
                val guilds = Repository().guildsList(pager)
                if(guilds != null){
                    if (guilds.guild_list?.isNotEmpty() == true){
                        return responses.response(200, guilds)
                    }else{
                        guilds.guild_list = null
                        return responses.response(200, guilds)
                    }

                } else {
                    return responses.Errors(
                        400,
                        "no guidls found")
                }
            } else {
                return responses.Errors(400, "Add pager number")
            }
        } catch (error: Exception){
            return responses.Errors(500, error.stackTraceToString())
        }
    }
}