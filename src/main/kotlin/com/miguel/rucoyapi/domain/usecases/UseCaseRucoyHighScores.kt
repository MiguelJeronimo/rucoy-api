package com.miguel.rucoyapi.domain.usecases

import com.miguel.rucoyapi.data.repositories.RepositoryRucoyHighScores
import model.Defense
import model.Distance
import model.HighScore
import model.Magic
import model.Mele

class UseCaseRucoyHighScores(private val repositoryRucoyHighScores: RepositoryRucoyHighScores) {
    suspend fun experience(path:String):ArrayList<HighScore>?{
        return repositoryRucoyHighScores.experience(path)
    }
    suspend fun experience(type:String, date:String):ArrayList<HighScore>?{
        return repositoryRucoyHighScores.experience(type, date)
    }
    suspend fun melee(path:String): ArrayList<Mele>?{
        return repositoryRucoyHighScores.melee(path)
    }
    suspend fun melee(type:String, date:String): ArrayList<Mele>?{
        return repositoryRucoyHighScores.melee(type, date)
    }
    suspend fun distance(path:String): ArrayList<Distance>?{
        return repositoryRucoyHighScores.distance(path)
    }
    suspend fun distance(type:String, date:String): ArrayList<Distance>?{
        return repositoryRucoyHighScores.distance(type, date)
    }
    suspend fun magic(path:String): ArrayList<Magic>?{
        return repositoryRucoyHighScores.magic(path)
    }
    suspend fun magic(type:String, date:String): ArrayList<Magic>?{
        return repositoryRucoyHighScores.magic(type, date)
    }
    suspend fun defense(path:String): ArrayList<Defense>?{
        return repositoryRucoyHighScores.defense(path)
    }
    suspend fun defense(type:String, date:String): ArrayList<Defense>?{
        return repositoryRucoyHighScores.defense(type, date)
    }
}