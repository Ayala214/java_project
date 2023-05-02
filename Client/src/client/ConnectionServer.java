package client;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.Place;


/**
 *
 * @author student
 */
public class ConnectionServer {

    private DataOutputStream toServer;
    private ObjectInputStream fromeServer;
    private Socket socket;

//    חיבור לשרת
    public ConnectionServer() {
        try {
            socket = new Socket("localhost", 1728);
            toServer = new DataOutputStream(socket.getOutputStream());
            fromeServer = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ConnectionServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void WriteToServer(String p) {
        try {
            toServer.writeUTF(p);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            toServer.flush();
        } catch (IOException ex) {
            Logger.getLogger(ConnectionServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Place> ReadFromeServer() {
        try {

            Object o = fromeServer.readUnshared();
            return ((ArrayList<Place>) (o));
        } catch (IOException ex) {
            Logger.getLogger(ConnectionServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String ReadstringfromServer() {

        try {
            return fromeServer.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(ConnectionServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean ReadboolFromeServer() {
        try {

            return fromeServer.readBoolean();

        } catch (IOException ex) {
            Logger.getLogger(ConnectionServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("המקום נבחר בהצלחה");
        return false;
    }
}
