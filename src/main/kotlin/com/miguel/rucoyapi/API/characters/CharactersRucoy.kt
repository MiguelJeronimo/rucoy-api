package API.characters


import model.CharactersDataGeneral
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.util.*

class CharactersRucoy {
    //verifica la data general del personaje
    fun searchCharacter(scrapper: Document): CharactersDataGeneral {
        val dataGeneral: Elements = scrapper.getElementsByClass("table-responsive").select("tbody")
        val characters = CharactersDataGeneral(null,null,null,null,null,null,null)
        val tr = dataGeneral.select("tr")
        val deaths = characterDeaths(scrapper)
        characters.death = deaths as ArrayList<String>?
        for (row in tr){
            val label = row.children().eachText()[0]
            val value = row.children().eachText()[1]
                when (label) {
                    "Name" -> characters.name = value
                    "Level" -> characters.level = value
                    "Guild" -> characters.guild = value
                    "Title" -> characters.title = value
                    "Last online" -> characters.lastOnline = value
                    "Born" -> characters.born = value
                }
        }

        return characters
    }
    //verifica las muertes del personaje
    fun characterDeaths(scrapper: Document): MutableList<String>? {
        val dataGeneral: Elements = scrapper.getElementsByClass("character-table table table-bordered")
        if (dataGeneral.size>1){
            if (dataGeneral[1].text()!=""){
                //quitamos el primer nodo del la tabla
                return dataGeneral[1].children().select("tbody").select("tr").eachText()
            }
        }
        return null
    }
}
