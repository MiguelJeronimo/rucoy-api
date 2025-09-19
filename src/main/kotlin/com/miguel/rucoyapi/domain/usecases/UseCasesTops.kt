package com.miguel.rucoyapi.domain.usecases

import com.miguel.rucoyapi.data.repositories.db.RepositoryCategory
import com.miguel.rucoyapi.data.repositories.db.RepositoryDate
import com.miguel.rucoyapi.data.repositories.db.RepositoryTops
import com.miguel.rucoyapi.domain.model.tops.Top
import com.miguel.rucoyapi.domain.model.tops.TopsDto
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UseCasesTops {
    @Autowired private lateinit var repository: RepositoryTops
    @Autowired private lateinit var repositoryCategory: RepositoryCategory
    @Autowired private lateinit var repositoryDate: RepositoryDate
    private val logger: Logger = LogManager.getLogger(UseCasesTops::class.java)

    suspend fun experience(page:Int, size: Int): TopsDto {
        val offset = (page - 1) * size
        val categories = repositoryCategory.getAllCategory()
        val date = repositoryDate.getCurrentDate()
        val idExperience = categories!!.results[0].response.result!!.rows[0][0].value
        val idDate = date!!.results[0].response.result!!.rows[0][0].value
        logger.info(idExperience)
        logger.info(idDate)
        val response = repository.experience(page= offset, size =  size, id = idExperience!!, idSnapshot =  idDate!!)
        val listTop = ArrayList<Top>()
        response?.results?.forEach {
            it.response.result?.rows?.forEach { row->
                val top = Top(
                    rank = row[0].value!!.toInt(),
                    idCharacter = row[1].value!!,
                    name = row[2].value!!,
                    level = row[3].value!!.toInt(),
                    startDateTimeStamp = row[4].value!!.toLong(),
                    lastDateTimeStamp = row[5].value!!.toLong(),
                    startDate= row[6].value!!,
                    lastDate= row[7].value!!,
                    experience = row[8].value!!.toLong(),
                    experienceString = row[9].value!!,
                    levels = row[10].value!!.toInt(),
                    gainExp = row[11].value,
                    progressPercent = row[12].value,
                    category = row[13].value
                )
                listTop.add(top)
            }
        }
        return TopsDto().apply { tops = listTop }
    }

    suspend fun melee(page:Int, size: Int): TopsDto {
        val offset = (page - 1) * size
        val categories = repositoryCategory.getAllCategory()
        val date = repositoryDate.getCurrentDate()
        val idMelee = categories!!.results[0].response.result!!.rows[1][0].value
        val idDate = date!!.results[0].response.result!!.rows[0][0].value
        logger.info(idMelee)
        logger.info(idDate)
        val response= repository.melee(page=offset,size=size, id= idMelee!!, idSnapshot = idDate!!)
        logger.info("RESPONSE: ${response?.results}")
        val listTop = ArrayList<Top>()
        response?.results?.forEach {
            it.response.result?.rows?.forEach { row->
                val top = Top(
                    rank = row[0].value!!.toInt(),
                    idCharacter = row[1].value!!,
                    name = row[2].value!!,
                    level = row[3].value!!.toInt(),
                    startDateTimeStamp = row[4].value!!.toLong(),
                    lastDateTimeStamp = row[5].value!!.toLong(),
                    startDate= row[6].value!!,
                    lastDate= row[7].value!!,
                    experience = row[8].value?.toLong(),
                    experienceString = row[9].value?.ifBlank { null },
                    levels = row[10].value!!.toInt(),
                    gainExp = row[11].value,
                    progressPercent = row[12].value,
                    category = row[13].value
                )
                listTop.add(top)
            }
        }
        return TopsDto().apply { tops = listTop }
    }

    suspend fun distance(page:Int, size: Int): TopsDto {
        val offset = (page - 1) * size
        val categories = repositoryCategory.getAllCategory()
        val date = repositoryDate.getCurrentDate()
        val idMelee = categories!!.results[0].response.result!!.rows[2][0].value
        val idDate = date!!.results[0].response.result!!.rows[0][0].value
        logger.info(idMelee)
        logger.info(idDate)
        val response= repository.distance(page=offset,size=size, id= idMelee!!, idSnapshot = idDate!!)
        logger.info("RESPONSE: ${response?.results}")
        val listTop = ArrayList<Top>()
        response?.results?.forEach {
            it.response.result?.rows?.forEach { row->
                val top = Top(
                    rank = row[0].value!!.toInt(),
                    idCharacter = row[1].value!!,
                    name = row[2].value!!,
                    level = row[3].value!!.toInt(),
                    startDateTimeStamp = row[4].value!!.toLong(),
                    lastDateTimeStamp = row[5].value!!.toLong(),
                    startDate= row[6].value!!,
                    lastDate= row[7].value!!,
                    experience = row[8].value?.toLong(),
                    experienceString = row[9].value?.ifBlank { null },
                    levels = row[10].value?.toInt(),
                    gainExp = row[11].value,
                    progressPercent = row[12].value,
                    category = row[13].value
                )
                listTop.add(top)
            }
        }
        return TopsDto().apply { tops = listTop }
    }

    suspend fun magic(page:Int, size: Int): TopsDto {
        val offset = (page - 1) * size
        val categories = repositoryCategory.getAllCategory()
        val date = repositoryDate.getCurrentDate()
        val idMelee = categories!!.results[0].response.result!!.rows[3][0].value
        val idDate = date!!.results[0].response.result!!.rows[0][0].value
        logger.info(idMelee)
        logger.info(idDate)
        val response= repository.magic(page=offset,size=size, id= idMelee!!, idSnapshot = idDate!!)
        logger.info("RESPONSE: ${response?.results}")
        val listTop = ArrayList<Top>()
        response?.results?.forEach {
            it.response.result?.rows?.forEach { row->
                val top = Top(
                    rank = row[0].value!!.toInt(),
                    idCharacter = row[1].value!!,
                    name = row[2].value!!,
                    level = row[3].value!!.toInt(),
                    startDateTimeStamp = row[4].value!!.toLong(),
                    lastDateTimeStamp = row[5].value!!.toLong(),
                    startDate= row[6].value!!,
                    lastDate= row[7].value!!,
                    experience = row[8].value?.toLong(),
                    experienceString = row[9].value?.ifBlank { null },
                    levels = row[10].value!!.toInt(),
                    gainExp = row[11].value,
                    progressPercent = row[12].value,
                    category = row[13].value
                )
                listTop.add(top)
            }
        }
        return TopsDto().apply { tops = listTop }
    }

    suspend fun defense(page:Int, size: Int): TopsDto {
        val offset = (page - 1) * size
        val categories = repositoryCategory.getAllCategory()
        val date = repositoryDate.getCurrentDate()
        val idMelee = categories!!.results[0].response.result!!.rows[4][0].value
        val idDate = date!!.results[0].response.result!!.rows[0][0].value
        logger.info(idMelee)
        logger.info(idDate)
        val response= repository.defense(page=offset,size=size, id= idMelee!!, idSnapshot = idDate!!)
        logger.info("RESPONSE: ${response?.results}")
        val listTop = ArrayList<Top>()
        response?.results?.forEach {
            it.response.result?.rows?.forEach { row->
                val top = Top(
                    rank = row[0].value!!.toInt(),
                    idCharacter = row[1].value!!,
                    name = row[2].value!!,
                    level = row[3].value!!.toInt(),
                    startDateTimeStamp = row[4].value!!.toLong(),
                    lastDateTimeStamp = row[5].value!!.toLong(),
                    startDate= row[6].value!!,
                    lastDate= row[7].value!!,
                    experience = row[8].value?.toLong(),
                    experienceString = row[9].value?.ifBlank { null },
                    levels = row[10].value!!.toInt(),
                    gainExp = row[11].value,
                    progressPercent = row[12].value,
                    category = row[13].value
                )
                listTop.add(top)
            }
        }
        return TopsDto().apply { tops = listTop }
    }
}