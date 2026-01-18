package com.miguel.rucoyapi.data.repositories

import model.*


interface RepositoryRucoyWiki {
    suspend fun creature(name: String, response: String): Creatures?
    suspend fun item(name:String): ItemProfile?
    suspend fun swords(response:String): ArrayList<ItemRucoyData>?
    suspend fun bows(response:String): ArrayList<ItemRucoyData>?
    suspend fun wands(response:String): ArrayList<ItemRucoyData>?
    suspend fun potions(response:String): ArrayList<Potion>?
    suspend fun equipments(response:String): ArrayList<Category>?
    suspend fun armors(response:String): ArrayList<Armor>?
    suspend fun backpacks(response:String): ArrayList<BackPack>?
    suspend fun belts(response: String): ArrayList<Belt>?
    suspend fun boots(response:String): ArrayList<Boots>?
    suspend fun hats(response:String): ArrayList<Hat>?
    suspend fun helmets(response:String): ArrayList<Helmet>?
    suspend fun hoods(response:String): ArrayList<Hood>?
    suspend fun legs(response:String): ArrayList<Legs>?
    suspend fun lightArmor(response:String): ArrayList<LightArmor>?
    suspend fun pendants(response:String): ArrayList<Pendant>?
    suspend fun rings(response:String): ArrayList<Ring>?
    suspend fun robes(response:String): ArrayList<Robe>?
    suspend fun shields(response:String): ArrayList<Shield>?
}