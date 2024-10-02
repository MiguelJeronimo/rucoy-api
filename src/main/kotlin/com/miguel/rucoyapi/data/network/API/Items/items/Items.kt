package API.Items.items

import model.Category
import org.jsoup.nodes.Document

class Items {
    fun getItemsList(scrapper: Document): ArrayList<Category> {
        val tables = scrapper.getElementsByClass("article-table")
        val table = tables.select(".article-table")
        val tr = table[1].select("tr")
        val arrayURL = ArrayList<String>()
        val arrayText = ArrayList<String>()
        val arrayCategory = ArrayList<Category>()
        tr.forEach {
            it.children().forEach {
                val imgContainer = it.getElementsByClass("center")
                val img = imgContainer.select("img")
                val imgItem: String?
                imgItem = if (img.attr("data-src") == ""){
                    img.attr("src")
                } else{
                    img.attr("data-src")
                }
                if (imgItem != ""){
                    arrayURL.add(imgItem)
                }
                val textContainer = it.select("[style=text-align:center;]")
                val textData: String
                if (textContainer.text() != ""){
                   textData = textContainer.text()
                    arrayText.add(textData)
                }
            }
        }
        for (i in 0..17){
            arrayCategory.add(
                Category(
                    arrayURL[i],
                    arrayText[i]
                )
            )
        }
        return arrayCategory
    }
}