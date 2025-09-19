package com.miguel.rucoyapi.data.repositories.db

import com.miguel.rucoyapi.data.entities.Turso
import org.springframework.stereotype.Repository

@Repository
interface RepositoryTopStats {
    suspend fun getStatsByName(name:String, idCategory:String): Turso?
}