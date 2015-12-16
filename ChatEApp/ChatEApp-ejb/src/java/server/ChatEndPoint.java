package server;


import java.io.IOException;
import server.encoders.ChatMessageEncoder;
import server.decoders.ChatMessageDecoder;
import java.util.Collections;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import server.messages.ChatMessage;


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
  value = "/{room-id}", 
  encoders = { ChatMessageEncoder.class }, 
  decoders = { ChatMessageDecoder.class }
)
public class ChatEndPoint {
    
    private static final Set<Session> users = Collections.synchronizedSet(new HashSet<Session>());
    
    @OnOpen
    public void onOpen(Session session,
            @PathParam("room-id") String roomId){
        users.add(session);
        session.getUserProperties().put(roomId,true);
        //System.out.println("Client connected to room "+roomId);// A afficher dans la room
    }
    
    @OnClose
    public void onClose(Session session){
        users.remove(session);
    }
    
    @OnMessage 
    public void message(ChatMessage message, String roomId) throws EncodeException {
        for (Session user : users) { //On parcours tous les clients déjà connecté
            if (Boolean.TRUE.equals(user.getUserProperties().get(roomId))){
	        if (user.isOpen()){
                    try {
                        user.getBasicRemote().sendObject(message);
                    } catch (IOException ex) {
                        Logger.getLogger(ChatEndPoint.class.getName()).log(Level.SEVERE, null, ex);
                    }
	        }
    	  }
        }
    }
}
