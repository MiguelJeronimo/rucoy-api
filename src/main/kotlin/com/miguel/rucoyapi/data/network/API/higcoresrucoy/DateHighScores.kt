package com.miguel.rucoyapi.data.network.API.higcoresrucoy

import com.miguel.rucoyapi.domain.model.Date
import org.jsoup.nodes.Document

class DateHighScores(scrapper: Document) {
    private val ul = scrapper.getElementsByClass("dropdown-menu scrollable-menu")
    fun dateHighScores(): List<Date?> {
        val uls = ul.select("li")
        val result = uls.map {
            if (it.text().isNotEmpty()) {
                val data = it.text().split("/")
                return@map Date().apply {
                    this.path = it.select("a").attr("href")
                    this.month = data.first()
                    this.year = data.last()
                }
            } else {
                return@map null
            }
        }.filter { it != null }
        return result
    }

    fun findDateByYear(year:String): List<Date?> {
        val dates = this.dateHighScores()
        return dates.filter { it?.year == year }
    }

    fun findDateByMonth(month:String): List<Date?> {
        val dates = this.dateHighScores()
        return dates.filter { it?.month == month }
    }
}