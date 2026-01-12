package com.miguel.rucoyapi.data.network.jsoup

import com.fasterxml.jackson.core.JsonParser
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class Scrapper {
    fun Soup(url:String): Document {
        //Itony Stark
        val conexion = Jsoup.connect(url).get()
        return conexion
    }

    fun htmlConverter(code: String): Document? {
        val parse = Jsoup.parse(code)
        return parse
    }
}