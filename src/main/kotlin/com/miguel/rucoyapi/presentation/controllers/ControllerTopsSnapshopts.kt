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

@RestController
@RequestMapping("api/v1/")
class ControllerTopsSnapshopts(@Autowired private val useCasesTops: UseCasesTops) {
    private val logger: Logger = LogManager.getLogger(ControllerTopsSnapshopts::class.java)

    @GetMapping("tops")
    suspend fun experience(@RequestParam(defaultValue = "1") page:Int, @RequestParam(defaultValue = "20") size:Int): ResponseEntity<out Any?> {
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
}