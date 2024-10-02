package com.miguel.rucoyapi.data.repositories

import model.*

interface RepositoryRucoy {
    fun guild(name: String): Guild?
    fun guilds(pager:String): GuildsListModel?
    fun news(): newsRucoy?
    fun character(name: String): CharactersDataGeneral?
    fun highScoresExperience(profession:String): ArrayList<HighScore>?
    fun highScoresMele(profession:String): ArrayList<Mele>?
    fun highScoresDistances(profession:String): ArrayList<Distance>?
    fun highScoresMagic(profession:String): ArrayList<Magic>?
    fun highScoresDefense(profession:String): ArrayList<Defense>?
}