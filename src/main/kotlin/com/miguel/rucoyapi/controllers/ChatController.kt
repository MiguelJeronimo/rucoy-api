package com.miguel.rucoyapi.controllers

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.messaging.simp.annotation.SubscribeMapping
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.config.annotation.*
import org.springframework.web.socket.handler.TextWebSocketHandler

@Configuration
@EnableWebSocket
class ChatController: WebSocketConfigurer{
    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(ChatSocketHandler(), "/app/chat")
    }
}
var userOnline = 0

@Component
class ChatSocketHandler : TextWebSocketHandler() {
    private val sessions = mutableListOf<WebSocketSession>()

    override fun afterConnectionEstablished(session: WebSocketSession) {
        println(session)
        sessions.add(session)
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        super.afterConnectionClosed(session, status)
        println("Conexión cerrada: $session, status: $status")
        sessions.remove(session)
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        try {
            sessions.removeIf { !it.isOpen } // Elimina sesiones cerradas
            for (s in sessions) {
                s.sendMessage(message)
            }
        } catch (e: Exception){
            println("Error: "+e.message)
        }
    }
}
