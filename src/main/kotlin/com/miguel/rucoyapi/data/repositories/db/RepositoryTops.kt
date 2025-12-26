package com.miguel.rucoyapi.data.repositories.db



import com.miguel.rucoyapi.data.entities.Turso
import org.springframework.stereotype.Repository

@Repository
interface RepositoryTops{
    suspend fun experience(page: Int, size: Int, id:String, idSnapshot:String): Turso?
    suspend fun melee(page: Int, size: Int, id:String, idSnapshot:String): Turso?
    suspend fun distance(page: Int, size: Int, id:String, idSnapshot:String): Turso?
    suspend fun magic(page: Int, size: Int, id:String, idSnapshot:String): Turso?
    suspend fun defense(page: Int, size: Int, id:String, idSnapshot:String): Turso?
}