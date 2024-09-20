package com.miguel.rucoyapi.repository.Tibia

import API.guildss.GuildsData
import Jsoup.Scrapper
import model.Guild

class RepositoryTibia {
    fun rashid(guildName:String) {
        try {
            val url = "https://www.rucoyonline.com/guild/${guildName}"
            val scrapper = Scrapper().Soup(url)
            val guilds = GuildsData().dataGuild(scrapper)

        } catch (e:Exception){
            println("Error: ${e.message}")
            //return null
        }
    }
}