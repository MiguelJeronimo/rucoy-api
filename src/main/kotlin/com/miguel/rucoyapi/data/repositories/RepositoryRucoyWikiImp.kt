package com.miguel.rucoyapi.data.repositories

import com.miguel.rucoyapi.data.network.API.Rucoy
import model.*

class RepositoryRucoyWikiImp(private val rucoy: Rucoy): RepositoryRucoyWiki {
    override fun creature(name: String): Creatures? {
        return rucoy.creatureProfile(name)
    }

    override fun item(name: String): ItemProfile? {
        return rucoy.itemProfile(name)
    }

    override fun swords(): ArrayList<ItemRucoyData>? {
        return rucoy.swordsList()
    }

    override fun bows(): ArrayList<ItemRucoyData>? {
        return rucoy.bowsList()
    }

    override fun wands(): ArrayList<ItemRucoyData>? {
        return rucoy.wandsList()
    }

    override fun potions(): ArrayList<Potion>? {
        return rucoy.getPotions()
    }

    override fun equipments(): ArrayList<Category>? {
        return rucoy.getEquipment()
    }

    override fun armors(): ArrayList<Armor>? {
        return rucoy.getArmors()
    }

    override fun backpacks(): ArrayList<BackPack>? {
        return rucoy.getBackPacks()
    }

    override fun belts(): ArrayList<Belt>? {
        return rucoy.getBelts()
    }

    override fun boots(): ArrayList<Boots>? {
        return rucoy.getBoots()
    }

    override fun hats(): ArrayList<Hat>? {
        return rucoy.getHats()
    }

    override fun helmets(): ArrayList<Helmet>? {
        return rucoy.getHelmets()
    }

    override fun hoods(): ArrayList<Hood>? {
        return rucoy.getHoods()
    }

    override fun legs(): ArrayList<Legs>? {
        return rucoy.getLegs()
    }

    override fun lightArmor(): ArrayList<LightArmor>? {
        return rucoy.getLightArmor()
    }

    override fun pendants(): ArrayList<Pendant>? {
        return rucoy.getPendants()
    }

    override fun rings(): ArrayList<Ring>? {
        return rucoy.getRings()
    }

    override fun robes(): ArrayList<Robe>? {
        return rucoy.getRobes()
    }

    override fun shields(): ArrayList<Shield>? {
        return rucoy.getShields()
    }
}