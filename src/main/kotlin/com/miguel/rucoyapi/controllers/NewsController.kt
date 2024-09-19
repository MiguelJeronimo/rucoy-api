package com.miguel.rucoyapi.controllers

import API.news.New
import Jsoup.Scrapper
import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NewsController {
    private val logger: Logger = LogManager.getLogger(NewsController::class.java)
    @GetMapping("api/v1/news")
    fun getNews(): Any {
        logger.info("init petition")
        return try {
            val news = Repository().NewsRucoy()
            if(news != null){
                logger.info("Final response success")
                ResponseEntity.ok().body(responses.response(200, news))
            } else {
                logger.error("Error: ${
                    responses.Errors(
                        400,
                        "no news found")
                }")
                ResponseEntity.badRequest().body(responses.Errors(
                    400,
                    "no news found"))
            }
        } catch (error: Exception){
            logger.fatal("Failure by: ${error.stackTraceToString()}")
            ResponseEntity.internalServerError().body(responses.Errors(500, error.stackTraceToString()))
        }
    }
}