package API.Items.ItemsProfile

import model.ItemProfile
import org.jsoup.nodes.Document

class ItemsProfile {

    fun itemsProfile(scrapper: Document): ItemProfile {
        val aside_items_profile = scrapper.getElementsByClass("portable-infobox pi-background pi-border-color pi-theme-wikia pi-layout-default")
        val imgItem = aside_items_profile.select("img").attr("src")
        val itemType = aside_items_profile.select("[data-source=\"type\"]").select("[class=\"pi-data-value pi-font\"]").text()
        val data = aside_items_profile.select("[class=\"pi-data-value pi-font\"]")
        val divData = scrapper.getElementsByClass("mw-parser-output")
        var description_general  = ""
        for (info in divData){
            val childrens = info.children()
            childrens.forEach { element->
                if (element.tag().toString() != "aside"){
                    if (element.tagName() == "h2"){
                        description_general += element.children().first()?.text()+"\n"
                    } else if (element.tagName("p").text() != ""){
                        description_general += element.tagName("p").text()+"\n"
                    }
                }
            }
        }
       val item_profile = ItemProfile(
            description_general,
            imgItem,
            itemType,
            data[1].text(),
            data[2].text(),
            data[3].text(),
            data[4].text(),
            data[5].text()
        )
        return item_profile

        /*println(description_general)
        println("IMG: ${imgItem}")
        println("Type: ${itemType}")
        println(data[1].text())
        println("Effect: ${data[2].text()}")
        println("Source: ${data[3].text()}")
        println("Cost to buy: ${data[4].text()}")
        println("Gold for sell: ${data[5].text()}")*/
    }
}