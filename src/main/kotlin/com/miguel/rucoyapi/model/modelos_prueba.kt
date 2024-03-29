package model

data class Mob(
    val name: String,
    val defense: Int,
    val health: Int
)

data class NormalTrain(val creaturename: String, val MIN_ATTACK: Int, val MAX_ATTACK: Int, val porcentage_damage: Int)

data class GuildsListModel(
    var guild_list: ArrayList<GuildContent>?,
    var pager: ArrayList<String>?
)
data class GuildContent(
    var name:String?,
    var description: String?,
    var members:String?
)