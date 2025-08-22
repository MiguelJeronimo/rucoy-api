package com.miguel.rucoyapi.data.repositories

import com.miguel.rucoyapi.domain.model.Date

interface RepositoryRucoyDates {
    suspend fun dateHighScores(type:String): List<Date?>?
    suspend fun dateHighScoresByYear(type:String, year:String): List<Date?>?
    suspend fun dateHighScoresByMonth(type:String, month:String): List<Date?>?
}