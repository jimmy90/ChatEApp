package server.messages;


import java.util.Date;

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
    
    protected ChatMessage(String message, String emetteur, Date recu) {
		super();
		this.message = message;
		this.emetteur = emetteur;
		this.recu = recu;
    }
    private String message;
    private String emetteur;
    private Date recu;
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
    public Date getRecu() {
            return recu;
    }
    public void setRecu(Date recu) {
            this.recu = recu;
    }

}
