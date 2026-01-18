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

    override suspend fun bows(): ArrayList<ItemRucoyData>? {
        return rucoy.bowsList()
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

    override suspend fun armors(): ArrayList<Armor>? {
        return rucoy.getArmors()
    }

    override suspend fun backpacks(): ArrayList<BackPack>? {
        return rucoy.getBackPacks()
    }

    override suspend fun belts(): ArrayList<Belt>? {
        return rucoy.getBelts()
    }

    override suspend fun boots(): ArrayList<Boots>? {
        return rucoy.getBoots()
    }

    override suspend fun hats(): ArrayList<Hat>? {
        return rucoy.getHats()
    }

    override suspend fun helmets(): ArrayList<Helmet>? {
        return rucoy.getHelmets()
    }

    override suspend fun hoods(): ArrayList<Hood>? {
        return rucoy.getHoods()
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