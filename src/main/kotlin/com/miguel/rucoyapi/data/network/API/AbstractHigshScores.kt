package com.miguel.rucoyapi.data.network.API

import com.miguel.rucoyapi.data.network.API.higcoresrucoy.HighScores
import com.miguel.rucoyapi.data.network.jsoup.Scrapper
import model.Defense
import model.Distance
import model.HighScore
import model.Magic
import model.Mele
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.util.ArrayList

abstract class AbstractHigshScores {
    private val logger: Logger = LogManager.getLogger(AbstractHigshScores::class.java)
    fun highScores(path:String): ArrayList<HighScore>? {
        try {
            val url = "https://www.rucoyonline.com${path}"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val highScore = HighScores(scrapper).highScores()
            logger.info("Experience: $highScore")
            return highScore
        } catch (e:Exception){
            logger.fatal("highScoresRucoyExperience fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    fun highScores(type:String,date:String): ArrayList<HighScore>? {
        try {
            val url = "https://www.rucoyonline.com/highscores/$type/$date"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val highScore = HighScores(scrapper).highScores()
            logger.info("Experience: $highScore")
            return highScore
        } catch (e:Exception){
            logger.fatal("highScoresRucoyExperience fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    fun highScoresMele(path:String): ArrayList<Mele>? {
        try {
            val url = "https://www.rucoyonline.com${path}"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val highScore = HighScores(scrapper).hightScoreMele(scrapper)
            logger.info("Experience: $highScore")
            return highScore
        } catch (e:Exception){
            logger.fatal("highScoresRucoyExperience fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    fun highScoresMele(type:String,date:String): ArrayList<Mele>? {
        try {
            val url = "https://www.rucoyonline.com/highscores/$type/$date"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val highScore = HighScores(scrapper).hightScoreMele(scrapper)
            logger.info("Experience: $highScore")
            return highScore
        } catch (e:Exception){
            logger.fatal("highScoresRucoyExperience fail to: ${e.stackTraceToString()}")
            return null
        }
    }
    fun highScoresDistance(path:String): ArrayList<Distance>? {
        try {
            val url = "https://www.rucoyonline.com${path}"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val highScore = HighScores(scrapper).hightScoreDistance(scrapper)
            logger.info("Experience: $highScore")
            return highScore
        } catch (e:Exception){
            logger.fatal("highScoresRucoyExperience fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    fun highScoresDistance(type:String,date:String): ArrayList<Distance>? {
        try {
            val url = "https://www.rucoyonline.com/highscores/$type/$date"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val highScore = HighScores(scrapper).hightScoreDistance(scrapper)
            logger.info("Experience: $highScore")
            return highScore
        } catch (e:Exception){
            logger.fatal("highScoresRucoyExperience fail to: ${e.stackTraceToString()}")
            return null
        }
    }
    fun highScoresMagic(path:String): ArrayList<Magic>? {
        try {
            val url = "https://www.rucoyonline.com${path}"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val highScore = HighScores(scrapper).hightScoreMagic(scrapper)
            logger.info("Experience: $highScore")
            return highScore
        } catch (e:Exception){
            logger.fatal("highScoresRucoyExperience fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    fun highScoresMagic(type:String,date:String): ArrayList<Magic>? {
        try {
            val url = "https://www.rucoyonline.com/highscores/$type/$date"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val highScore = HighScores(scrapper).hightScoreMagic(scrapper)
            logger.info("Experience: $highScore")
            return highScore
        } catch (e:Exception){
            logger.fatal("highScoresRucoyExperience fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    fun highScoresDefence(path:String): ArrayList<Defense>? {
        try {
            val url = "https://www.rucoyonline.com${path}"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val highScore = HighScores(scrapper).hightScoreDefense(scrapper)
            logger.info("Experience: $highScore")
            return highScore
        } catch (e:Exception){
            logger.fatal("highScoresRucoyExperience fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    fun highScoresDefence(type:String,date:String): ArrayList<Defense>? {
        try {
            val url = "https://www.rucoyonline.com/highscores/$type/$date"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val highScore = HighScores(scrapper).hightScoreDefense(scrapper)
            logger.info("Experience: $highScore")
            return highScore
        } catch (e:Exception){
            logger.fatal("highScoresRucoyExperience fail to: ${e.stackTraceToString()}")
            return null
        }
    }
}