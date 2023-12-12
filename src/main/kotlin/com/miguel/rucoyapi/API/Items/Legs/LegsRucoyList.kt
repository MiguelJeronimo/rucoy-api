package API.Items.Legs


import model.Legs
import org.jsoup.nodes.Document
import java.util.ArrayList

class LegsRucoyList {
    fun getLegsRucoyList(scrapper: Document): ArrayList<Legs> {
        var legs_list = ArrayList<Legs>()
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
            val Capacity = td[2].text()
            val BuyNPC = td[3].text()
            val SellNPC = td[4].text()
            val DropBy: ArrayList<String>?
            if (td[5].children().size == 1){
                DropBy = td[5].allElements.eachText() as ArrayList<String>
                DropBy.removeLast()
            } else {
                DropBy = if (td[5].children().eachText().isNotEmpty()){
                    td[5].children().eachText() as ArrayList<String>
                }else{
                    td[5].allElements.eachText() as ArrayList<String>
                }
            }
            legs_list.add(
                Legs(
                    nameItem,
                    imgItem,
                    Capacity,
                    BuyNPC,
                    SellNPC,
                    DropBy
                )
            )
        }
        legs_list.removeFirst()
        return legs_list
    }
}