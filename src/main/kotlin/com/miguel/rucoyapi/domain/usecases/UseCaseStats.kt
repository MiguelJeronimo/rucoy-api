package com.miguel.rucoyapi.domain.usecases

import com.miguel.rucoyapi.data.repositories.db.RepositoryCategory
import com.miguel.rucoyapi.data.repositories.db.RepositoryTopStats
import com.miguel.rucoyapi.domain.model.tops.TopStats
import com.miguel.rucoyapi.domain.model.tops.TopsStatsDto
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UseCaseStats {
    @Autowired private lateinit var repository: RepositoryTopStats
    @Autowired private lateinit var repositoryCategory: RepositoryCategory
    private val logger: Logger = LogManager.getLogger(UseCaseStats::class.java)

    suspend fun statsExperienceByName(name:String): TopsStatsDto {
        val categories = repositoryCategory.getAllCategory()
        val idExperience = categories!!.results[0].response.result!!.rows[0][0].value
        val stats = repository.getStatsByName(name,idExperience!!)
        val listTop = ArrayList<TopStats>()
        stats?.results?.forEach {
            it.response.result?.rows?.forEach { row->
                val top = TopStats(
                    rank = row[0].value!!.toInt(),
                    idCharacter = row[1].value!!,
                    name = row[2].value!!,
                    level = row[3].value!!.toInt(),
                    levels = row[4].value!!.toInt(),
                    gainExp = row[5].value!!,
                    progress = row[6].value?.toFloat(),
                    progressPercent = row[7].value!!,
                    experience = row[8].value!!.toLong(),
                    experienceString = row[9].value!!,
                    startDate= row[10].value!!,
                    lastDate= row[11].value!!,
                    startDateTimeStamp = row[12].value!!.toLong(),
                    lastDateTimeStamp = row[13].value!!.toLong(),
                    category = row[14].value
                )
                listTop.add(top)
            }
        }
        return TopsStatsDto().apply { tops = listTop }
    }

    suspend fun statsMeleeByName(name:String): TopsStatsDto {
        val categories = repositoryCategory.getAllCategory()
        val idCategory = categories!!.results[0].response.result!!.rows[1][0].value
        val stats = repository.getStatsByName(name,idCategory!!)
        val listTop = ArrayList<TopStats>()
        stats?.results?.forEach {
            it.response.result?.rows?.forEach { row->
                val top = TopStats(
                    rank = row[0].value!!.toInt(),
                    idCharacter = row[1].value!!,
                    name = row[2].value!!,
                    level = row[3].value!!.toInt(),
                    levels = row[4].value!!.toInt(),
                    gainExp = row[5].value?.ifBlank { null },
                    progress = row[6].value?.toFloat(),
                    progressPercent = row[7].value?.ifBlank { null },
                    experience = row[8].value?.toLong(),
                    experienceString = row[9].value?.ifBlank { null },
                    startDate= row[10].value!!,
                    lastDate= row[11].value!!,
                    startDateTimeStamp = row[12].value!!.toLong(),
                    lastDateTimeStamp = row[13].value!!.toLong(),
                    category = row[14].value
                )
                listTop.add(top)
            }
        }
        return TopsStatsDto().apply { tops = listTop }
    }

    suspend fun statsDistanceByName(name:String): TopsStatsDto {
        val categories = repositoryCategory.getAllCategory()
        val idCategory = categories!!.results[0].response.result!!.rows[2][0].value
        val stats = repository.getStatsByName(name,idCategory!!)
        val listTop = ArrayList<TopStats>()
        stats?.results?.forEach {
            it.response.result?.rows?.forEach { row->
                val top = TopStats(
                    rank = row[0].value!!.toInt(),
                    idCharacter = row[1].value!!,
                    name = row[2].value!!,
                    level = row[3].value!!.toInt(),
                    levels = row[4].value!!.toInt(),
                    gainExp = row[5].value?.ifBlank { null },
                    progress = row[6].value?.toFloat(),
                    progressPercent = row[7].value?.ifBlank { null },
                    experience = row[8].value?.toLong(),
                    experienceString = row[9].value?.ifBlank { null },
                    startDate= row[10].value!!,
                    lastDate= row[11].value!!,
                    startDateTimeStamp = row[12].value!!.toLong(),
                    lastDateTimeStamp = row[13].value!!.toLong(),
                    category = row[14].value
                )
                listTop.add(top)
            }
        }
        return TopsStatsDto().apply { tops = listTop }
    }

    suspend fun statsMagicByName(name:String): TopsStatsDto {
        val categories = repositoryCategory.getAllCategory()
        val idCategory = categories!!.results[0].response.result!!.rows[3][0].value
        val stats = repository.getStatsByName(name,idCategory!!)
        val listTop = ArrayList<TopStats>()
        stats?.results?.forEach {
            it.response.result?.rows?.forEach { row->
                val top = TopStats(
                    rank = row[0].value!!.toInt(),
                    idCharacter = row[1].value!!,
                    name = row[2].value!!,
                    level = row[3].value!!.toInt(),
                    levels = row[4].value!!.toInt(),
                    gainExp = row[5].value?.ifBlank { null },
                    progress = row[6].value?.toFloat(),
                    progressPercent = row[7].value?.ifBlank { null },
                    experience = row[8].value?.toLong(),
                    experienceString = row[9].value?.ifBlank { null },
                    startDate= row[10].value!!,
                    lastDate= row[11].value!!,
                    startDateTimeStamp = row[12].value!!.toLong(),
                    lastDateTimeStamp = row[13].value!!.toLong(),
                    category = row[14].value
                )
                listTop.add(top)
            }
        }
        return TopsStatsDto().apply { tops = listTop }
    }

    suspend fun statsDefenseByName(name:String): TopsStatsDto {
        val categories = repositoryCategory.getAllCategory()
        val idCategory = categories!!.results[0].response.result!!.rows[4][0].value
        val stats = repository.getStatsByName(name,idCategory!!)
        val listTop = ArrayList<TopStats>()
        stats?.results?.forEach {
            it.response.result?.rows?.forEach { row->
                val top = TopStats(
                    rank = row[0].value!!.toInt(),
                    idCharacter = row[1].value!!,
                    name = row[2].value!!,
                    level = row[3].value!!.toInt(),
                    levels = row[4].value!!.toInt(),
                    gainExp = row[5].value?.ifBlank { null },
                    progress = row[6].value?.toFloat(),
                    progressPercent = row[7].value?.ifBlank { null },
                    experience = row[8].value?.toLong(),
                    experienceString = row[9].value?.ifBlank { null },
                    startDate= row[10].value!!,
                    lastDate= row[11].value!!,
                    startDateTimeStamp = row[12].value!!.toLong(),
                    lastDateTimeStamp = row[13].value!!.toLong(),
                    category = row[14].value
                )
                listTop.add(top)
            }
        }
        return TopsStatsDto().apply { tops = listTop }
    }
}