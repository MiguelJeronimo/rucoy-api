package API.Items.Boots


import model.Boots
import org.jsoup.nodes.Document
import java.util.ArrayList

class BootsRucoyList {
    fun getBootsRucoyList(scrapper: Document): ArrayList<Boots> {
        val boots_list = ArrayList<Boots>()
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
            val Defense: String
            val BuyNPC: String
            val SellNPC: String
            if (nameItem.equals("Swift boots")){
                Defense = td[3].text()
                BuyNPC = td[4].text()
                SellNPC = td[5].text()
                DropBy = td[6].allElements.eachText().first()
            } else{
                Defense = td[2].text()
                BuyNPC = td[3].text()
                SellNPC = td[4].text()
                DropBy = td[5].allElements.eachText().first()
            }
            boots_list.add(
                Boots(
                    nameItem,
                    imgItem,
                    Defense,
                    BuyNPC,
                    SellNPC,
                    DropBy
                )
            )
        }
        boots_list.removeFirst()
        return boots_list
    }
}