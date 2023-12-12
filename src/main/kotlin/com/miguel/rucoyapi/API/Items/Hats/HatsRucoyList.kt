package API.Items.Hats

import model.Hat
import org.jsoup.nodes.Document
import java.util.ArrayList

class HatsRucoyList {
    fun getHatsRucoyList(scrapper: Document): ArrayList<Hat> {
        val hats_list = ArrayList<Hat>()
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
            val Defense = td[2].text()
            val magi_level = td[3].text()
            val BuyNPC = td[4].text()
            val SellNPC = td[5].text()
            var DropBy: String? = null
            if (td[6].children().size == 1){
                DropBy = td[6].text()
            }
            hats_list.add(
                Hat(
                    nameItem,
                    imgItem,
                    Defense,
                    magi_level,
                    BuyNPC,
                    SellNPC,
                    DropBy
                )
            )
        }
        hats_list.removeFirst()
        return hats_list
    }
}