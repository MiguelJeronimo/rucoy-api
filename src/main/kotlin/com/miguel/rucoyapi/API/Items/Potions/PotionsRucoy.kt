package API.Items.Potions

import model.ItemRucoyPotions
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class PotionsRucoy {
    fun potionsList(scrapper: Document): ArrayList<ItemRucoyPotions> {
        val items = scrapper.getElementsByClass("article-table")
        val trs = items.select("tbody").select("tr")
        var imgItem: String?
        var nameItem: String?
        var effect: String?
        var BuyNPC: String?
        var SellNPC: String?
        val itemRucoyData = ArrayList<ItemRucoyPotions>()
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
            itemRucoyData.add(ItemRucoyPotions(
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