
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Session.*;
import javax.websocket.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jimmy2xx
 */
public class ChatEndPoint {
    
    @OnOpen
    public void onOpen(Session session){
        
    }
    
    @OnMessage
    public void onMessage(ChatMessage message){
        
    }
}
