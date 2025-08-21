package com.miguel.rucoyapi.presentation.controllers

import com.miguel.rucoyapi.data.repositories.RepositoryRucoyImp
import com.miguel.rucoyapi.domain.model.responses
import com.miguel.rucoyapi.domain.usecases.UseCaseRucoy
import com.miguel.rucoyapi.data.network.API.Rucoy
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HighScoresController {
    private val logger: Logger = LogManager.getLogger(HighScoresController::class.java)
    @GetMapping("api/v1/highscores/{highscore}")
    suspend fun getHighScores(@PathVariable highscore: String): Any {
        logger.info("init petition: api/v1/highscores/$highscore")
        return try {
            if (highscore != null){
                val repositoryRucoyImp = RepositoryRucoyImp(Rucoy())
                val useCaseRucoy = UseCaseRucoy(repositoryRucoyImp)
                val highscores = useCaseRucoy.highScores(highscore)
                return when(highscores){
                    null->{
                        logger.error("Error: ${
                            responses.Errors(400, "Highscore is not exist")
                        }")
                        ResponseEntity.badRequest().body(responses.Errors(400, "Highscore is not exist"))
                    }
                    else -> {
                        logger.info("Final response success")
                        ResponseEntity.ok().body(responses.response(200, highscores))
                    }
                }
            } else{
                logger.error("Error: ${responses.Errors(500, "Insert higscores")}")
                ResponseEntity.badRequest().body(responses.Errors(400, "Insert higscores"))
            }
        } catch (e: Exception){
            logger.fatal("Failure by: ${e.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, e.stackTraceToString()))
        }
    }
    /*
    * Cuando no hay highscores en el get
    * */
    @GetMapping("api/v1/highscores")
    suspend fun getHighScore(): Any {
        logger.info("init petition: api/v1/highscores")
        return try{
            val repositoryRucoyImp = RepositoryRucoyImp(Rucoy())
            val useCaseRucoy = UseCaseRucoy(repositoryRucoyImp)
            val highscores = useCaseRucoy.highScores("experience")
            logger.info("Final response success")
           ResponseEntity.ok().body(responses.response(200, highscores))
        }catch (e:Exception){
            logger.fatal("Failure by: ${e.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, e.stackTraceToString()))
        }
    }
}