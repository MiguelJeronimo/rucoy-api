package API.Items.Armor

import model.Armor
import org.jsoup.nodes.Document
import java.util.ArrayList

class ArmorRucoyList {
    fun getArmorList(scrapper: Document): ArrayList<Armor> {
        val armor_list = ArrayList<Armor>()
        val items = scrapper.getElementsByClass("article-table")
        val tr = items.select("tbody").select("tr")
        tr.forEach { data->
            val imgItem: String?
            //val td = data.select("[style=text-align:center;]")
            val td = data.children()
            val nameItem: String?
            //Validate sword name
            nameItem = if (td[0].children().text() == "" || td[0].children().text() == "File:Golden Training Bow.png"){
                td[1].children().text()
            } else{
                td[0].children().text()
            }
            imgItem = if (data.select("img").attr("data-src") == ""){
                data.select("img").attr("src")
            } else{
                data.select("img").attr("data-src")
            }
            val DropBy: String?
            val defense: String
            val Speed: String
            val distances: String
            val BuyNPC: String
            val SellNPC: String
            defense = td[2].text()
            BuyNPC = td[3].text()
            SellNPC = td[4].text()
            DropBy = if (td[5].allElements.eachText().isNotEmpty()) td[5].allElements.eachText().first() else td[5].allElements.eachText().toString()
            armor_list.add(
                Armor(
                    nameItem,
                    imgItem,
                    defense,
                    BuyNPC,
                    SellNPC,
                    DropBy
                )
            )
        }
        armor_list.removeFirst()
        return armor_list
    }
}