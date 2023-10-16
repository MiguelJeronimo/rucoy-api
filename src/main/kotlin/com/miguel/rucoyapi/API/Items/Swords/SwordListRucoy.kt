package API.Items.Swords

import model.ItemRucoyData
import model.ItemsRucoyData
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class SwordListRucoy {
    fun getSwordList(scrapper: Document): ItemsRucoyData {
        val items = scrapper.getElementsByClass("article-table")[1]
        val tr = items.select("tbody").select("tr")
        val itemRucoyData = ArrayList<ItemRucoyData>()
        tr.forEach { data->
            var imgItem: String? = null
            val td = data.select("[style=text-align:center;]")
            var nameItem: String? = null
            //Validate sword name
            if (td[0].children().text() == ""){
                nameItem = td[1].children().text()
            } else{
                nameItem = td[0].children().text()
            }
            if (data.select("img").attr("data-src") == ""){
                imgItem = data.select("img").attr("src")
            } else{
                imgItem = data.select("img").attr("data-src")
            }
            val arrayDamage = td[1].children().eachText()
            val arrayBuyNPC = td[2].children().eachText()
            val arrayDropBy = td[3].children().eachText()
            val arraySellNPC = td[4].children().eachText()
            itemRucoyData.add( ItemRucoyData(
                nameItem,
                imgItem,
                arrayDamage,
                arrayBuyNPC,
                arrayDropBy,
                arraySellNPC
            )
            )
        }
        return ItemsRucoyData(itemRucoyData)
    }
}