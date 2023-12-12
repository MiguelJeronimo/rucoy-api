package API.Items.Shield

import model.Shield
import org.jsoup.nodes.Document
import java.util.ArrayList

class ShieldRucoyList {
    fun getShieldRucoyList(scrapper: Document): ArrayList<Shield> {
        val shield_list = ArrayList<Shield>()
        val items = scrapper.getElementsByClass("article-table")
        val tr = items.select("tbody").select("tr")
        tr.forEach { data->
            val imgItem: String?
            //val td = data.select("[style=text-align:center;]")
            val td = data.children()
            var nameItem: String?
            //Validate sword name
            nameItem = if (td[0].children().text() == "" || td[0].children().text() == "File:Golden Training Bow.png"){
                td[1].children().text()
            } else{
                td[0].children().text()
            }
            nameItem.also { nameItem = it.split("Lv ")[0] }
            nameItem.also { nameItem = it!!.split("Lvl ")[0] }
            imgItem = if (data.select("img").attr("data-src") == ""){
                data.select("img").attr("src")
            } else{
                data.select("img").attr("data-src")
            }
            val DropBy: String?
            val armor: String
            val BuyNPC: String
            val SellNPC: String
            if (nameItem.equals("Swift boots")){
                armor = td[3].text()
                BuyNPC = td[4].text()
                SellNPC = td[5].text()
                DropBy = td[6].allElements.eachText().first()
            } else{
                armor = td[2].text()
                BuyNPC = td[3].text()
                SellNPC = td[4].text()
                DropBy = td[5].allElements.eachText().first()
            }
            shield_list.add(
                Shield(
                    nameItem.toString(),
                    imgItem,
                    armor,
                    BuyNPC,
                    SellNPC,
                    DropBy
                )
            )
        }
        shield_list.removeFirst()
        return shield_list
    }
}