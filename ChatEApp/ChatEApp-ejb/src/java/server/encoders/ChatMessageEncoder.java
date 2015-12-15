package server.encoders;

import server.messages.ChatMessage;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jimmy2xx
 */
public class ChatMessageEncoder implements Encoder.Text<ChatMessage>  {

     public String encode(ChatMessage message) throws EncodeException {

    JsonObject jsonObject;
      jsonObject = Json.createObjectBuilder()
              .add("Message", message.getMessage())
              .add("Emetteur", message.getEmetteur())
              .add("Date", message.getRecu().toString()).build();
    return jsonObject.toString();

  }

  public void init(EndpointConfig ec) {
    System.out.println("MessageEncoder - init method called");
  }


    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
