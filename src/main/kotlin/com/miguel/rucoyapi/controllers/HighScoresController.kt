package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HighScoresController {
    @GetMapping("api/v1/highscores/{highscore}")
    fun getHighScores(@PathVariable highscore: String): Any {
        return try {
            if (highscore != null){
                val highscores = when(highscore){
                    "experience"->{Repository().highScoresRucoyExperience(highscore)}
                    "melee"->{Repository().highScoresRucoyMelee(highscore)}
                    "distance"->{Repository().highScoresRucoyDistance(highscore)}
                    "magic"->{Repository().highScoresRucoyMagic(highscore)}
                    "defense"->{Repository().highScoresRucoyDefense(highscore)}
                    else -> {null}
                }
                return when(highscores){
                    null->{responses.Errors(400, "Highscore is not exist")}
                    else -> {responses.response(200, highscores)}
                }
            } else{
                return responses.Errors(500, "Insert higscores")
            }
        } catch (e: Exception){
            return responses.Errors(500, e.stackTraceToString())
        }
    }
    /*
    * Cuando no hay highscores en el get
    * */
    @GetMapping("api/v1/highscores")
    fun getHighScore(): Any {
        return try{
           val highscores = Repository().highScoresRucoyExperience("experience")
           return  responses.response(200, highscores)
        }catch (e:Exception){
            return responses.Errors(500, e.stackTraceToString())
        }
    }
}