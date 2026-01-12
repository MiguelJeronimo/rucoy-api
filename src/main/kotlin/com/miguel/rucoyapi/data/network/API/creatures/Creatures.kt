package API.creatures

import model.Creatures
import model.ItemsCreatures
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class Creatures {
    fun getGeneralDataCreature(scrapper: Document): Creatures {
        val creatureName = scrapper.select("h2[data-source]").text()
        var urlImgCreature: String = ""
        var tableLoot: Elements = Elements()
        var creatureAttribute: Elements = Elements()
        var level: String = ""
        var experience: String = ""
        var hp: String = ""
        var spawn:String = ""
        var generalInformation:String = ""
        if (!creatureName.isNullOrEmpty()){
            urlImgCreature = scrapper.getElementsByClass("image image-thumbnail").attr("href")
            creatureAttribute = scrapper.getElementsByClass("pi-data-value pi-font")
            hp = creatureAttribute[1].text()
            experience = creatureAttribute[2].text()
            spawn = creatureAttribute[3].text()
            generalInformation = scrapper.select("p").text()
            level = creatureAttribute[0].text()
        }
        tableLoot = scrapper.getElementsByClass("article-table")
        val lootList = tableLoot.select("tbody")
        val trs = lootList.select("tr")
        val loot = trs.map {
            val url = it.getElementsByClass("thumb mw-halign-center ")
                .select("img")
                .attr("data-src")
            ItemsCreatures(
                name = it.text(),
                url = url,
            )
        } as MutableList<ItemsCreatures>
        if (level == "none"){
            level = null.toString()
        }
        loot.removeIf { it.url == "" }
        val creatureProfile = Creatures(creatureName, urlImgCreature, level, hp, experience, spawn, generalInformation, loot)
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
                        print("IMAGENES: "+img)
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