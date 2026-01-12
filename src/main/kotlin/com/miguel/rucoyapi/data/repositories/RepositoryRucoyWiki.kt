package com.miguel.rucoyapi.data.repositories

import model.*


interface RepositoryRucoyWiki {
    suspend fun creature(name: String, response: String): Creatures?
    suspend fun item(name:String): ItemProfile?
    suspend fun swords(): ArrayList<ItemRucoyData>?
    suspend fun bows(): ArrayList<ItemRucoyData>?
    suspend fun wands(): ArrayList<ItemRucoyData>?
    suspend fun potions(): ArrayList<Potion>?
    suspend fun equipments(): ArrayList<Category>?
    suspend fun armors(): ArrayList<Armor>?
    suspend fun backpacks(): ArrayList<BackPack>?
    suspend fun belts(): ArrayList<Belt>?
    suspend fun boots(): ArrayList<Boots>?
    suspend fun hats(): ArrayList<Hat>?
    suspend fun helmets(): ArrayList<Helmet>?
    suspend fun hoods(): ArrayList<Hood>?
    suspend fun legs(): ArrayList<Legs>?
    suspend fun lightArmor(): ArrayList<LightArmor>?
    suspend fun pendants(): ArrayList<Pendant>?
    suspend fun rings(): ArrayList<Ring>?
    suspend fun robes(): ArrayList<Robe>?
    suspend fun shields(): ArrayList<Shield>?
}