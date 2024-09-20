package com.miguel.rucoyapi.model

class responses {
    //data class responsesNews
    data class Errors(val statusCode: Int, val error: String)
    data class response(
        val statusCode: Int,
        val Body: Any?
    )
}