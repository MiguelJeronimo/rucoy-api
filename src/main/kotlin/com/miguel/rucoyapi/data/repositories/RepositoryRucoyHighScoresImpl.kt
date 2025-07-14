package com.miguel.rucoyapi.data.repositories

import com.miguel.rucoyapi.data.network.API.Rucoy
import model.Defense
import model.Distance
import model.HighScore
import model.Magic
import model.Mele

class RepositoryRucoyHighScoresImpl(private val rucoy: Rucoy): RepositoryRucoyHighScores {
    override fun experience(path: String): ArrayList<HighScore>? {
        return rucoy.highScores(path)
    }

    override fun experience(type: String, date: String): ArrayList<HighScore>? {
        return rucoy.highScores(type, date)
    }

    override fun melee(path: String): ArrayList<Mele>? {
        return rucoy.highScoresMele(path)
    }

    override fun melee(type: String, date: String): ArrayList<Mele>? {
        return rucoy.highScoresMele(type, date)
    }

    override fun distance(path: String): ArrayList<Distance>? {
        return rucoy.highScoresDistance(path)
    }

    override fun distance(type: String, date: String): ArrayList<Distance>? {
        return rucoy.highScoresDistance(type, date)
    }

    override fun magic(path: String): ArrayList<Magic>? {
        return rucoy.highScoresMagic(path)
    }

    override fun magic(type: String, date: String): ArrayList<Magic>? {
        return rucoy.highScoresMagic(type, date)
    }

    override fun defense(path: String): ArrayList<Defense>? {
        return rucoy.highScoresDefence(path)
    }

    override fun defense(type: String, date: String): ArrayList<Defense>? {
        return rucoy.highScoresDefence(type, date)
    }
}