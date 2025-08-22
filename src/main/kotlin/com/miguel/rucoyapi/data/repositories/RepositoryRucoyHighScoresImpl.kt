package com.miguel.rucoyapi.data.repositories

import com.miguel.rucoyapi.data.network.API.Rucoy
import model.Defense
import model.Distance
import model.HighScore
import model.Magic
import model.Mele

class RepositoryRucoyHighScoresImpl(private val rucoy: Rucoy): RepositoryRucoyHighScores {
    override suspend fun experience(path: String): ArrayList<HighScore>? {
        return rucoy.highScores(path)
    }

    override suspend fun experience(type: String, date: String): ArrayList<HighScore>? {
        return rucoy.highScores(type, date)
    }

    override suspend fun melee(path: String): ArrayList<Mele>? {
        return rucoy.highScoresMele(path)
    }

    override suspend fun melee(type: String, date: String): ArrayList<Mele>? {
        return rucoy.highScoresMele(type, date)
    }

    override suspend fun distance(path: String): ArrayList<Distance>? {
        return rucoy.highScoresDistance(path)
    }

    override suspend fun distance(type: String, date: String): ArrayList<Distance>? {
        return rucoy.highScoresDistance(type, date)
    }

    override suspend fun magic(path: String): ArrayList<Magic>? {
        return rucoy.highScoresMagic(path)
    }

    override suspend fun magic(type: String, date: String): ArrayList<Magic>? {
        return rucoy.highScoresMagic(type, date)
    }

    override suspend fun defense(path: String): ArrayList<Defense>? {
        return rucoy.highScoresDefence(path)
    }

    override suspend fun defense(type: String, date: String): ArrayList<Defense>? {
        return rucoy.highScoresDefence(type, date)
    }
}