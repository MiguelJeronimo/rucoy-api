package com.miguel.rucoyapi.controllers

import com.miguel.rucoyapi.model.responses
import com.miguel.rucoyapi.repository.Repository
import com.miguel.rucoyapi.utils.utils
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.io.File
import java.io.FileInputStream

@RestController
class ItemProfileController {
    @GetMapping("api/v1/item/{name}")
    fun getItemProfile(@PathVariable name: String): Any {
        return try {
            if (name != null){
                //leyendo archivos de la carpeta resources del proyecto spingboot
                val file = javaClass.getResourceAsStream("/databloqueada.txt")
                val validFile = javaClass.getResourceAsStream("/datacorrecta.txt")
                //println("Ruta del archivo: "+System.getProperty("user.dir"))
                val bloquedData = utils().readDocumenttxt(file)
                val validData = utils().readDocumenttxt(validFile)
                val data = utils().searchdataArray(bloquedData, validData, name)
                val item = Repository().itemProfile(data)
                if (item != null){
                    return responses.response(200, item)
                } else{
                    return responses.Errors(400, "Item is not exist")
                }
            } else{
                return responses.Errors(400, "Insert Name Item")
            }

        } catch (e: Exception){
            println("ERROR: ${e.stackTraceToString()}")
            return responses.Errors(500, e.stackTraceToString())
        }
    }
    @GetMapping("api/v1/item")
    @NotNull
    fun getItem(): Any {
        return try {
            return responses.Errors(400, "Not item name valid")
        } catch (e: Exception){
            println("ERROR: ${e.stackTraceToString()}")
            return responses.Errors(500, e.stackTraceToString())
        }
    }
}