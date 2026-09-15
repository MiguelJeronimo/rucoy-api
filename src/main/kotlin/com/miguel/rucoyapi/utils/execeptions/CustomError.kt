package com.miguel.rucoyapi.utils.execeptions

class CustomError(message: String): RuntimeException(message)
data class ErrorAuthorizer(val error: String, val message:String)