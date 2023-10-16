package API.guildss

import model.Guild
import model.Members
import org.jsoup.nodes.Document

class GuildsData {
    fun dataGuild(scrapper:Document): Guild {
        var body = scrapper.getElementsByClass("guild-box")
        var nameGuild = body.select("h3").text()
        var descriptionGuild = body.select("p")[0].text()
        var guildFoundation = body.select("p")[1].text()
        var tableMembers = body.select("tbody")
        val arrayMembers = ArrayList<Members>()
        for (data in tableMembers) {
            val tr = data.select("tr")
            for (celda in tr) {
                val nameMember = celda.select("td")[0].children().eachText()[0]
                val suppout = celda.select("td")[0].children().eachText()
                var Supporter = ""
                if (suppout.size>1){
                    Supporter = suppout[1]
                } else{
                    Supporter = ""
                }
                val levelMember = celda.select("td")[1].text()
                val joinDateMember = celda.select("td")[2].text()
                //println(suppout)
                arrayMembers.add(
                    Members(
                        nameMember,
                        Supporter,
                        levelMember,
                        joinDateMember
                    )
                )
            }
        }
        var guildData = Guild(
            nameGuild,
            descriptionGuild,
            guildFoundation,
            arrayMembers
        )
        return guildData
    }

}