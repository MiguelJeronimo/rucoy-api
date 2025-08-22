package com.miguel.rucoyapi.data.repositories

import com.miguel.rucoyapi.data.network.API.Rucoy
import model.*

class RepositoryRucoyImp(private val rucoy: Rucoy): RepositoryRucoy {
    override suspend fun guild(name: String): Guild? {
        return rucoy.SearchGuilds(name)
    }

    override suspend fun guilds(pager:String): GuildsListModel? {
        return rucoy.guildsList(pager)
    }

    override suspend fun news(): newsRucoy? {
        return rucoy.NewsRucoy()
    }

    override suspend fun character(name: String): CharactersDataGeneral? {
        return rucoy.SearchCharacter(name)
    }

    override suspend fun highScoresExperience(profession: String): ArrayList<HighScore>? {
        return rucoy.highScoresRucoyExperience(profession)
    }

    override suspend fun highScoresMele(profession: String): ArrayList<Mele>? {
        return rucoy.highScoresRucoyMelee(profession)
    }

    override suspend fun highScoresDistances(profession: String): ArrayList<Distance>? {
        return rucoy.highScoresRucoyDistance(profession)
    }

    override suspend fun highScoresMagic(profession: String): ArrayList<Magic>? {
        return rucoy.highScoresRucoyMagic(profession)
    }

    override suspend fun highScoresDefense(profession: String): ArrayList<Defense>? {
        return rucoy.highScoresRucoyDefense(profession)
    }
}