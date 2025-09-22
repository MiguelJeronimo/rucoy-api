package com.miguel.rucoyapi.presentation.controllers

import com.miguel.rucoyapi.domain.model.responses
import com.miguel.rucoyapi.domain.usecases.UseCaseHistory
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
@RequestMapping("api/v1/")
class ControllerHistory(@Autowired private val  useCaseHistory: UseCaseHistory) {
    private val logger: Logger = LogManager.getLogger(ControllerHistory::class.java)

    @GetMapping("/tops/history/{name}")
    suspend fun history(@PathVariable name: String, request: HttpServletRequest): ResponseEntity<out Any?> {
        logger.info("init petition: ${request.method} - ${request.requestURI}")
        return try {
            val response = useCaseHistory.history(name)
            ResponseEntity.ok(responses.response(200, response))
        }catch (e: CustomError){
            ResponseEntity.badRequest().body(responses.Errors(400, e.message.toString()))
        }
        catch (e: Exception){
            logger.error(e)
            ResponseEntity.internalServerError().body(responses.Errors(500, "Fatal Error, contact to support"))
        }

    }

    @GetMapping("/tops/best/rank")
    suspend fun bestRank(request: HttpServletRequest): ResponseEntity<out Any?> {
        logger.info("init petition: ${request.method} - ${request.requestURI}")
        return try {
            val response = useCaseHistory.bestRank()
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