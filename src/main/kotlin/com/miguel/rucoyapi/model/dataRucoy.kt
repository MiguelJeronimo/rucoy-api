package model

import kotlin.collections.ArrayList

data class HighScore(val rank:String,val name:String,val status:String,val level:String,val experience:String)
data class Mele(val rank:String,val name:String,val status:String, val mele:String)
data class Distance(val rank:String,val name:String,val status:String, val distance:String)
data class Magic(val rank:String,val name:String,val status:String, val magic:String)
data class Defense(val rank:String,val name:String,val status:String, val defense:String)
data class Guild(val name: String, val description:String, val founded_on:String, val member: ArrayList<Members>)
data class Members(val name:String,val supporter:String, val level: String,val join_date:String)
//data class Characters(val Character: CharactersDataGeneral)
data class CharactersDataGeneral(
    var name: String?,
    var level: String?,
    var guild: String?,
    var title: String?,
    var lastOnline: String?,
    var born: String?,
    var death: ArrayList<String>?
)
data class newsRucoy(var newData: ArrayList<new_data>)
data class new_data(var date:String?, var title:String?, var subtittle:String?, var content: content?)
data class content(var content_array: ArrayList<String>)
data class error(var error: String?)
//creature profile template
data class Creatures(
    val name: String,
    val url_img:String,
    val level: String?,
    val hitpoints: String,
    val experience: String,
    val spawn: String,
    val genera_information: String,
    val items: ArrayList<ItemsCreatures>
)
data class ItemsCreatures(var name: String?, var url: String?)
data class ItemsRucoyData(val itemsRucoy: ArrayList<ItemRucoyData>)
data class ItemRucoyData(
    val name:String,
    val img: String,
    val damage: MutableList<String>,
    val buy_npc: MutableList<String>,
    val drop_by: MutableList<String>,
    val sell_npc: MutableList<String>
)
data class ItemProfile(
    val description_general: String,
    val image: String,
    val type: String,
    val level: String,
    val effect: String,
    val source: String,
    val cost_to_buy: String,
    val gold_for_sell: String
)