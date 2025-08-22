package com.miguel.rucoyapi.data.repositories

import model.*

interface RepositoryRucoy {
    suspend fun guild(name: String): Guild?
    suspend fun guilds(pager:String): GuildsListModel?
    suspend fun news(): newsRucoy?
    suspend fun character(name: String): CharactersDataGeneral?
    suspend fun highScoresExperience(profession:String): ArrayList<HighScore>?
    suspend fun highScoresMele(profession:String): ArrayList<Mele>?
    suspend fun highScoresDistances(profession:String): ArrayList<Distance>?
    suspend fun highScoresMagic(profession:String): ArrayList<Magic>?
    suspend fun highScoresDefense(profession:String): ArrayList<Defense>?
}