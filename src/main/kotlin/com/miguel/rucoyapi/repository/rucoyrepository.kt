package com.miguel.rucoyapi.repository

import API.characters.CharactersRucoy
import API.creatures.Creatures
import API.guildss.GuildsData
import API.higcoresrucoy.*
import API.news.New
import Jsoup.Scrapper
import model.*

class Repository{
    fun SearchGuilds(guildName:String): Any? {
        try {
            val url = "https://www.rucoyonline.com/guild/${guildName}"
            val scrapper = Scrapper().Soup(url)
            val guilds = GuildsData().dataGuild(scrapper)
            return guilds
        } catch (e:Exception){
            println("ERROR: ${e.stackTraceToString()}")
            return null
        }
    }

    fun NewsRucoy(): Any? {
        try {
            val url = "https://www.rucoyonline.com/news"
            val scrapper = Scrapper().Soup(url)
            val news = New().NewsRucoy(scrapper)
            return news
        } catch (e: Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }

    }
    fun SearchCharacter(characterName: String): CharactersDataGeneral? {
        try {
            val url = "https://www.rucoyonline.com/characters/${characterName}"
            val scrapper = Scrapper().Soup(url)
            val character = CharactersRucoy().searchCharacter(scrapper)
            return character
        } catch (e:Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }
    }
    //higscores
    fun highScoresRucoyExperience(profession:String): ArrayList<HighScore>? {
        try {
            val url = "https://www.rucoyonline.com/highscores/${profession}"
            val scrapper = Scrapper().Soup(url)
            val highScore = HighScoreExperiencia(scrapper)
            return highScore
        } catch (e:Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }
    }
    fun highScoresRucoyMelee(profession:String): ArrayList<Mele>? {
        try {
            val url = "https://www.rucoyonline.com/highscores/${profession}"
            val scrapper = Scrapper().Soup(url)
            val highScore = hightScoreMele(scrapper)
            return highScore
        }catch (e:Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }
    }
    fun highScoresRucoyDistance(profession:String): ArrayList<Distance>? {
        try {
            val url = "https://www.rucoyonline.com/highscores/${profession}"
            val scrapper = Scrapper().Soup(url)
            val highScore = hightScoreDistance(scrapper)
            return highScore
        } catch (e:Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }
    }
    fun highScoresRucoyMagic(profession:String): ArrayList<Magic>? {
        try {
            val url = "https://www.rucoyonline.com/highscores/${profession}"
            val scrapper = Scrapper().Soup(url)
            val highScore = hightScoreMagic(scrapper)
            return highScore
        } catch (e:Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }
    }

    fun highScoresRucoyDefense(profession:String): ArrayList<Defense>? {
        try {
            val url = "https://www.rucoyonline.com/highscores/${profession}"
            val scrapper = Scrapper().Soup(url)
            val highScore = hightScoreDefense(scrapper)
            return highScore
        } catch (e:Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }
    }

    fun creatureProfile(creatureName:String): Any? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/${creatureName}"
            val scrapper = Scrapper().Soup(url)
            val creatureData = Creatures().getGeneralDataCreature(scrapper)
            return creatureData
        } catch (e:Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }
    }
}
