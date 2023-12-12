package com.miguel.rucoyapi.repository

import API.Items.Armor.ArmorRucoyList
import API.Items.BackPack.BackPackList
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
            println("Error: ${e.message}")
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
            println("Error: ${e.message}")
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
            println("Error: ${e.message}")
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
            println("Error: ${e.message}")
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
            println("Error: ${e.message}")
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
            println("Error: ${e.message}")
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
            println("Error: ${e.message}")
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
            println("Error: ${e.message}")
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
            println("Error: ${e.message}")
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
            println("Error: ${e.message}")
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
            println("Error: ${e.message}")
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
            println("Error: ${e.message}")
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

    fun getPotions(): ArrayList<Potion>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Potions_List"
            val scrapper = Scrapper().Soup(url)
            val potions_list = PotionsRucoy().getItemPotionsRucoy(scrapper)
            return potions_list
        } catch (e:Exception){
            println("Error: ${e.message}")
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
            println("Error: ${e.message}")
            return null
        }
    }
    /*items catalog*/

    //val urlCreatures = "https://rucoy-online.fandom.com/wiki/Evil Santa"
    //val urlCreatures = "https://rucoy-online.fandom.com/wiki/Dragon Warden"
    //val urlItems = "https://rucoy-online.fandom.com/wiki/Sword_List"
//    val urlItems = "https://rucoy-online.fandom.com/wiki/Rings_List"
//    val backpack = "https://rucoy-online.fandom.com/wiki/Backpack_List"
//    val belts = "https://rucoy-online.fandom.com/wiki/Belts_List"
//    val legs = "https://rucoy-online.fandom.com/wiki/Legs_List"
//    val url = "https://rucoy-online.fandom.com/wiki/Pendants_List"
//    val hats = "https://rucoy-online.fandom.com/wiki/Hats_List"
//    val hoods = "https://rucoy-online.fandom.com/wiki/Hoods_List"
//    val helmets = "https://rucoy-online.fandom.com/wiki/Helmet_List"
//    val boots = "https://rucoy-online.fandom.com/wiki/Boots_List"
//    val shield = "https://rucoy-online.fandom.com/wiki/Shield_List"
//    val robes = "https://rucoy-online.fandom.com/wiki/Robes_List"
//    val light_armor = "https://rucoy-online.fandom.com/wiki/Light_Armor_List"
//    val armor = "https://rucoy-online.fandom.com/wiki/Armor_List"
    fun getArmors(): ArrayList<Armor>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Armor_List"
            val scrapper = Scrapper().Soup(url)
            val armor_list = ArmorRucoyList().getArmorList(scrapper)
            return armor_list
        } catch (e:Exception){
            println("Error: ${e.message}")
            return null
        }
    }

    fun getBackPacks(): ArrayList<BackPack>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Backpack_List"
            val scrapper = Scrapper().Soup(url)
            val backpacks = BackPackList().getBackPackList(scrapper)
            return backpacks
        } catch (e:Exception){
            println("Error: ${e.message}")
            return null
        }
    }

}
