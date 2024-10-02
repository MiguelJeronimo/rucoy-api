package API.Items.Rings

import model.Ring
import org.jsoup.nodes.Document
import java.util.ArrayList

class RingsList {
    fun getRingsList(scrapper: Document): ArrayList<Ring> {
        var rings_list = ArrayList<Ring>()
        val items = scrapper.getElementsByClass("article-table")
        val tr = items.select("tbody").select("tr")
        tr.forEach { data->
            val imgItem: String?
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
            val level = td[2].text()
            val stats = td[3].text()
            rings_list.add(
                Ring(
                    nameItem,
                    imgItem,
                    level,
                    stats
                )
            )
        }
        rings_list.removeFirst()
        return rings_list
    }
}