package com.miguel.rucoyapi.controllers

import API.news.New
import Jsoup.Scrapper
import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NewsController {
    @GetMapping("api/v1/news")
    fun getNews(): Any {
        return try {
            val news = Repository().NewsRucoy()
            if(news != null){
                return responses.response(200, news)
            } else {
                return responses.Errors(
                    400,
                    "no news found")
            }
        } catch (error: Exception){
            return responses.Errors(500, error.stackTraceToString())
        }
    }
}