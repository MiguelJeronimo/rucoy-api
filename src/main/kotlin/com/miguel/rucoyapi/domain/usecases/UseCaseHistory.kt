package com.miguel.rucoyapi.domain.usecases

import com.miguel.rucoyapi.data.repositories.db.RepositoryDate
import com.miguel.rucoyapi.data.repositories.db.RepositoryTopStats
import com.miguel.rucoyapi.domain.model.tops.History
import com.miguel.rucoyapi.domain.model.tops.HistoryDTo
import com.miguel.rucoyapi.domain.model.tops.Top
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UseCaseHistory {
    @Autowired private lateinit var repository: RepositoryTopStats
    @Autowired private lateinit var repositoryDate: RepositoryDate
    private val logger: Logger = LogManager.getLogger(UseCaseHistory::class.java)

    suspend fun history(name:String): HistoryDTo {
        val date = repositoryDate.getCurrentDate()
        val idDate = date!!.results[0].response.result!!.rows[0][0].value
        val response = repository.history(name, idDate!!)
        val listTop = ArrayList<History>()
        response?.results?.forEach {
            it.response.result?.rows?.forEach { row->
                val top = History(
                    rank = row[0].value!!.toInt(),
                    category = row[1].value,
                    name = row[2].value!!,
                    level = row[3].value!!.toInt(),
                    levels = row[4].value!!.toInt(),
                    startDate= row[5].value!!,
                    lastDate= row[6].value!!,
                    startDateTimeStamp = row[7].value!!.toLong(),
                    lastDateTimeStamp = row[8].value!!.toLong(),
                )
                listTop.add(top)
            }
        }
        return HistoryDTo().apply { tops = listTop }
    }
}