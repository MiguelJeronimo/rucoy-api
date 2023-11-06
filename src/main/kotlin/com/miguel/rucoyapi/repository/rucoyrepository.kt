package com.miguel.rucoyapi.repository

import API.Items.Bows.BowsListRucoy
import API.Items.ItemsProfile.ItemsProfile
import API.Items.Potions.PotionsRucoy
import API.Items.Swords.SwordListRucoy
import API.Items.Wands.WandsListRucoy
import API.Items.items.Items
import API.characters.CharactersRucoy
import API.creatures.Creatures
import API.guildss.GuildsData
import API.higcoresrucoy.*
import API.news.New
import Jsoup.Scrapper
import model.*

class Repository{
    fun SearchGuilds(guildName:String): Guild? {
        try {
            val url = "https://www.rucoyonline.com/guild/${guildName}"
            val scrapper = Scrapper().Soup(url)
            val guilds = GuildsData().dataGuild(scrapper)
            return guilds
        } catch (e:Exception){
            println("ERROR: ${e.stackTraceToString()}")
            return null
        }
    }

    fun NewsRucoy(): newsRucoy? {
        try {
            val url = "https://www.rucoyonline.com/news"
            val scrapper = Scrapper().Soup(url)
            val news = New().NewsRucoy(scrapper)
            return news
        } catch (e: Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }

    }
    fun SearchCharacter(characterName: String): CharactersDataGeneral? {
        try {
            val url = "https://www.rucoyonline.com/characters/${characterName}"
            val scrapper = Scrapper().Soup(url)
            val character = CharactersRucoy().searchCharacter(scrapper)
            return character
        } catch (e:Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }
    }
    //higscores
    fun highScoresRucoyExperience(profession:String): ArrayList<HighScore>? {
        try {
            val url = "https://www.rucoyonline.com/highscores/${profession}"
            val scrapper = Scrapper().Soup(url)
            val highScore = HighScoreExperiencia(scrapper)
            return highScore
        } catch (e:Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }
    }
    fun highScoresRucoyMelee(profession:String): ArrayList<Mele>? {
        try {
            val url = "https://www.rucoyonline.com/highscores/${profession}"
            val scrapper = Scrapper().Soup(url)
            val highScore = hightScoreMele(scrapper)
            return highScore
        }catch (e:Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }
    }
    fun highScoresRucoyDistance(profession:String): ArrayList<Distance>? {
        try {
            val url = "https://www.rucoyonline.com/highscores/${profession}"
            val scrapper = Scrapper().Soup(url)
            val highScore = hightScoreDistance(scrapper)
            return highScore
        } catch (e:Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }
    }
    fun highScoresRucoyMagic(profession:String): ArrayList<Magic>? {
        try {
            val url = "https://www.rucoyonline.com/highscores/${profession}"
            val scrapper = Scrapper().Soup(url)
            val highScore = hightScoreMagic(scrapper)
            return highScore
        } catch (e:Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }
    }

    fun highScoresRucoyDefense(profession:String): ArrayList<Defense>? {
        try {
            val url = "https://www.rucoyonline.com/highscores/${profession}"
            val scrapper = Scrapper().Soup(url)
            val highScore = hightScoreDefense(scrapper)
            return highScore
        } catch (e:Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }
    }

    fun creatureProfile(creatureName:String): model.Creatures? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/${creatureName}"
            val scrapper = Scrapper().Soup(url)
            val creatureData = Creatures().getGeneralDataCreature(scrapper)
            return creatureData
        } catch (e:Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }
    }

    fun swordsList(): ItemsRucoyData? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Sword_List"
            val scrapper = Scrapper().Soup(url)
            val swordList = SwordListRucoy().getSwordList(scrapper)
            return swordList
        } catch (e:Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }
    }

    fun bowsList(): ArrayList<ItemRucoyData>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Bow_List"
            val scrapper = Scrapper().Soup(url)
            val bows_list = BowsListRucoy().getBowList(scrapper)
            return bows_list
        } catch (e:Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }
    }
    fun wandsList(): ArrayList<ItemRucoyData>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Wand_List"
            val scrapper = Scrapper().Soup(url)
            val wands_list = WandsListRucoy().getWandsList(scrapper)
            return wands_list
        } catch (e:Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }
    }
    fun itemProfile(name:String): ItemProfile? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/${name}"
            val scrapper = Scrapper().Soup(url)
            val wands_list = ItemsProfile().itemsProfile(scrapper)
            return wands_list
        } catch (e:Exception){
            println("Error: ${e.message}")
            return null
        }
    }

    fun getPotions(): ArrayList<ItemRucoyPotions>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Potions_List"
            val scrapper = Scrapper().Soup(url)
            val potions_list = PotionsRucoy().potionsList(scrapper)
            return potions_list
        } catch (e:Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }
    }
    fun getEquipment(): ArrayList<Category>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Equipment"
            val scrapper = Scrapper().Soup(url)
            val equipment = Items().getItemsList(scrapper)
            return equipment
        } catch (e:Exception){
            println("Error: ${e.stackTraceToString()}")
            return null
        }
    }
}
