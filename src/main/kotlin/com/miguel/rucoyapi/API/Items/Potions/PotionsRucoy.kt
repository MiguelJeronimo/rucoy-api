package API.Items.Potions

import model.Potion
import org.jsoup.nodes.Document

class PotionsRucoy {
    fun getItemPotionsRucoy(scrapper: Document): ArrayList<Potion> {
        val items = scrapper.getElementsByClass("article-table")
        val trs = items.select("tbody").select("tr")
        var imgItem: String?
        var nameItem: String?
        var effect: String?
        var BuyNPC: String?
        var SellNPC: String?
        val itemRucoyData = ArrayList<Potion>()
        trs.forEach { tr->
            //Validate sword name
            val td = tr.select("[style=text-align:center;]")
            if (td[0].children().text() == ""){
                nameItem = td[1].children().text()
            } else{
                nameItem = td[0].children().text()
            }
            if (tr.select("img").attr("data-src") == ""){
                imgItem = tr.select("img").attr("src")
            } else{
                imgItem = tr.select("img").attr("data-src")
            }
            effect = td[1].text()
            BuyNPC = td[2].text()
            SellNPC = td[3].text()
            itemRucoyData.add(Potion(
                nameItem.toString(),
                imgItem.toString(),
                effect.toString(),
                BuyNPC.toString(),
                SellNPC.toString()
            ))
        }
        itemRucoyData.removeFirst()
        return itemRucoyData
    }
}