package com.miguel.rucoyapi.data.repositories

import model.Defense
import model.Distance
import model.HighScore
import model.Magic
import model.Mele
import java.util.ArrayList

interface RepositoryRucoyHighScores {
    suspend fun experience(path:String): ArrayList<HighScore>?
    suspend fun experience(type:String,date:String):ArrayList<HighScore>?
    suspend fun melee(path:String): ArrayList<Mele>?
    suspend fun melee(type:String,date:String): ArrayList<Mele>?
    suspend fun distance(path:String): ArrayList<Distance>?
    suspend fun distance(type:String,date:String): ArrayList<Distance>?
    suspend fun magic(path:String): ArrayList<Magic>?
    suspend fun magic(type:String,date:String): ArrayList<Magic>?
    suspend fun defense(path:String): ArrayList<Defense>?
    suspend fun defense(type:String,date:String): ArrayList<Defense>?
}