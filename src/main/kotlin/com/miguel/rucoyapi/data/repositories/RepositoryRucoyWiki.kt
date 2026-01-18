package com.miguel.rucoyapi.data.repositories

import model.*


interface RepositoryRucoyWiki {
    suspend fun creature(name: String, response: String): Creatures?
    suspend fun item(name:String): ItemProfile?
    suspend fun swords(): ArrayList<ItemRucoyData>?
    suspend fun bows(response:String): ArrayList<ItemRucoyData>?
    suspend fun wands(): ArrayList<ItemRucoyData>?
    suspend fun potions(): ArrayList<Potion>?
    suspend fun equipments(response:String): ArrayList<Category>?
    suspend fun armors(response:String): ArrayList<Armor>?
    suspend fun backpacks(response:String): ArrayList<BackPack>?
    suspend fun belts(response: String): ArrayList<Belt>?
    suspend fun boots(response:String): ArrayList<Boots>?
    suspend fun hats(response:String): ArrayList<Hat>?
    suspend fun helmets(): ArrayList<Helmet>?
    suspend fun hoods(): ArrayList<Hood>?
    suspend fun legs(): ArrayList<Legs>?
    suspend fun lightArmor(): ArrayList<LightArmor>?
    suspend fun pendants(): ArrayList<Pendant>?
    suspend fun rings(): ArrayList<Ring>?
    suspend fun robes(): ArrayList<Robe>?
    suspend fun shields(): ArrayList<Shield>?
}