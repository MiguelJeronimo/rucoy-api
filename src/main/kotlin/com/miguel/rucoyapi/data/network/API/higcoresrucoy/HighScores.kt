package com.miguel.rucoyapi.data.network.API.higcoresrucoy

import model.Defense
import model.Distance
import model.HighScore
import model.Magic
import model.Mele
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class HighScores(private val scrapper: Document) {
    fun highScores(): ArrayList<HighScore> {
        val tablehighscores: Elements = scrapper.getElementsByClass("table-responsive")
        val data = tablehighscores.select("tbody")
        val datos = ArrayList<HighScore>()
        for (row in data){
            val legends = row.getElementsByTag("td")[0].text()
            if (legends != "Level 250 or greater required"){
                val celdas = row.select("tr")
                val celdass = celdas
                for (celda in celdass){
                    //Level 250 or greater required
                    val legends = celda.getElementsByTag("td")[0].text()
                    if (legends != "Level 250 or greater required"){
                        val rango = celda.getElementsByTag("td")[0]?.text()
                        val nombre = celda.getElementsByTag("td")[1].getElementsByTag("a").text()
                        val level = celda.getElementsByTag("td")[2]?.text()
                        val experiencia = celda.getElementsByTag("td")[3]?.text()
                        //hay que validar si esta vacio
                        var status = celda.getElementsByTag("td")[1].getElementsByTag("span").text()
                        if(status==""){
                            status = "Offline"
                        }
                        datos.add(
                            HighScore(
                                rango.toString(),
                                nombre.toString(),
                                status.toString(),
                                level.toString(),
                                experiencia.toString()
                            )
                        )
                    }
                }
            }
        }
        return datos
    }

    fun hightScoreMele(scrapper:Document): ArrayList<Mele> {
        val tableMele = scrapper.getElementsByClass("table-responsive")
        val tbodyMele = tableMele.select("tbody")
        val meles = ArrayList<Mele>()
        for (data in tbodyMele) {
            val tr = data.select("tr")
            for (celdas in tr) {
                val legends = celdas.getElementsByTag("td")[0].text()
                if (!legends.equals("Melee 250 or greater required")){
                    val rango = celdas.getElementsByTag("td")[0]?.text()
                    val nombre = celdas.getElementsByTag("td")[1].getElementsByTag("a").text()
                    val mele = celdas.getElementsByTag("td")[2]?.text()
                    //hay que validar si esta vacio
                    var status = celdas.getElementsByTag("td")[1].getElementsByTag("span").text()
                    if (status == "") {
                        status = "Offline"
                    }
                    meles.add(
                        Mele(
                            rango.toString(),
                            nombre.toString(),
                            status.toString(),
                            mele.toString()
                        )
                    )
                }
            }
        }
        return meles
    }

    fun hightScoreDistance(scrapper:Document): ArrayList<Distance> {
        val tableDistance = scrapper.getElementsByClass("table-responsive")
        val tbodyDistance = tableDistance.select("tbody")
        val distances = ArrayList<Distance>()
        for (data in tbodyDistance) {
            val tr = data.select("tr")
            for (celdas in tr) {
                val legends = celdas.getElementsByTag("td")[0].text()
                if (legends!= "Distance 250 or greater required"){
                    val rango = celdas.getElementsByTag("td")[0]?.text()
                    val nombre = celdas.getElementsByTag("td")[1].getElementsByTag("a").text()
                    val distance = celdas.getElementsByTag("td")[2]?.text()
                    //hay que validar si esta vacio
                    var status = celdas.getElementsByTag("td")[1].getElementsByTag("span").text()
                    if (status == "") {
                        status = "Offline"
                    }
                    distances.add(
                        Distance(
                            rango.toString(),
                            nombre.toString(),
                            status.toString(),
                            distance.toString()
                        )
                    )
                }
            }
        }
        return distances
    }

    fun hightScoreMagic(scrapper:Document): ArrayList<Magic> {
        val tableDistance = scrapper.getElementsByClass("table-responsive")
        val tbodyDistance = tableDistance.select("tbody")
        val magics = ArrayList<Magic>()
        for (data in tbodyDistance) {
            val tr = data.select("tr")
            for (celdas in tr) {
                val legends = celdas.getElementsByTag("td")[0].text()
                if (legends!= "Magic 250 or greater required"){
                    val rango = celdas.getElementsByTag("td")[0]?.text()
                    val nombre = celdas.getElementsByTag("td")[1].getElementsByTag("a").text()
                    val magic = celdas.getElementsByTag("td")[2]?.text()
                    //hay que validar si esta vacio
                    var status = celdas.getElementsByTag("td")[1].getElementsByTag("span").text()
                    if (status == "") {
                        status = "Offline"
                    }
                    magics.add(
                        Magic(
                            rango.toString(),
                            nombre.toString(),
                            status.toString(),
                            magic.toString()
                        )
                    )
                }
            }
        }
        return magics
    }

    fun hightScoreDefense(scrapper:Document): ArrayList<Defense> {
        val tableDistance = scrapper.getElementsByClass("table-responsive")
        val tbodyDistance = tableDistance.select("tbody")
        val defenses = ArrayList<Defense>()
        for (data in tbodyDistance) {
            val tr = data.select("tr")
            for (celdas in tr) {
                val legends = celdas.getElementsByTag("td")[0].text()
                if (legends!= "Defense 250 or greater required"){
                    val rango = celdas.getElementsByTag("td")[0]?.text()
                    val nombre = celdas.getElementsByTag("td")[1].getElementsByTag("a").text()
                    val defense = celdas.getElementsByTag("td")[2]?.text()
                    //hay que validar si esta vacio
                    var status = celdas.getElementsByTag("td")[1].getElementsByTag("span").text()
                    if (status == "") {
                        status = "Offline"
                    }
                    defenses.add(
                        Defense(
                            rango.toString(),
                            nombre.toString(),
                            status.toString(),
                            defense.toString()
                        )
                    )
                }
            }
        }
        return defenses
    }
}