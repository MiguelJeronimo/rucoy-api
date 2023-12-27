package com.miguel.rucoyapi.utils

import java.io.*

class utils {

    /**
     * @param document Recibe el archivo de texto que se va a leer
     * @return Arraylist<String> con los elementos de un archivo.txt
     */
    fun readDocumenttxt(document: InputStream): ArrayList<String>{
        val arrayListHighScore = ArrayList<String>()
        val bufferedReader = BufferedReader(InputStreamReader(document))
        var data: String?
        try {
            while (bufferedReader.readLine().also { data = it } != null){
                arrayListHighScore.add(data!!)
            }
            document.close()
        } catch (e: IOException){
            e.printStackTrace()
        }
        return arrayListHighScore
    }

    fun searchdataArray(data:ArrayList<String>, validateData:ArrayList<String>, searchdata:String): String {
        val patron = "\\(.*\\)".toRegex()
        val cadenaIsExistParentesis = searchdata.contains(patron)
        val dataSplit: String
        val arrayData: List<String>
        if (cadenaIsExistParentesis){
            dataSplit = searchdata.replace(patron,"")
        }else{
            val dataSeparate = searchdata.split(" ")
            val sepate:String
            val levelFilter = dataSeparate.filter { it == "Level."}
            //validate if exist Level. for items catalog
            if (levelFilter.isNotEmpty()){
                sepate = "${levelFilter[0]} ${dataSeparate.last()}"
            }else{
                sepate = dataSeparate.last()
            }
            arrayData = data.filter { it == sepate }
            dataSplit =  when (arrayData.isEmpty()){
                 true ->{
                    searchdata
                }
                else-> {
                    //Validate data: Necklacere because incorrect is data
                    if (sepate == "Necklacere"){
                        searchdata.replace(dataSeparate.last(),validateData[0])
                    }
                    else if (arrayData[0] == sepate){
                        searchdata.replace(sepate,"")
                    }else {
                        searchdata.replace(sepate,"")
                    }
                }
            }
        }
        return dataSplit
    }
}