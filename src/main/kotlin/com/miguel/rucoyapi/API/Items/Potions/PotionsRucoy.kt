package API.Items.Potions

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class PotionsRucoy {


    fun getItemPotionsRucoy(scrapper: Document) {
        val items = scrapper.getElementsByClass("article-table")
        for (item in items){
            searchDataPotionsRucoy(item)
        }
    }
    fun searchDataPotionsRucoy(element: Element){
        val elements = element.children()
        for (element in elements){
            if (element.tagName() == "td"){
                if (element.tagName() == "a"){
                    println("Name ITem: "+element.text())
                } else if (element.hasText()){
                    println("Buy NPC: "+ element.text())
                }
                else{
                    searchDataPotionsRucoy(element)
                }
            }
            else if (element.tagName() == "th"){
                if (element.hasText()){println("Sell NPC: "+element.text())}
            }
            if (element.tagName() == "figure"){
                //println(element.children().get(0).select("img"))
                var imgItem: String?
                if (element.children().get(0).select("img").attr("data-src") == ""){
                    imgItem = element.select("img").attr("src")
                    println(imgItem)
                } else{
                    imgItem = element.select("img").attr("data-src")
                    println(imgItem)
                }
            }
            else{
                searchDataPotionsRucoy(element)
            }
        }
    }
}