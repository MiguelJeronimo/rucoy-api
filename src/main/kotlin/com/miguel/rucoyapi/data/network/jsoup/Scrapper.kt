package com.miguel.rucoyapi.data.network.jsoup

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class Scrapper {
    fun Soup(url:String): Document {
        //Itony Stark
        val conexion = Jsoup.connect(url).get()
        return conexion
    }
}