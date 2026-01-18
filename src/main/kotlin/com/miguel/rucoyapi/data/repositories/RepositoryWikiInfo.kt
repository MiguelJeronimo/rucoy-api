package com.miguel.rucoyapi.data.repositories

import com.miguel.rucoyapi.domain.model.WikiModels

interface RepositoryWikiInfo {
    suspend fun infoWikiCreatures(name:String): WikiModels
}