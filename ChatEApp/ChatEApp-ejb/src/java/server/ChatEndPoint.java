package server;


import server.encoders.ChatMessageEncoder;
import server.decoders.ChatMessageDecoder;
import java.util.Collections;
import java.util.*;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jimmy2xx
 */

@ServerEndpoint(
  value = "/websocket", 
  encoders = { ChatMessageEncoder.class }, 
  decoders = { ChatMessageDecoder.class }
)
public class ChatEndPoint {
    
    private static final Set<Session> users = Collections.synchronizedSet(new HashSet<Session>());
    
    @OnOpen
    public void onOpen(Session session){
        users.add(session);
        System.out.println("Client connected");
    }
    
    @OnClose
    public void onClose(Session session){
        users.remove(session);
    }
    
    @OnMessage //Cette méthode est appelé des qu'un client envoie un message
    public void message(String message, Session client) throws EncodeException {
        for (Session user : users) { //On parcours tous les clients déjà connecté
            user.getAsyncRemote().sendObject(message); //et on leur renvoie le message
        }
    }
}
