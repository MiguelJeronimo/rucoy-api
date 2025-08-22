package com.miguel.rucoyapi.presentation.controllers

import com.miguel.rucoyapi.data.repositories.RepositoryRucoyImp
import com.miguel.rucoyapi.domain.model.responses
import com.miguel.rucoyapi.domain.usecases.UseCaseRucoy
import com.miguel.rucoyapi.data.network.API.Rucoy
import com.miguel.rucoyapi.data.repositories.RepositoryRucoyHighScoresImpl
import com.miguel.rucoyapi.domain.usecases.UseCaseRucoyHighScores
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HighScoresController {
    private val logger: Logger = LogManager.getLogger(HighScoresController::class.java)
    private val rucoy = Rucoy()
    private val repositoryRucoyImp = RepositoryRucoyImp(rucoy)
    private val useCaseRucoy = UseCaseRucoy(repositoryRucoyImp)
    private val repositoryRucoyHighScores = RepositoryRucoyHighScoresImpl(rucoy = rucoy)
    private val useCaseRucoyHighScores = UseCaseRucoyHighScores(repositoryRucoyHighScores)

    @GetMapping("api/v1/highscores/{highscore}")
    suspend fun getHighScores(@PathVariable highscore: String): Any {
        logger.info("init petition: api/v1/highscores/$highscore")
        return try {
            if (highscore != null){
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
                logger.error("Error: ${responses.Errors(400, "Insert higscores")}")
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

    @GetMapping("api/v1/highscores-by-path")
    suspend fun highScores(
        @RequestParam(required = true) path: String,
    ): Any {
        logger.info("init petition: api/v1/highscores-by-path")
        return try{
            when{
                path.contains("experience")->{
                    val response = useCaseRucoyHighScores.experience(path)
                    if (response!=null){
                        ResponseEntity.ok().body(responses.response(200, response))
                    } else{
                        logger.error("Error: ${responses.Errors(400, "Highscore is not exist")}")
                        ResponseEntity.badRequest().body(responses.Errors(400, "Highscore is not exist"))
                    }
                }
                path.contains("melee")->{
                    val response = useCaseRucoyHighScores.melee(path)
                    if (response!=null){
                        ResponseEntity.ok().body(responses.response(200, response))
                    } else{
                        logger.error("Error: ${responses.Errors(400, "Highscore is not exist")}")
                        ResponseEntity.badRequest().body(responses.Errors(400, "Highscore is not exist"))
                    }
                }
                path.contains("distance")->{
                    val response = useCaseRucoyHighScores.distance(path)
                    if (response!=null){
                        ResponseEntity.ok().body(responses.response(200, response))
                    } else{
                        logger.error("Error: ${responses.Errors(400, "Highscore is not exist")}")
                        ResponseEntity.badRequest().body(responses.Errors(400, "Highscore is not exist"))
                    }
                }
                path.contains("magic")->{
                    val response = useCaseRucoyHighScores.magic(path)
                    if (response!=null){
                        ResponseEntity.ok().body(responses.response(200, response))
                    } else{
                        logger.error("Error: ${responses.Errors(400, "Highscore is not exist")}")
                        ResponseEntity.badRequest().body(responses.Errors(400, "Highscore is not exist"))
                    }
                }
                path.contains("defense")->{
                    val response = useCaseRucoyHighScores.defense(path)
                    if (response!=null){
                        ResponseEntity.ok().body(responses.response(200, response))
                    } else{
                        logger.error("Error: ${responses.Errors(400, "Highscore is not exist")}")
                        ResponseEntity.badRequest().body(responses.Errors(400, "Highscore is not exist"))
                    }
                }
                else -> {
                    logger.error("Error: ${responses.Errors(400, "Insert higscores")}")
                    ResponseEntity.badRequest().body(responses.Errors(400, "Invalid path"))
                }
            }
        }catch (e: Exception){
            logger.fatal("Failure by: ${e.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, e.stackTraceToString()))
        }
    }

    @GetMapping("api/v1/highscores-by-date")
    suspend fun highScores(
        @RequestParam(required = true) type: String,
        @RequestParam(required = true) month: String,
        @RequestParam(required = true) year: String
    ): Any {
        logger.info("init petition: api/v1/highscores-by-date")
        return try{
            when{
                type.lowercase().contains("experience")->{
                    val response = useCaseRucoyHighScores.experience(type, "${year}/${month}")
                    if (response!=null){
                        ResponseEntity.ok().body(responses.response(200, response))
                    } else{
                        logger.error("Error: ${responses.Errors(400, "Highscore is not exist")}")
                        ResponseEntity.badRequest().body(responses.Errors(400, "Highscore is not exist"))
                    }
                }
                type.lowercase().contains("melee")->{
                    val response = useCaseRucoyHighScores.melee(type, "${year}/${month}")
                    if (response!=null){
                        ResponseEntity.ok().body(responses.response(200, response))
                    } else{
                        logger.error("Error: ${responses.Errors(400, "Highscore is not exist")}")
                        ResponseEntity.badRequest().body(responses.Errors(400, "Highscore is not exist"))
                    }
                }
                type.lowercase().contains("distance")->{
                    val response = useCaseRucoyHighScores.distance(type, "${year}/${month}")
                    if (response!=null){
                        ResponseEntity.ok().body(responses.response(200, response))
                    } else{
                        logger.error("Error: ${responses.Errors(400, "Highscore is not exist")}")
                        ResponseEntity.badRequest().body(responses.Errors(400, "Highscore is not exist"))
                    }
                }
                type.lowercase().contains("magic")->{
                    val response = useCaseRucoyHighScores.magic(type, "${year}/${month}")
                    if (response!=null){
                        ResponseEntity.ok().body(responses.response(200, response))
                    } else{
                        logger.error("Error: ${responses.Errors(400, "Highscore is not exist")}")
                        ResponseEntity.badRequest().body(responses.Errors(400, "Highscore is not exist"))
                    }
                }
                type.lowercase().contains("defense")->{
                    val response = useCaseRucoyHighScores.defense(type, "${year}/${month}")
                    if (response!=null){
                        ResponseEntity.ok().body(responses.response(200, response))
                    } else{
                        logger.error("Error: ${responses.Errors(400, "Highscore is not exist")}")
                        ResponseEntity.badRequest().body(responses.Errors(400, "Highscore is not exist"))
                    }
                }
                else -> {
                    logger.error("Error: ${responses.Errors(400, "Invalid params")}")
                    ResponseEntity.badRequest().body(responses.Errors(400, "Invalid params"))
                }
            }
        }catch (e: Exception){
            logger.fatal("Failure by: ${e.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, e.stackTraceToString()))
        }
    }
}