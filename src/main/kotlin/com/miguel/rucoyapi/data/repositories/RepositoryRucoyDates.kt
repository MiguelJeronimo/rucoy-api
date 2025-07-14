package com.miguel.rucoyapi.data.repositories

import com.miguel.rucoyapi.domain.model.Date

interface RepositoryRucoyDates {
    fun dateHighScores(type:String): List<Date?>?
    fun dateHighScoresByYear(type:String, year:String): List<Date?>?
    fun dateHighScoresByMonth(type:String, month:String): List<Date?>?
}