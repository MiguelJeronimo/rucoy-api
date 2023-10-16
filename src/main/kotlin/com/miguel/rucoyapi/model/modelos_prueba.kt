package model

data class Mob(
    val name: String,
    val defense: Int,
    val health: Int
)

data class NormalTrain(val creaturename: String, val MIN_ATTACK: Int, val MAX_ATTACK: Int, val porcentage_damage: Int)