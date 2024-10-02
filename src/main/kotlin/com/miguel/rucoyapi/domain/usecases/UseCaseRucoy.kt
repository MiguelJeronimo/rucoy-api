package com.miguel.rucoyapi.domain.usecases

import com.miguel.rucoyapi.data.repositories.RepositoryRucoy
import model.CharactersDataGeneral
import model.Guild
import model.GuildsListModel
import model.newsRucoy
import java.util.ArrayList

class UseCaseRucoy(private val rucoy: RepositoryRucoy) {
    fun character(name:String): CharactersDataGeneral? {
        return rucoy.character(name)
    }
    fun guild(name:String): Guild? {
        return rucoy.guild(name)
    }
    fun guilds(pager:String): GuildsListModel? {
        return rucoy.guilds(pager)
    }

    fun highScores(skill: String): ArrayList<out Any>? {
        return when(skill){
            "experience"->{rucoy.highScoresExperience(skill)}
            "melee"->{rucoy.highScoresMele(skill)}
            "distance"->{rucoy.highScoresDistances(skill)}
            "magic"->{rucoy.highScoresMagic(skill)}
            "defense"->{rucoy.highScoresDefense(skill)}
            else -> {null}
        }
    }

    fun news(): newsRucoy? {
        return rucoy.news()
    }
}