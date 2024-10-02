package com.miguel.rucoyapi.domain.usecases

import com.miguel.rucoyapi.data.repositories.RepositoryRucoyWiki
import com.miguel.rucoyapi.utils.utils
import model.*

class UseCaseRucoyWiki(private val repository: RepositoryRucoyWiki) {
    fun item(name:String): ItemProfile? {
        //leyendo archivos de la carpeta resources del proyecto spingboot
        val file = javaClass.getResourceAsStream("/databloqueada.txt")
        val validFile = javaClass.getResourceAsStream("/datacorrecta.txt")
        //println("Ruta del archivo: "+System.getProperty("user.dir"))
        val bloquedData = utils().readDocumenttxt(file)
        val validData = utils().readDocumenttxt(validFile)
        val data = utils().searchdataArray(bloquedData, validData, name)
        return repository.item(data)
    }

    fun armors(): ArrayList<Armor>? {
        return repository.armors()
    }
    fun backpacks(): ArrayList<BackPack>? {
        return repository.backpacks()
    }
    fun belts(): ArrayList<Belt>? {
        return repository.belts()
    }
    fun boots(): ArrayList<Boots>? {
        return repository.boots()
    }

    fun bows(): ArrayList<ItemRucoyData>? {
        return repository.bows()
    }

    fun creature(name:String): Creatures? {
        return repository.creature(name)
    }

    fun equipment(): ArrayList<Category>? {
        return repository.equipments()
    }

    fun hats(): ArrayList<Hat>? {
        return repository.hats()
    }

    fun helmets(): ArrayList<Helmet>? {
        return repository.helmets()
    }

    fun hoods(): ArrayList<Hood>? {
        return repository.hoods()
    }

    fun legs(): ArrayList<Legs>?{
        return repository.legs()
    }
    fun lightArmor(): ArrayList<LightArmor>?{
        return repository.lightArmor()
    }
    fun pendants(): ArrayList<Pendant>?{
        return repository.pendants()
    }
    fun rings(): ArrayList<Ring>?{
        return repository.rings()
    }
    fun robes(): ArrayList<Robe>?{
        return repository.robes()
    }
    fun shields(): ArrayList<Shield>?{
        return repository.shields()
    }

    fun potions(): ArrayList<Potion>? {
        return repository.potions()
    }

    fun swords(): ArrayList<ItemRucoyData>? {
        return repository.swords()
    }

    fun wands(): ArrayList<ItemRucoyData>? {
        return repository.wands()
    }


}