package com.miguel.rucoyapi.data.network.API

import API.Items.Armor.ArmorRucoyList
import API.Items.BackPack.BackPackList
import API.Items.Belts.BeltsRucoyList
import API.Items.Boots.BootsRucoyList
import API.Items.Bows.BowsListRucoy
import API.Items.Hats.HatsRucoyList
import API.Items.Helmets.HelmetsRucoyList
import API.Items.Hoods.HoodsRucoyList
import API.Items.ItemsProfile.ItemsProfile
import API.Items.Legs.LegsRucoyList
import API.Items.LightArmor.LightArmorList
import API.Items.Pendants.PendantsRucoyList
import API.Items.Potions.PotionsRucoy
import API.Items.Rings.RingsList
import API.Items.Robes.RobesRucoyList
import API.Items.Shield.ShieldRucoyList
import API.Items.Swords.SwordListRucoy
import API.Items.Wands.WandsListRucoy
import API.Items.items.Items
import API.characters.CharactersRucoy
import API.creatures.Creatures
import API.guildss.GuildsData
import API.higcoresrucoy.*
import API.news.New
import com.miguel.rucoyapi.data.network.jsoup.Scrapper
import model.*
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class Rucoy(): AbstractRucoy() {
    private val logger: Logger = LogManager.getLogger(Rucoy::class.java)
    fun SearchGuilds(guildName:String): Guild? {
        try {
            val url = "https://www.rucoyonline.com/guild/${guildName}"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val guilds = GuildsData().dataGuild(scrapper)
            logger.info("GuildData: $guilds")
            return guilds
        } catch (e:Exception){
            logger.fatal("SearchGuild fail to: ${e.stackTraceToString()}")
            return null
        }
    }
    fun guildsList(pager:String): GuildsListModel? {
        try {
            val url = "https://www.rucoyonline.com/guilds?page=$pager"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val guilds = com.miguel.rucoyapi.data.network.API.guildss.Guilds().getGuildsList(scrapper)
            logger.info("Guilds: $guilds")
            return guilds
        } catch (e:Exception){
            logger.fatal("GuildsList fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    fun NewsRucoy(): newsRucoy? {
        try {
            val url = "https://www.rucoyonline.com/news"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val news = New().NewsRucoy(scrapper)
            logger.info("News: $news")
            return news
        } catch (e: Exception){
            logger.fatal("NewsRucoy fail to: ${e.stackTraceToString()}")
            return null
        }

    }
    fun SearchCharacter(characterName: String): CharactersDataGeneral? {
        try {
            val url = "https://www.rucoyonline.com/characters/${characterName}"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val character = CharactersRucoy().searchCharacter(scrapper)
            logger.info("Character info: $character")
            return character
        } catch (e:Exception){
            logger.fatal("SearchCharacter fail to: ${e.stackTraceToString()}")
            return null
        }
    }
    //higscores
    fun highScoresRucoyExperience(profession:String): ArrayList<HighScore>? {
        try {
            val url = "https://www.rucoyonline.com/highscores/${profession}"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val highScore = HighScoreExperiencia(scrapper)
            logger.info("Experience: $highScore")
            return highScore
        } catch (e:Exception){
            logger.fatal("highScoresRucoyExperience fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    fun highScoresRucoyMelee(profession:String): ArrayList<Mele>? {
        try {
            val url = "https://www.rucoyonline.com/highscores/${profession}"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val highScore = hightScoreMele(scrapper)
            logger.info("Melee: $highScore")
            return highScore
        }catch (e:Exception){
            logger.fatal("highScoresRucoyMelee fail to: ${e.stackTraceToString()}")
            return null
        }
    }
    fun highScoresRucoyDistance(profession:String): ArrayList<Distance>? {
        try {
            val url = "https://www.rucoyonline.com/highscores/${profession}"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val highScore = hightScoreDistance(scrapper)
            logger.info("Distances highScore: $highScore")
            return highScore
        } catch (e:Exception){
            logger.fatal("highScoresRucoyDistance fail to: ${e.stackTraceToString()}")
            return null
        }
    }
    fun highScoresRucoyMagic(profession:String): ArrayList<Magic>? {
        try {
            val url = "https://www.rucoyonline.com/highscores/${profession}"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val highScore = hightScoreMagic(scrapper)
            logger.info("ML highScore: $highScore")
            return highScore
        } catch (e:Exception){
            logger.fatal("highScoresRucoyMagic fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    fun highScoresRucoyDefense(profession:String): ArrayList<Defense>? {
        try {
            val url = "https://www.rucoyonline.com/highscores/${profession}"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val highScore = hightScoreDefense(scrapper)
            logger.info("Defense highScore: $highScore")
            return highScore
        } catch (e:Exception){
            logger.fatal("highScoresRucoyDefense fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    fun creatureProfile(creatureName:String): model.Creatures? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/${creatureName}"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val creatureData = Creatures().getGeneralDataCreature(scrapper)
            logger.info("Creature Profile: $creatureData")
            return creatureData
        } catch (e:Exception){
            logger.fatal("creatureProfile fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    fun swordsList(): ArrayList<ItemRucoyData>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Sword_List"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val swordList = SwordListRucoy().getSwordList(scrapper)
            logger.info("Sword List: $swordList")
            return swordList
        } catch (e:Exception){
            logger.fatal("swordsList fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    fun bowsList(): ArrayList<ItemRucoyData>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Bow_List"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val bows_list = BowsListRucoy().getBowList(scrapper)
            logger.info("Bows List: $bows_list")
            return bows_list
        } catch (e:Exception){
            logger.fatal("bowsList fail to: ${e.stackTraceToString()}")
            return null
        }
    }
    fun wandsList(): ArrayList<ItemRucoyData>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Wand_List"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val wands_list = WandsListRucoy().getWandsList(scrapper)
            logger.info("Wands List: $wands_list")
            return wands_list
        } catch (e:Exception){
            logger.fatal("wandsList fail to: ${e.stackTraceToString()}")
            return null
        }
    }
    fun itemProfile(name:String): ItemProfile? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/${name}"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val itemProfile = ItemsProfile().itemsProfile(scrapper)
            logger.info("Item Profile: $itemProfile")
            return itemProfile
        } catch (e:Exception){
            logger.fatal("itemProfile fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    fun getPotions(): ArrayList<Potion>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Potions_List"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val potions_list = PotionsRucoy().getItemPotionsRucoy(scrapper)
            logger.info("Potions list: $potions_list")
            return potions_list
        } catch (e:Exception){
            logger.fatal("getPotions fail to: ${e.stackTraceToString()}")
            return null
        }
    }
    fun getEquipment(): ArrayList<Category>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Equipment"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val equipment = Items().getItemsList(scrapper)
            logger.info("Equipments: $equipment")
            return equipment
        } catch (e:Exception){
            logger.fatal("getEquipment fail to: ${e.stackTraceToString()}")
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
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val armor_list = ArmorRucoyList().getArmorList(scrapper)
            logger.info("Armor List: $armor_list")
            return armor_list
        } catch (e:Exception){
            logger.fatal("getArmors fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    fun getBackPacks(): ArrayList<BackPack>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Backpack_List"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val backpacks = BackPackList().getBackPackList(scrapper)
            logger.info("Backpacks: $backpacks")
            return backpacks
        } catch (e:Exception){
            logger.fatal("getBackPacks fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    fun getBelts(): ArrayList<Belt>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Belts_List"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val belts = BeltsRucoyList().getBeltsRucoyList(scrapper)
            logger.info("Belts list: $belts")
            return belts
        } catch (e:Exception){
            logger.fatal("getBelts fail to: ${e.stackTraceToString()}")
            return null
        }
    }

        fun getBoots(): ArrayList<Boots>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Boots_List"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val boots = BootsRucoyList().getBootsRucoyList(scrapper)
            logger.info("Boots List: $boots")
            return boots
        } catch (e:Exception){
            logger.fatal("getBoots fail to: ${e.stackTraceToString()}")
            return null
        }
    }
    fun getHats(): ArrayList<Hat>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Hats_List"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val hats = HatsRucoyList().getHatsRucoyList(scrapper)
            logger.info("Hats List: $hats")
            return hats
        } catch (e:Exception){
            logger.fatal("getHats fail to: ${e.stackTraceToString()}")
            return null
        }
    }
    fun getHelmets(): ArrayList<Helmet>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Helmet_List"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val helmets = HelmetsRucoyList().getRucoyRucoyList(scrapper)
            logger.info("Helmets list: $helmets")
            return helmets
        } catch (e:Exception){
            logger.fatal("getHelmets fail to: ${e.stackTraceToString()}")
            return null
        }
    }
    fun getHoods(): ArrayList<Hood>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Hoods_List"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val hoods = HoodsRucoyList().getHoodsRucoyList(scrapper)
            logger.info("Hoods List: $hoods")
            return hoods
        } catch (e:Exception){
            logger.fatal("getHoods fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    fun getLegs(): ArrayList<Legs>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Legs_List"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val legs = LegsRucoyList().getLegsRucoyList(scrapper)
            logger.info("Legs list: $legs")
            return legs
        } catch (e:Exception){
            logger.fatal("getLegs fail to: ${e.stackTraceToString()}")
            return null
        }
    }
    fun getLightArmor(): ArrayList<LightArmor>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Light_Armor_List"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val lightArmor = LightArmorList().getLightArmorList(scrapper)
            logger.info("Light Armor List: $lightArmor")
            return lightArmor
        } catch (e:Exception){
            logger.fatal("getLightArmor fail to: ${e.stackTraceToString()}")
            return null
        }
    }
    fun getPendants(): ArrayList<Pendant>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Pendants_List"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val pendants = PendantsRucoyList().getPendantsList(scrapper)
            logger.info("Pendants List: $pendants")
            return pendants
        } catch (e:Exception){
            logger.fatal("getPendants fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    fun getRings(): ArrayList<Ring>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Rings_List"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val rings = RingsList().getRingsList(scrapper)
            logger.info("Rings List: $rings")
            return rings
        } catch (e:Exception){
            logger.fatal("getRings fail to: ${e.stackTraceToString()}")
            return null
        }
    }
    fun getRobes(): ArrayList<Robe>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Robes_List"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val robes = RobesRucoyList().getRobesRucoyList(scrapper)
            logger.info("Robes List: $robes")
            return robes
        } catch (e:Exception){
            logger.fatal("getRobes fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    fun getShields(): ArrayList<Shield>? {
        try {
            val url = "https://rucoy-online.fandom.com/wiki/Shield_List"
            logger.info("URL to scrap: $url")
            val scrapper = Scrapper().Soup(url)
            val shields = ShieldRucoyList().getShieldRucoyList(scrapper)
            logger.info("Shields List: $shields")
            return shields
        } catch (e:Exception){
            logger.fatal("getShields fail to: ${e.stackTraceToString()}")
            return null
        }
    }
}
