package com.miguel.rucoyapi.data.repositories.db

import com.miguel.rucoyapi.data.entities.Turso
import org.springframework.stereotype.Repository

@Repository
interface RepositoryDate {
    suspend fun getCurrentDate(): Turso?
}