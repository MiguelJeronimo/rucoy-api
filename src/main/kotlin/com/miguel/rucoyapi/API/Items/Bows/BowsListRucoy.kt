package API.Items.Bows

import model.ItemRucoyData
import org.jsoup.nodes.Document
import java.util.*

class BowsListRucoy {
    fun getBowList(scrapper: Document): ArrayList<ItemRucoyData> {
        var bow_list = ArrayList<ItemRucoyData>()
        val items = scrapper.getElementsByClass("article-table")
        val tr = items.select("tbody").select("tr")
        //println(tr)
        val itemRucoyData = ArrayList<ItemRucoyData>()
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
            val Damage = td[2].children().eachText()
            val BuyNPC = td[3].allElements.map {//it.text().trim()
                var data = ""
                if (it.wholeOwnText().trim() != "") {
                    data = it.wholeOwnText().trim()
                }
                return@map data
            }.filter { it.isNotEmpty()  }
            val SellNPC = td[4].allElements.map {//it.text().trim()
                var data = ""
                if (it.wholeOwnText().trim() != "") {
                    data = it.wholeOwnText().trim()
                }
                return@map data
            }.filter { it.isNotEmpty()  }
            val DropBy: ArrayList<String>
            if (td[5].children().size == 1){
                DropBy = td[5].allElements.eachText() as ArrayList<String>
                DropBy.removeLast()
            } else {
                DropBy = td[5].children().eachText() as ArrayList<String>
            }
            bow_list.add(
                ItemRucoyData(
                    nameItem,
                    imgItem,
                    Damage,
                    BuyNPC as MutableList<String>,
                    DropBy,
                    SellNPC as MutableList<String>
                )
            )
        }
        bow_list.removeFirst()
        return bow_list
    }
}