package com.miguel.rucoyapi.data.repositories

import com.miguel.rucoyapi.data.network.API.Rucoy
import model.*
import org.springframework.stereotype.Repository

@Repository
class RepositoryRucoyWikiImp(private val rucoy: Rucoy): RepositoryRucoyWiki {
    override suspend fun creature(name: String, response: String): Creatures? {
        return rucoy.creatureProfile(name, response)
    }

    override suspend fun item(name: String): ItemProfile? {
        return rucoy.itemProfile(name)
    }

    override suspend fun swords(): ArrayList<ItemRucoyData>? {
        return rucoy.swordsList()
    }

    override suspend fun bows(response: String): ArrayList<ItemRucoyData>? {
        return rucoy.bowsList(response)
    }

    override suspend fun wands(): ArrayList<ItemRucoyData>? {
        return rucoy.wandsList()
    }

    override suspend fun potions(): ArrayList<Potion>? {
        return rucoy.getPotions()
    }

    override suspend fun equipments(response:String): ArrayList<Category>? {
        return rucoy.getEquipment(response = response)
    }

    override suspend fun armors(response:String): ArrayList<Armor>? {
        return rucoy.getArmors(response = response)
    }

    override suspend fun backpacks(response:String): ArrayList<BackPack>? {
        return rucoy.getBackPacks(response = response)
    }

    override suspend fun belts(response:String): ArrayList<Belt>? {
        return rucoy.getBelts(response = response)
    }

    override suspend fun boots(response: String): ArrayList<Boots>? {
        return rucoy.getBoots(response = response)
    }

    override suspend fun hats(response: String): ArrayList<Hat>? {
        return rucoy.getHats(response = response)
    }

    override suspend fun helmets(response:String): ArrayList<Helmet>? {
        return rucoy.getHelmets(response = response)
    }

    override suspend fun hoods(response:String): ArrayList<Hood>? {
        return rucoy.getHoods(response = response)
    }

    override suspend fun legs(): ArrayList<Legs>? {
        return rucoy.getLegs()
    }

    override suspend fun lightArmor(): ArrayList<LightArmor>? {
        return rucoy.getLightArmor()
    }

    override suspend fun pendants(): ArrayList<Pendant>? {
        return rucoy.getPendants()
    }

    override suspend fun rings(): ArrayList<Ring>? {
        return rucoy.getRings()
    }

    override suspend fun robes(): ArrayList<Robe>? {
        return rucoy.getRobes()
    }

    override suspend fun shields(): ArrayList<Shield>? {
        return rucoy.getShields()
    }
}