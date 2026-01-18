package com.miguel.rucoyapi.domain.usecases

import com.miguel.rucoyapi.data.repositories.RepositoryRucoyWiki
import com.miguel.rucoyapi.data.repositories.RepositoryWikiInfo
import com.miguel.rucoyapi.utils.utils
import model.*
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
@Service
class UseCaseRucoyWiki {
    @Autowired
    private lateinit var repository: RepositoryRucoyWiki
    @Autowired
    private lateinit var repositoryWiki: RepositoryWikiInfo
    //leyendo archivos de la carpeta resources del proyecto spingboot
    private val file = javaClass.getResourceAsStream("/databloqueada.txt")
    private val validFile = javaClass.getResourceAsStream("/datacorrecta.txt")
    private val logger = LogManager.getLogger(UseCaseRucoyWiki::class.java)
    //println("Ruta del archivo: "+System.getProperty("user.dir"))
    private val bloquedData = utils().readDocumenttxt(file)
    private val validData = utils().readDocumenttxt(validFile)

    suspend fun item(name: String): ItemProfile? {
        val data = utils().searchdataArray(bloquedData, validData, name)
        return repository.item(data)
    }

    suspend fun armors(): ArrayList<Armor>? {
        val response = repositoryWiki.infoWikiCreatures("Armor_List")
        val html = response.parse?.text?.content.toString()
        return repository.armors(html)
    }

    suspend fun backpacks(): ArrayList<BackPack>? {
        val response = repositoryWiki.infoWikiCreatures("Backpack_List")
        val html = response.parse?.text?.content.toString()
        return repository.backpacks(
            response = html
        )
    }

    suspend fun belts(): ArrayList<Belt>? {
        val response = repositoryWiki.infoWikiCreatures("Belts_List")
        val html = response.parse?.text?.content.toString()
        return repository.belts(response = html)
    }

    suspend fun boots(): ArrayList<Boots>? {
        val response = repositoryWiki.infoWikiCreatures("Boots_List")
        val html = response.parse?.text?.content.toString()
        return repository.boots(response = html)
    }

    suspend fun bows(): ArrayList<ItemRucoyData>? {
        val response = repositoryWiki.infoWikiCreatures("Bow_List")
        val html = response.parse?.text?.content.toString()
        return repository.bows(response = html)
    }

    suspend fun creature(name: String): Creatures? {
        val response = repositoryWiki.infoWikiCreatures(name)
       // logger.info("Response: $response")
        val html = response.parse?.text?.content.toString()
        return repository.creature(name, html)
    }

    suspend fun equipment(): ArrayList<Category>? {
        val response = repositoryWiki.infoWikiCreatures("equipment")
        val html = response.parse?.text?.content.toString()
        return repository.equipments(response = html)
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