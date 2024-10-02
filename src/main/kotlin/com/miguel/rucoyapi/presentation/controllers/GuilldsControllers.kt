package com.miguel.rucoyapi.presentation.controllers


import com.miguel.rucoyapi.data.repositories.RepositoryRucoyImp
import com.miguel.rucoyapi.domain.model.responses
import com.miguel.rucoyapi.domain.usecases.UseCaseRucoy
import com.miguel.rucoyapi.repository.Rucoy
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GuilldsControllers {
    private val logger: Logger = LogManager.getLogger(GuilldsControllers::class.java)
    @GetMapping("api/v1/guild/{name}")
    fun getGuild(@PathVariable name: String): Any?{
        logger.info("init petition: api/v1/guild/$name")
        return try {
            if (name != null){
                val repositoryRucoyImp = RepositoryRucoyImp(Rucoy())
                val useCaseRucoy = UseCaseRucoy(repositoryRucoyImp)
                val guild = useCaseRucoy.guild(name)
                return when(guild?.name){
                    ""->{
                        logger.error("Error: ${responses.Errors(400, "Guild is not exist")}")
                        ResponseEntity.badRequest().body(responses.Errors(400, "Guild is not exist"))
                    }
                    else -> {
                        logger.info("Final response success")
                        ResponseEntity.ok().body(responses.response(200, guild))
                    }
                }
            } else{
                logger.error("Error: ${responses.Errors(400, "Insert Guild Name")}")
                ResponseEntity.badRequest().body(responses.Errors(400, "Insert Guild Name"))
            }
        } catch (e: Exception){
            logger.fatal("Failure by: ${e.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, e.stackTraceToString()))
        }
    }
    @GetMapping("api/v1/guild")
    fun getGuilds(): Any?{
        logger.info("init petition: api/v1/guild")
        return try {
            ResponseEntity.badRequest().body(responses.Errors(400, "Not guild name valid"))
        } catch (e: Exception){
            logger.fatal("Failure by: ${e.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, e.stackTraceToString()))
        }
    }
}