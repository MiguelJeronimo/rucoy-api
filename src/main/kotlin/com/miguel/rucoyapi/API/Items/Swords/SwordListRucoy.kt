package API.Items.Swords

import model.ItemRucoyData
import model.ItemsRucoyData
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class SwordListRucoy {
    fun getSwordList(scrapper: Document): ItemsRucoyData {
        val items = scrapper.getElementsByClass("article-table")[1]
        val tr = items.select("tbody").select("tr")
        val itemRucoyData = ArrayList<ItemRucoyData>()
        tr.forEach { data ->
            var DropBy = ArrayList<String>()
            var imgItem: String? = null
            //data.firstElementChild()?.attr("style", "text-align:center;")
            val td = data.select("[style=text-align:center;]")
            var nameItem: String? = null
            //Validate sword name
            if (td[0].children().text() == "") {
                nameItem = td[1].children().text()
            } else {
                nameItem = td[0].children().text()
            }
            if (data.select("img").attr("data-src") == "") {
                imgItem = data.select("img").attr("src")
            } else {
                imgItem = data.select("img").attr("data-src")
            }
            var Damage: List<String>? = null
            var BuyNPC: List<String>? = null
            var SellNPC: List<String>? = null
            Damage = data.children()[2].allElements.map {//it.text().trim()
                var dato = ""
                if (it.wholeOwnText().trim() != "") {
                    dato = it.wholeOwnText().trim()
                }
                return@map dato
            }.filter { it.isNotEmpty() }
            BuyNPC = data.children()[3].allElements.map {//it.text().trim()
                var dato = ""
                if (it.wholeOwnText().trim() != "") {
                    dato = it.wholeOwnText().trim()
                }
                return@map dato
            }.filter { it.isNotEmpty() }
            SellNPC = data.children()[4].allElements.map {//it.text().trim()
                var dato = ""
                if (it.wholeOwnText().trim() != "") {
                    dato = it.wholeOwnText().trim()
                }
                return@map dato
            }.filter { it.isNotEmpty() }
            DropBy.add(data.children()[5].text())
            itemRucoyData.add( ItemRucoyData(
                nameItem,
                imgItem,
                Damage as MutableList<String>,
                BuyNPC as MutableList<String>,
                DropBy,
                SellNPC as MutableList<String>
            )
            )
        }
        itemRucoyData.removeFirst()
        return ItemsRucoyData(itemRucoyData)
    }
}