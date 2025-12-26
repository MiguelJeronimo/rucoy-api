package com.miguel.rucoyapi.presentation.controllers

import com.miguel.rucoyapi.domain.model.responses
import com.miguel.rucoyapi.domain.usecases.UseCasesTops
import com.miguel.rucoyapi.utils.execeptions.CustomError
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("api/v1/")
class ControllerTopsSnapshopts(@Autowired private val useCasesTops: UseCasesTops) {
    private val logger: Logger = LogManager.getLogger(ControllerTopsSnapshopts::class.java)

    @GetMapping("tops/experience")
    suspend fun experience(@RequestParam(defaultValue = "1") page:Int, @RequestParam(defaultValue = "20") size:Int, request: HttpServletRequest): ResponseEntity<out Any?> {
        logger.info("init petition: ${request.method} - ${request.requestURI}")
        return try {
            logger.info("pagina: $page: tamaño: $size")
            val response = useCasesTops.experience(page = page, size= size)
            ResponseEntity.ok(responses.response(200, response))
        }catch (e: CustomError){
            ResponseEntity.badRequest().body(responses.Errors(400, e.message.toString()))
        }
        catch (e: Exception){
            logger.error(e)
            ResponseEntity.internalServerError().body(responses.Errors(500, "Fatal Error, contact to support"))
        }
    }


    @GetMapping("tops/melee")
    suspend fun melee(@RequestParam(defaultValue = "1") page:Int, @RequestParam(defaultValue = "20") size:Int, request: HttpServletRequest): ResponseEntity<out Any?> {
        logger.info("init petition: ${request.method} - ${request.requestURI}")
        return try {
            logger.info("pagina: $page: tamaño: $size")
            val response = useCasesTops.melee(page = page, size= size)
            ResponseEntity.ok(responses.response(200, response))
        }catch (e: CustomError){
            ResponseEntity.badRequest().body(responses.Errors(400, e.message.toString()))
        }
        catch (e: Exception){
            logger.error(e)
            ResponseEntity.internalServerError().body(responses.Errors(500, "Fatal Error, contact to support"))
        }
    }

    @GetMapping("tops/distance")
    suspend fun distance(@RequestParam(defaultValue = "1") page:Int, @RequestParam(defaultValue = "20") size:Int, request: HttpServletRequest): ResponseEntity<out Any?> {
        logger.info("init petition: ${request.method} - ${request.requestURI}")
        return try {
            logger.info("pagina: $page: tamaño: $size")
            val response = useCasesTops.distance(page = page, size= size)
            ResponseEntity.ok(responses.response(200, response))
        }catch (e: CustomError){
            ResponseEntity.badRequest().body(responses.Errors(400, e.message.toString()))
        }
        catch (e: Exception){
            logger.error(e)
            ResponseEntity.internalServerError().body(responses.Errors(500, "Fatal Error, contact to support"))
        }
    }

    @GetMapping("tops/magic")
    suspend fun magic(@RequestParam(defaultValue = "1") page:Int, @RequestParam(defaultValue = "20") size:Int, request: HttpServletRequest): ResponseEntity<out Any?> {
        logger.info("init petition: ${request.method} - ${request.requestURI}")
        return try {
            logger.info("pagina: $page: tamaño: $size")
            val response = useCasesTops.magic(page = page, size= size)
            ResponseEntity.ok(responses.response(200, response))
        }catch (e: CustomError){
            ResponseEntity.badRequest().body(responses.Errors(400, e.message.toString()))
        }
        catch (e: Exception){
            logger.error(e)
            ResponseEntity.internalServerError().body(responses.Errors(500, "Fatal Error, contact to support"))
        }
    }

    @GetMapping("tops/defense")
    suspend fun defense(@RequestParam(defaultValue = "1") page:Int, @RequestParam(defaultValue = "20") size:Int, request: HttpServletRequest): ResponseEntity<out Any?> {
        logger.info("init petition: ${request.method} - ${request.requestURI}")
        return try {
            logger.info("pagina: $page: tamaño: $size")
            val response = useCasesTops.defense(page = page, size= size)
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