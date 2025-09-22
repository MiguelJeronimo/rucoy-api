package com.miguel.rucoyapi.presentation.controllers

import com.miguel.rucoyapi.domain.model.responses
import com.miguel.rucoyapi.domain.usecases.UseCaseStats
import com.miguel.rucoyapi.utils.execeptions.CustomError
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest


@RestController
@RequestMapping("api/v1")
class ControllerStats(@Autowired private val useCaseStats: UseCaseStats) {
    private val logger: Logger = LogManager.getLogger(ControllerStats::class.java)

    @GetMapping("tops/experience/{name}")
    suspend fun playerExperience(@PathVariable name: String, request: HttpServletRequest): ResponseEntity<out Any?> {
        logger.info("init petition: ${request.method} - ${request.requestURI}")
        return try {
            val response = useCaseStats.statsExperienceByName(name)
            ResponseEntity.ok(responses.response(200, response))
        }catch (e: CustomError){
            ResponseEntity.badRequest().body(responses.Errors(400, e.message.toString()))
        }
        catch (e: Exception){
            logger.error(e)
            ResponseEntity.internalServerError().body(responses.Errors(500, "Fatal Error, contact to support"))
        }
    }

    @GetMapping("tops/melee/{name}")
    suspend fun playerMelee(@PathVariable name: String, request: HttpServletRequest): ResponseEntity<out Any?> {
        logger.info("init petition: ${request.method} - ${request.requestURI}")
        return try {
            val response = useCaseStats.statsMeleeByName(name)
            ResponseEntity.ok(responses.response(200, response))
        }catch (e: CustomError){
            ResponseEntity.badRequest().body(responses.Errors(400, e.message.toString()))
        }
        catch (e: Exception){
            logger.error(e)
            ResponseEntity.internalServerError().body(responses.Errors(500, "Fatal Error, contact to support"))
        }
    }

    @GetMapping("tops/distance/{name}")
    suspend fun playerDistance(@PathVariable name: String, request: HttpServletRequest): ResponseEntity<out Any?> {
        logger.info("init petition: ${request.method} - ${request.requestURI}")
        return try {
            val response = useCaseStats.statsDistanceByName(name)
            ResponseEntity.ok(responses.response(200, response))
        }catch (e: CustomError){
            ResponseEntity.badRequest().body(responses.Errors(400, e.message.toString()))
        }
        catch (e: Exception){
            logger.error(e)
            ResponseEntity.internalServerError().body(responses.Errors(500, "Fatal Error, contact to support"))
        }
    }

    @GetMapping("tops/magic/{name}")
    suspend fun playerMagic(@PathVariable name: String, request: HttpServletRequest): ResponseEntity<out Any?> {
        logger.info("init petition: ${request.method} - ${request.requestURI}")
        return try {
            val response = useCaseStats.statsMagicByName(name)
            ResponseEntity.ok(responses.response(200, response))
        }catch (e: CustomError){
            ResponseEntity.badRequest().body(responses.Errors(400, e.message.toString()))
        }
        catch (e: Exception){
            logger.error(e)
            ResponseEntity.internalServerError().body(responses.Errors(500, "Fatal Error, contact to support"))
        }
    }

    @GetMapping("tops/defense/{name}")
    suspend fun playerDefense(@PathVariable name: String, request: HttpServletRequest): ResponseEntity<out Any?> {
        logger.info("init petition: ${request.method} - ${request.requestURI}")
        return try {
            val response = useCaseStats.statsDefenseByName(name)
            ResponseEntity.ok(responses.response(200, response))
        }catch (e: CustomError){
            ResponseEntity.badRequest().body(responses.Errors(400, e.message.toString()))
        }
        catch (e: Exception){
            logger.error(e)
            ResponseEntity.internalServerError().body(responses.Errors(500, "Fatal Error, contact to support"))
        }
    }
}