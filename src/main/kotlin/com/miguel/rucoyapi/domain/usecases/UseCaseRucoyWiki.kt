package com.miguel.rucoyapi.domain.usecases

import com.miguel.rucoyapi.data.repositories.RepositoryRucoyWiki
import com.miguel.rucoyapi.utils.utils
import model.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class UseCaseRucoyWiki(private val repository: RepositoryRucoyWiki) {
    //leyendo archivos de la carpeta resources del proyecto spingboot
    private val file = javaClass.getResourceAsStream("/databloqueada.txt")
    private val validFile = javaClass.getResourceAsStream("/datacorrecta.txt")

    //println("Ruta del archivo: "+System.getProperty("user.dir"))
    private val bloquedData = utils().readDocumenttxt(file)
    private val validData = utils().readDocumenttxt(validFile)

    suspend fun item(name: String): ItemProfile? {
        val data = utils().searchdataArray(bloquedData, validData, name)
        return repository.item(data)
    }

    suspend fun armors(): ArrayList<Armor>? {
        return repository.armors()
    }

    suspend fun backpacks(): ArrayList<BackPack>? {
        return repository.backpacks()
    }

    suspend fun belts(): ArrayList<Belt>? {
        return repository.belts()
    }

    suspend fun boots(): ArrayList<Boots>? {
        return repository.boots()
    }

    suspend fun bows(): ArrayList<ItemRucoyData>? {
        return repository.bows()
    }

    suspend fun creature(name: String): Creatures? {
        return repository.creature(name)
    }

    suspend fun equipment(): ArrayList<Category>? {
        return repository.equipments()
    }

    suspend fun hats(): ArrayList<Hat>? {
        return repository.hats()
    }

    suspend fun helmets(): ArrayList<Helmet>? {
        return repository.helmets()
    }

    suspend fun hoods(): ArrayList<Hood>? {
        return repository.hoods()
    }

    suspend fun legs(): ArrayList<Legs>? {
        return repository.legs()
    }

    suspend fun lightArmor(): ArrayList<LightArmor>? {
        return repository.lightArmor()
    }

    suspend fun pendants(): ArrayList<Pendant>? {
        return repository.pendants()
    }

    suspend fun rings(): ArrayList<Ring>? {
        return repository.rings()
    }

    suspend fun robes(): ArrayList<Robe>? {
        return repository.robes()
    }

    suspend fun shields(): ArrayList<Shield>? {
        return repository.shields()
    }

    suspend fun potions(): ArrayList<Potion>? {
        return repository.potions()
    }

    suspend fun swords(): ArrayList<ItemRucoyData>? {
        return repository.swords()
    }

    suspend fun wands(): ArrayList<ItemRucoyData>? {
        return repository.wands()
    }


}