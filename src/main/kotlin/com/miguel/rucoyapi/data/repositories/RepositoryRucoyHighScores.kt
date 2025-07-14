package com.miguel.rucoyapi.data.repositories

import model.Defense
import model.Distance
import model.HighScore
import model.Magic
import model.Mele

interface RepositoryRucoyHighScores {
    fun experience(path:String):ArrayList<HighScore>?
    fun experience(type:String,date:String):ArrayList<HighScore>?
    fun melee(path:String): ArrayList<Mele>?
    fun melee(type:String,date:String): ArrayList<Mele>?
    fun distance(path:String): ArrayList<Distance>?
    fun distance(type:String,date:String): ArrayList<Distance>?
    fun magic(path:String): ArrayList<Magic>?
    fun magic(type:String,date:String): ArrayList<Magic>?
    fun defense(path:String): ArrayList<Defense>?
    fun defense(type:String,date:String): ArrayList<Defense>?
}