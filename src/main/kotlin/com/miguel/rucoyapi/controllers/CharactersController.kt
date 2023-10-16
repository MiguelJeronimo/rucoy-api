package com.miguel.rucoyapi.controllers

import API.characters.CharactersRucoy
import Jsoup.Scrapper
import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CharactersController {
    @GetMapping("api/v1/characters/{name}")
    @NotNull
    fun getCharacters(@PathVariable name: String): Any {
        return try {
            if (name != null){
                val searchCharacters = Repository().SearchCharacter(name)
                if (searchCharacters?.name != null){
                    return responses.response(200, searchCharacters)
                } else{
                    return responses.Errors(400, "Character is not exist")
                }
            } else{
                return responses.Errors(400, "Insert Name Character")
            }

        } catch (e: Exception){
            println("ERROR: ${e.stackTraceToString()}")
            return responses.Errors(500, e.stackTraceToString())
        }
    }
}