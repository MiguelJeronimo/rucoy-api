package com.miguel.rucoyapi.controllers

import API.news.New
import Jsoup.Scrapper
import com.miguel.rucoyapi.model.responses
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NewsController {
    @GetMapping("/news")
    fun getNews(): Any {
        return try {
            val url = "https://www.rucoyonline.com/news"
            val scrapper = Scrapper().Soup(url)
            val news = New().NewsRucoy(scrapper)
            return responses.response(200, news)
        } catch (error: Exception){
            return responses.Errors(500, error.stackTraceToString())
        }

    }
}