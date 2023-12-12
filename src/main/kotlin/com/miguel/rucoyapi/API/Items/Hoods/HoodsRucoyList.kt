package API.Items.Hoods

import model.Hood
import org.jsoup.nodes.Document
import java.util.ArrayList

class HoodsRucoyList {
    fun getHoodsRucoyList(scrapper: Document): ArrayList<Hood> {
        var hoods_list = ArrayList<Hood>()
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
            val Speed = td[3].text()
            val BuyNPC = td[4].text()
            val SellNPC = td[5].text()
            val DropBy: ArrayList<String>?
            if (td[6].children().size == 1){
                DropBy = td[6].allElements.eachText() as ArrayList<String>
                DropBy.removeLast()
            } else {
                DropBy = if (td[6].children().eachText().isNotEmpty()){
                    td[6].children().eachText() as ArrayList<String>
                }else{
                    td[6].allElements.eachText() as ArrayList<String>
                }
            }
            hoods_list.add(
                Hood(
                    nameItem,
                    imgItem,
                    Defense,
                    Speed,
                    BuyNPC,
                    SellNPC,
                    DropBy
                )
            )
        }
        hoods_list.removeFirst()
        return hoods_list
    }
}