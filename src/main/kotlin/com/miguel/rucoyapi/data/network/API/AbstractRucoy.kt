package com.miguel.rucoyapi.data.network.API

import com.miguel.rucoyapi.data.network.API.higcoresrucoy.DateHighScores
import com.miguel.rucoyapi.data.network.jsoup.Scrapper
import com.miguel.rucoyapi.domain.model.Date
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

abstract class AbstractRucoy : AbstractHigshScores() {
    private val logger: Logger = LogManager.getLogger(AbstractRucoy::class.java)
    suspend fun dates(type: String): List<Date?>? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://www.rucoyonline.com/highscores/$type"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val dates = DateHighScores(scrapper = scrapper).dateHighScores()
                return@withContext dates
            }
        } catch (e: Exception) {
            logger.fatal("dates fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun getDateFindByYears(type: String, year: String): List<Date?>? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://www.rucoyonline.com/highscores/$type"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val dates = DateHighScores(scrapper = scrapper).findDateByYear(year = year)
                return@withContext dates
            }

        } catch (e: Exception) {
            logger.fatal("getDateFindByYears fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun getDateFindByMonth(type: String, month: String): List<Date?>? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://www.rucoyonline.com/highscores/$type"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val dates = DateHighScores(scrapper = scrapper).findDateByMonth(month = month)
                return@withContext dates
            }
        } catch (e: Exception) {
            logger.fatal("getDateFindByMonth fail to: ${e.stackTraceToString()}")
            return null
        }
    }
}