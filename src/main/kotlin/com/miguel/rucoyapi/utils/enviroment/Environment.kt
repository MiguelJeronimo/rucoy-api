package com.miguel.rucoyapi.utils.enviroment

abstract class Environment {

    /**
     * Valida si se encuentra la variable de entorno y si no devuelve el text.
     * @param enviromentName nombre de la varible de entorno en formato de texto
     * @param text nombre del texto de configuracion
     *
     */
    fun environment(enviromentName: String?, text: String?): String? {
        return if (System.getenv(enviromentName) != null) System.getenv(enviromentName)?.trim() else text
    }
}