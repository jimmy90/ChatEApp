package server.messages;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jimmy2xx
 */
public class ChatMessage {
    
    protected ChatMessage(String message, String emetteur, String recu) {
		super();
		this.message = message;
		this.emetteur = emetteur;
		this.recu = recu;
    }
    private String message;
    private String emetteur;
    private String recu;

    public ChatMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getMessage() {
            return message;
    }
    public void setMessage(String message) {
            this.message = message;
    }
    public String getEmetteur() {
            return emetteur;
    }
    public void setEmetteur(String emetteur) {
            this.emetteur = emetteur;
    }
    public String getRecu() {
            return recu;
    }
    public void setRecu(String recu) {
            this.recu = recu;
    }

}
