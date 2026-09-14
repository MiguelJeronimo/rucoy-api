package com.miguel.rucoyapi.presentation.controllers

import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
//import org.springframework.web.socket.CloseStatus
//import org.springframework.web.socket.TextMessage
//import org.springframework.web.socket.WebSocketSession
//import org.springframework.web.socket.config.annotation.EnableWebSocket
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry
//import org.springframework.web.socket.handler.TextWebSocketHandler
//
//@Configuration
//@EnableWebSocket
//class ChatController: WebSocketConfigurer{
//    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
//        registry.addHandler(ChatSocketHandler(), "/app/chat")
//    }
//}
//var userOnline = 0
//
//@Component
//class ChatSocketHandler : TextWebSocketHandler() {
//    private val sessions = mutableListOf<WebSocketSession>()
//
//    override fun afterConnectionEstablished(session: WebSocketSession) {
//        println(session)
//        sessions.add(session)
//    }
//
//    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
//        super.afterConnectionClosed(session, status)
//        println("Conexión cerrada: $session, status: $status")
//        sessions.remove(session)
//    }
//
//    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
//        try {
//            sessions.removeIf { !it.isOpen } // Elimina sesiones cerradas
//            for (s in sessions) {
//                s.sendMessage(message)
//            }
//        } catch (e: Exception){
//            println("Error: "+e.message)
//        }
//    }
//}
