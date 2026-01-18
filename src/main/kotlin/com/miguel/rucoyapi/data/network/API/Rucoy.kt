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
import com.miguel.rucoyapi.utils.execeptions.CustomError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import model.*
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.stereotype.Service

@Service
class Rucoy : AbstractRucoy() {
    private val logger: Logger = LogManager.getLogger(Rucoy::class.java)
    suspend fun SearchGuilds(guildName: String): Guild? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://www.rucoyonline.com/guild/${guildName}"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val guilds = GuildsData().dataGuild(scrapper)
                logger.info("GuildData: $guilds")
                guilds
            }
        } catch (e: Exception) {
            logger.fatal("SearchGuild fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun guildsList(pager: String): GuildsListModel? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://www.rucoyonline.com/guilds?page=$pager"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val guilds = com.miguel.rucoyapi.data.network.API.guildss.Guilds().getGuildsList(scrapper)
                logger.info("Guilds: $guilds")
                guilds
            }
        } catch (e: Exception) {
            logger.fatal("GuildsList fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun NewsRucoy(): newsRucoy? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://www.rucoyonline.com/news"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val news = New().NewsRucoy(scrapper)
                logger.info("News: $news")
                return@withContext news
            }
        } catch (e: Exception) {
            logger.fatal("NewsRucoy fail to: ${e.stackTraceToString()}")
            return null
        }

    }

    suspend fun SearchCharacter(characterName: String): CharactersDataGeneral? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://www.rucoyonline.com/characters/${characterName}"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val character = CharactersRucoy().searchCharacter(scrapper)
                logger.info("Character info: $character")
                return@withContext character
            }
        } catch (e: Exception) {
            logger.fatal("SearchCharacter fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    //higscores
    suspend fun highScoresRucoyExperience(profession: String): ArrayList<HighScore>? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://www.rucoyonline.com/highscores/${profession}"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val highScore = HighScoreExperiencia(scrapper)
                logger.info("Experience: $highScore")
                return@withContext highScore
            }
        } catch (e: Exception) {
            logger.fatal("highScoresRucoyExperience fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun highScoresRucoyMelee(profession: String): ArrayList<Mele>? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://www.rucoyonline.com/highscores/${profession}"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val highScore = hightScoreMele(scrapper)
                logger.info("Melee: $highScore")
                return@withContext highScore
            }
        } catch (e: Exception) {
            logger.fatal("highScoresRucoyMelee fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun highScoresRucoyDistance(profession: String): ArrayList<Distance>? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://www.rucoyonline.com/highscores/${profession}"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val highScore = hightScoreDistance(scrapper)
                logger.info("Distances highScore: $highScore")
                return@withContext highScore
            }
        } catch (e: Exception) {
            logger.fatal("highScoresRucoyDistance fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun highScoresRucoyMagic(profession: String): ArrayList<Magic>? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://www.rucoyonline.com/highscores/${profession}"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val highScore = hightScoreMagic(scrapper)
                logger.info("ML highScore: $highScore")
                return@withContext highScore
            }
        } catch (e: Exception) {
            logger.fatal("highScoresRucoyMagic fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun highScoresRucoyDefense(profession: String): ArrayList<Defense>? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://www.rucoyonline.com/highscores/${profession}"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val highScore = hightScoreDefense(scrapper)
                logger.info("Defense highScore: $highScore")
                return@withContext highScore
            }
        } catch (e: Exception) {
            logger.fatal("highScoresRucoyDefense fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun creatureProfile(creatureName: String, response: String): model.Creatures? {
        try {
            return withContext(Dispatchers.IO) {
                //logger.info("html: $response")
                val scrapper = Scrapper().htmlConverter(response)
                if (scrapper === null) throw CustomError("Error reading html...")
                val creatureData = Creatures().getGeneralDataCreature(scrapper)
                logger.info("Creature Profile: $creatureData")
                return@withContext creatureData
            }
        } catch (e: Exception) {
            logger.fatal("creatureProfile fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun swordsList(): ArrayList<ItemRucoyData>? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://rucoy-online.fandom.com/wiki/Sword_List"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val swordList = SwordListRucoy().getSwordList(scrapper)
                logger.info("Sword List: $swordList")
                return@withContext swordList
            }
        } catch (e: Exception) {
            logger.fatal("swordsList fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun bowsList(response: String): ArrayList<ItemRucoyData>? {
        try {
            return withContext(Dispatchers.IO) {
                val scrapper = Scrapper().htmlConverter(response)
                if (scrapper === null) throw CustomError("Error reading html...")
                val bows_list = BowsListRucoy().getBowList(scrapper)
                logger.info("Bows List: $bows_list")
                return@withContext bows_list
            }
        } catch (e: Exception) {
            logger.fatal("bowsList fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun wandsList(): ArrayList<ItemRucoyData>? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://rucoy-online.fandom.com/wiki/Wand_List"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val wands_list = WandsListRucoy().getWandsList(scrapper)
                logger.info("Wands List: $wands_list")
                return@withContext wands_list
            }
        } catch (e: Exception) {
            logger.fatal("wandsList fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun itemProfile(name: String): ItemProfile? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://rucoy-online.fandom.com/wiki/${name}"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val itemProfile = ItemsProfile().itemsProfile(scrapper)
                logger.info("Item Profile: $itemProfile")
                return@withContext itemProfile
            }
        } catch (e: Exception) {
            logger.fatal("itemProfile fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun getPotions(): ArrayList<Potion>? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://rucoy-online.fandom.com/wiki/Potions_List"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val potions_list = PotionsRucoy().getItemPotionsRucoy(scrapper)
                logger.info("Potions list: $potions_list")
                return@withContext potions_list
            }
        } catch (e: Exception) {
            logger.fatal("getPotions fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun getEquipment(response:String): ArrayList<Category>? {
        try {
            return withContext(Dispatchers.IO) {
                val scrapper = Scrapper().htmlConverter(response)
                if (scrapper === null) throw CustomError("Error reading html...")
                val equipment = Items().getItemsList(scrapper)
                logger.info("Equipments: $equipment")
                return@withContext equipment
            }
        } catch (e: Exception) {
            logger.fatal("getEquipment fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun getArmors(response:String): ArrayList<Armor>? {
        try {
            return withContext(Dispatchers.IO) {
                val scrapper = Scrapper().htmlConverter(response) ?: throw CustomError("Error reading html...")
                val armorList = ArmorRucoyList().getArmorList(scrapper)
                logger.info("Armor List: $armorList")
                return@withContext armorList
            }
        } catch (e: Exception) {
            logger.fatal("getArmors fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun getBackPacks(response:String): ArrayList<BackPack>? {
        try {
            return withContext(Dispatchers.IO) {
                val scrapper = Scrapper().htmlConverter(response) ?: throw CustomError("Error reading html...")
                val backpacks = BackPackList().getBackPackList(scrapper)
                logger.info("Backpacks: $backpacks")
                return@withContext backpacks
            }
        } catch (e: Exception) {
            logger.fatal("getBackPacks fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun getBelts(response: String): ArrayList<Belt>? {
        try {
            return withContext(Dispatchers.IO) {
                val scrapper = Scrapper().htmlConverter(response) ?: throw CustomError("Error reading html...")
                val belts = BeltsRucoyList().getBeltsRucoyList(scrapper)
                logger.info("Belts list: $belts")
                return@withContext belts
            }
        } catch (e: Exception) {
            logger.fatal("getBelts fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun getBoots(response:String): ArrayList<Boots>? {
        try {
            return withContext(Dispatchers.IO) {
                val scrapper = Scrapper().htmlConverter(response) ?: throw CustomError("Error reading html...")
                val boots = BootsRucoyList().getBootsRucoyList(scrapper)
                logger.info("Boots List: $boots")
                return@withContext boots
            }
        } catch (e: Exception) {
            logger.fatal("getBoots fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun getHats(response: String): ArrayList<Hat>? {
        try {
            return withContext(Dispatchers.IO) {
                val scrapper = Scrapper().htmlConverter(response) ?: throw CustomError("Error reading html...")
                val hats = HatsRucoyList().getHatsRucoyList(scrapper)
                logger.info("Hats List: $hats")
                return@withContext hats
            }
        } catch (e: Exception) {
            logger.fatal("getHats fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun getHelmets(response: String): ArrayList<Helmet>? {
        try {
            return withContext(Dispatchers.IO) {
                val scrapper = Scrapper().htmlConverter(response) ?: throw CustomError("Error reading html...")
                val helmets = HelmetsRucoyList().getRucoyRucoyList(scrapper)
                logger.info("Helmets list: $helmets")
                return@withContext helmets
            }
        } catch (e: Exception) {
            logger.fatal("getHelmets fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun getHoods(response:String): ArrayList<Hood>? {
        try {
            return withContext(Dispatchers.IO) {
                val scrapper = Scrapper().htmlConverter(response)?: throw CustomError("Error reading html...")
                val hoods = HoodsRucoyList().getHoodsRucoyList(scrapper)
                logger.info("Hoods List: $hoods")
                return@withContext hoods
            }
        } catch (e: Exception) {
            logger.fatal("getHoods fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun getLegs(response:String): ArrayList<Legs>? {
        try {
            return withContext(Dispatchers.IO) {
                val scrapper = Scrapper().htmlConverter(response)?: throw CustomError("Error reading html...")
                val legs = LegsRucoyList().getLegsRucoyList(scrapper)
                logger.info("Legs list: $legs")
                return@withContext legs
            }
        } catch (e: Exception) {
            logger.fatal("getLegs fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun getLightArmor(): ArrayList<LightArmor>? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://rucoy-online.fandom.com/wiki/Light_Armor_List"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val lightArmor = LightArmorList().getLightArmorList(scrapper)
                logger.info("Light Armor List: $lightArmor")
                return@withContext lightArmor
            }
        } catch (e: Exception) {
            logger.fatal("getLightArmor fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun getPendants(): ArrayList<Pendant>? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://rucoy-online.fandom.com/wiki/Pendants_List"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val pendants = PendantsRucoyList().getPendantsList(scrapper)
                logger.info("Pendants List: $pendants")
                return@withContext pendants
            }
        } catch (e: Exception) {
            logger.fatal("getPendants fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun getRings(): ArrayList<Ring>? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://rucoy-online.fandom.com/wiki/Rings_List"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val rings = RingsList().getRingsList(scrapper)
                logger.info("Rings List: $rings")
                return@withContext rings
            }
        } catch (e: Exception) {
            logger.fatal("getRings fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun getRobes(): ArrayList<Robe>? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://rucoy-online.fandom.com/wiki/Robes_List"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val robes = RobesRucoyList().getRobesRucoyList(scrapper)
                logger.info("Robes List: $robes")
                return@withContext robes
            }
        } catch (e: Exception) {
            logger.fatal("getRobes fail to: ${e.stackTraceToString()}")
            return null
        }
    }

    suspend fun getShields(): ArrayList<Shield>? {
        try {
            return withContext(Dispatchers.IO) {
                val url = "https://rucoy-online.fandom.com/wiki/Shield_List"
                logger.info("URL to scrap: $url")
                val scrapper = Scrapper().Soup(url)
                val shields = ShieldRucoyList().getShieldRucoyList(scrapper)
                logger.info("Shields List: $shields")
                return@withContext shields
            }
        } catch (e: Exception) {
            logger.fatal("getShields fail to: ${e.stackTraceToString()}")
            return null
        }
    }
}
