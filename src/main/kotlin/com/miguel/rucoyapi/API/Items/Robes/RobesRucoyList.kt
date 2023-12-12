package API.Items.Robes

import model.Robe
import org.jsoup.nodes.Document
import java.util.ArrayList

class RobesRucoyList {
    fun getShieldRucoyList(scrapper: Document): ArrayList<Robe> {
        val robe_list = ArrayList<Robe>()
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
            val armor: String
            val magic: String
            val BuyNPC: String
            val SellNPC: String
            armor = td[2].text()
            magic = td[3].text()
            BuyNPC = td[4].text()
            SellNPC = td[5].text()
            DropBy = if (td[6].allElements.eachText().isNotEmpty()) td[6].allElements.eachText().first() else td[6].allElements.eachText().toString()
            robe_list.add(
                Robe(
                    nameItem,
                    imgItem,
                    armor,
                    magic,
                    BuyNPC,
                    SellNPC,
                    DropBy
                )
            )
        }
        robe_list.removeFirst()
        return robe_list
    }
}