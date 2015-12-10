
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Loug S
 */
public class ChatMessageDecoder {
  public String encode(ChatMessage message) throws EncodeException {

    JsonObject jsonObject = Json.createObjectBuilder()
        .add("Message", message.getMessage())
        .add("Emetteur", message.getEmetteur())
        .add("Reçu", message.getRecu().toString()).build();
    return jsonObject.toString();

  }

  public void init(EndpointConfig ec) {
    System.out.println("MessageEncoder - init method called");
  }

  public void destroy() {
    System.out.println("MessageEncoder - destroy method called");
  }
    
}
