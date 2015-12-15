package server.decoders;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import server.messages.ChatMessage;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Jimmy2xx
 */
public class ChatMessageDecoder implements Decoder.Text<ChatMessage> {

    @Override
    public ChatMessage decode(String jsonMsg) throws DecodeException {
        JsonObject jsonObject = Json
        .createReader(new StringReader(jsonMsg)).readObject();
        ChatMessage message;
            message = new ChatMessage();
                    message.setMessage(jsonObject.getString("Message"));
                    message.setEmetteur(jsonObject.getString("Emetteur"));
                    message.setRecu(jsonObject.getString("Date"));
        return message;
    }

    @Override
    public boolean willDecode(String jsonMsg) {
        try {
          // Check if incoming message is valid JSON
          Json.createReader(new StringReader(jsonMsg)).readObject();
          return true;
        } catch (Exception e) {
          return false;
        }
    }

    @Override
    public void init(EndpointConfig config) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
