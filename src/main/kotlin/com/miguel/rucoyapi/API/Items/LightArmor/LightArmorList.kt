package API.Items.LightArmor

import model.LightArmor
import model.Robe
import org.jsoup.nodes.Document
import java.util.ArrayList

class LightArmorList {
    fun getLightArmorList(scrapper: Document): ArrayList<LightArmor> {
        val lightarmor_list = ArrayList<LightArmor>()
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
            Speed = td[3].text()
            distances = td[4].text()
            BuyNPC = td[5].text()
            SellNPC = td[6].text()
            DropBy = if (td[7].allElements.eachText().isNotEmpty()) td[7].allElements.eachText().first() else td[7].allElements.eachText().toString()
            lightarmor_list.add(
                LightArmor(
                    nameItem,
                    imgItem,
                    defense,
                    Speed,
                    distances,
                    BuyNPC,
                    SellNPC,
                    DropBy
                )
            )
        }
        lightarmor_list.removeFirst()
        return lightarmor_list
    }
}