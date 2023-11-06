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
        println(searchdata)
        val patron = "\\(.*\\)".toRegex()
        val cadenaIsExistParentesis = searchdata.contains(patron)
        val dataSplit: String
        val arrayData: List<String>
        if (cadenaIsExistParentesis){
            dataSplit = searchdata.replace(patron,"")
        }else{
            val dataSeparate = searchdata.split(" ")
            val sepate = dataSeparate.last()
            arrayData = data.filter { it == sepate }
            dataSplit =  when (arrayData.isEmpty()){
                 true ->{
                    searchdata
                }
                else-> {
                    if (arrayData[0] == sepate) searchdata.replace(dataSeparate.last(),validateData[0]) else searchdata.replace(dataSeparate.last(),"")
                    //searchdata.replace(dataSeparate.last(),"")
                }
            }
        }
        return dataSplit
    }
}