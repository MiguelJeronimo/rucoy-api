package com.miguel.rucoyapi.data.repositories

import model.*

interface RepositoryRucoyWiki {
    fun creature(name:String): Creatures?
    fun item(name:String): ItemProfile?
    fun swords(): ArrayList<ItemRucoyData>?
    fun bows(): ArrayList<ItemRucoyData>?
    fun wands(): ArrayList<ItemRucoyData>?
    fun potions(): ArrayList<Potion>?
    fun equipments(): ArrayList<Category>?
    fun armors(): ArrayList<Armor>?
    fun backpacks(): ArrayList<BackPack>?
    fun belts(): ArrayList<Belt>?
    fun boots(): ArrayList<Boots>?
    fun hats(): ArrayList<Hat>?
    fun helmets(): ArrayList<Helmet>?
    fun hoods(): ArrayList<Hood>?
    fun legs(): ArrayList<Legs>?
    fun lightArmor(): ArrayList<LightArmor>?
    fun pendants(): ArrayList<Pendant>?
    fun rings(): ArrayList<Ring>?
    fun robes(): ArrayList<Robe>?
    fun shields(): ArrayList<Shield>?
}