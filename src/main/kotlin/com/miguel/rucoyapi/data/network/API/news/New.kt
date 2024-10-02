package API.news

import model.content
import model.new_data
import model.newsRucoy
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class New {
    var new_data_rucoy = ArrayList<new_data>()
    fun NewsRucoy(scrapper: Document): newsRucoy {
        var elemento = scrapper.getElementsByClass("row news")
        for (nodos in elemento){
            var news_data = new_data(null, null,null,null)
            var arrayData = ArrayList<String>()
            news_data.date = nodos.getElementsByClass("news-date").text()
            ubicacionesContenido(nodos,news_data,arrayData)
            val arrayobeject = content(arrayData)
            news_data.content = arrayobeject
            new_data_rucoy.add(news_data)
        }
        val dataNewRucoy  = newsRucoy(new_data_rucoy)
        return dataNewRucoy
    }

    fun ubicacionesContenido(elemento: Element, news_data: new_data, arrayData: ArrayList<String>){
        val elementos = elemento.children()
        for (element in elementos) {
            if (element.children().isNotEmpty()) {
                // Verifica si lo que se itera es un elemento
                if (element is Element) {
                    ubicacionesContenido(element, news_data, arrayData)
                }
            } else {
                if (element.text() != "") {
                    if (element.tagName()=="h2"){
                        news_data.title = element.text()
                    } else if (element.tagName()=="h4"){
                        news_data.subtittle = element.text()
                    } else if(element.tagName()=="li" || element.tagName()=="p" ){
                        arrayData.add(element.text())
                    } else{
                        arrayData.add(element.text())
                    }
                } else if (element.attr("src")!=""){
                    arrayData.add("https://www.rucoyonline.com/${element.attr("src")}")
                }
            }
        }
    }
}