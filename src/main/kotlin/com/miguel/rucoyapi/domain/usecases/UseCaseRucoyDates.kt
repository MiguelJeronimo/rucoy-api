package com.miguel.rucoyapi.domain.usecases

import com.miguel.rucoyapi.data.repositories.RepositoryRucoyDates
import com.miguel.rucoyapi.domain.model.Date

class UseCaseRucoyDates(private val repository: RepositoryRucoyDates) {
    suspend fun dates(type:String): List<Date?>? {
        return repository.dateHighScores(type)
    }

    suspend fun datesFindByYears(type:String, year:String):List<Date?>?{
        return repository.dateHighScoresByYear(type, year)
    }

    suspend fun datesFindByMonth(type:String, month:String): List<Date?>? {
        return repository.dateHighScoresByMonth(type, month)
    }
}