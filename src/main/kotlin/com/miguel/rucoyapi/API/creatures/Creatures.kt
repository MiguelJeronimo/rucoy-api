package API.creatures

import model.Creatures
import model.ItemsCreatures
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class Creatures {
    fun getGeneralDataCreature(scrapper: Document): Creatures {
        val arrayItemsCreature = ArrayList<ItemsCreatures>()
        val creatureName = scrapper.select("h2[data-source]").text()
        val urlImgCreature = scrapper.getElementsByClass("image image-thumbnail").attr("href")
        val creatureAtributte = scrapper.getElementsByClass("pi-data-value pi-font")
        val tableLoot = scrapper.getElementsByClass("article-table")
        val lootList = tableLoot.select("tbody")
        var level = creatureAtributte[0].text()
        val hp = creatureAtributte[1].text()
        val exp = creatureAtributte[2].text()
        val spawn = creatureAtributte[3].text()
        val generalInformation = scrapper.select("p").text()
        for (loot in lootList){
            val center = loot.select("tr")
            for (data in center){
                searchDataRecursive(data,arrayItemsCreature)
            }
            arrayItemsCreature.removeFirst()
        }
        if (level == "none"){
            level = null.toString()
        }
        val creatureProfile = Creatures(creatureName,urlImgCreature,level, hp,exp,spawn,generalInformation, arrayItemsCreature)
        return creatureProfile
    }

    fun searchDataRecursive(element: Element, arrayListCreaturesData: ArrayList<ItemsCreatures>){
        val items = ItemsCreatures(null,null)
        val elementos = element.children()
        for (element in elementos){
            if (element.children().isNotEmpty()){
                if (element.tag().toString() == "td") {
                    val div = element.firstElementChild()
                    if (div?.tagName() == "div") {
                        val img = div.children().select("a").first()?.firstChild()
                        if (img?.attr("data-src") == ""){
                            items.url = img.attr("src")
                        } else{
                            items.url = img?.attr("data-src")
                        }
                    } else if (div?.tagName().toString() == "a"){
                        items.name = div!!.text()
                    }
                    else{
                        //guarda el texto del primero nodo que es el del dinero de la criatura
                        items.name = element.text()
                    }
                }
                else {
                    searchDataRecursive(element,arrayListCreaturesData)
                }
            }
        }
        arrayListCreaturesData.add(items)
    }
}