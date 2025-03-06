package com.miguel.rucoyapi.data.repositories

import com.miguel.rucoyapi.data.network.API.Rucoy
import model.*

class RepositoryRucoyImp(private val rucoy: Rucoy): RepositoryRucoy {
    override fun guild(name: String): Guild? {
        return rucoy.SearchGuilds(name)
    }

    override fun guilds(pager:String): GuildsListModel? {
        return rucoy.guildsList(pager)
    }

    override fun news(): newsRucoy? {
        return rucoy.NewsRucoy()
    }

    override fun character(name: String): CharactersDataGeneral? {
        return rucoy.SearchCharacter(name)
    }

    override fun highScoresExperience(profession: String): ArrayList<HighScore>? {
        return rucoy.highScoresRucoyExperience(profession)
    }

    override fun highScoresMele(profession: String): ArrayList<Mele>? {
        return rucoy.highScoresRucoyMelee(profession)
    }

    override fun highScoresDistances(profession: String): ArrayList<Distance>? {
        return rucoy.highScoresRucoyDistance(profession)
    }

    override fun highScoresMagic(profession: String): ArrayList<Magic>? {
        return rucoy.highScoresRucoyMagic(profession)
    }

    override fun highScoresDefense(profession: String): ArrayList<Defense>? {
        return rucoy.highScoresRucoyDefense(profession)
    }

}