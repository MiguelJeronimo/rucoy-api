package com.miguel.rucoyapi.data.repositories

import com.miguel.rucoyapi.data.network.API.Rucoy
import com.miguel.rucoyapi.domain.model.Date

class RepositoryRucoyDatesImpl(private val rucoy: Rucoy): RepositoryRucoyDates {
    override suspend fun dateHighScores(type: String): List<Date?>? {
        return rucoy.dates(type = type)
    }

    override suspend fun dateHighScoresByYear(type: String, year:String): List<Date?>? {
        return rucoy.getDateFindByYears(type = type, year = year)
    }

    override suspend fun dateHighScoresByMonth(type: String, month:String): List<Date?>? {
        return rucoy.getDateFindByMonth(type = type, month = month)
    }
}