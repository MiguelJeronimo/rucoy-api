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
        val response = repositoryWiki.infoWikiCreatures(data)
        val html = response.parse?.text?.content.toString()
        return repository.item(html)
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
        val response = repositoryWiki.infoWikiCreatures("Hats_List")
        val html = response.parse?.text?.content.toString()
        return repository.hats(response = html)
    }

    suspend fun helmets(): ArrayList<Helmet>? {
        val response = repositoryWiki.infoWikiCreatures("Helmet_List")
        val html = response.parse?.text?.content.toString()
        return repository.helmets(response = html)
    }

    suspend fun hoods(): ArrayList<Hood>? {
        val response = repositoryWiki.infoWikiCreatures("Hoods_List")
        val html = response.parse?.text?.content.toString()
        return repository.hoods(response = html)
    }

    suspend fun legs(): ArrayList<Legs>? {
        val response = repositoryWiki.infoWikiCreatures("Legs_List")
        val html = response.parse?.text?.content.toString()
        return repository.legs(response = html)
    }

    suspend fun lightArmor(): ArrayList<LightArmor>? {
        val response = repositoryWiki.infoWikiCreatures("Light_Armor_List")
        val html = response.parse?.text?.content.toString()
        return repository.lightArmor(response = html)
    }

    suspend fun pendants(): ArrayList<Pendant>? {
        val response = repositoryWiki.infoWikiCreatures("Pendants_List")
        val html = response.parse?.text?.content.toString()
        return repository.pendants(response = html)
    }

    suspend fun rings(): ArrayList<Ring>? {
        val response = repositoryWiki.infoWikiCreatures("Rings_List")
        val html = response.parse?.text?.content.toString()
        return repository.rings(response = html)
    }

    suspend fun robes(): ArrayList<Robe>? {
        val response = repositoryWiki.infoWikiCreatures("Robes_List")
        val html = response.parse?.text?.content.toString()
        return repository.robes(response = html)
    }

    suspend fun shields(): ArrayList<Shield>? {
        val response = repositoryWiki.infoWikiCreatures("Shield_List")
        val html = response.parse?.text?.content.toString()
        return repository.shields(response = html)
    }

    suspend fun potions(): ArrayList<Potion>? {
        val response = repositoryWiki.infoWikiCreatures("Potions_List")
        val html = response.parse?.text?.content.toString()
        return repository.potions(response = html)
    }

    suspend fun swords(): ArrayList<ItemRucoyData>? {
        val response = repositoryWiki.infoWikiCreatures("Sword_List")
        val html = response.parse?.text?.content.toString()
        return repository.swords(response = html)
    }

    suspend fun wands(): ArrayList<ItemRucoyData>? {
        val response = repositoryWiki.infoWikiCreatures("Wand_List")
        val html = response.parse?.text?.content.toString()
        return repository.wands(response = html)
    }
}