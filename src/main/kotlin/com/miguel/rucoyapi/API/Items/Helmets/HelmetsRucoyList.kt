package API.Items.Helmets

import model.Helmet
import org.jsoup.nodes.Document
import java.util.ArrayList

class HelmetsRucoyList {
    fun getRucoyRucoyList(scrapper: Document): ArrayList<Helmet> {
        val helmets_list = ArrayList<Helmet>()
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
            val BuyNPC = td[3].text()
            val SellNPC = td[4].text()
            val DropBy: String?
            DropBy = td[5].allElements.eachText().first()
            helmets_list.add(
                Helmet(
                    nameItem,
                    imgItem,
                    Defense,
                    BuyNPC,
                    SellNPC,
                    DropBy
                )
            )
        }
        helmets_list.removeFirst()
        return helmets_list
    }
}