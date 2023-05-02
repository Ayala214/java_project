package server;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class ClientHendler extends Thread {

    Socket conection;
    DataInputStream in;
    ObjectOutputStream out;

    public ClientHendler(Socket socket) {
        this.conection = conection;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClientHendler.class.getName()).log(Level.SEVERE, null, ex);
        }

        start();

    }

    public boolean ifcatch(int i, int j) {
        synchronized (ConnectionClient.ListPlace) {
            for (Place item : ConnectionClient.ListPlace) {
                if ((item.getI() == i) && (item.getJ() == j)) {
                    if( item.ifcatch == false){
                        item.setIfcatch(true);
                        return false;
                    }
                    else
                        return true;} } }
        return true;
    }
    public void run() {
        try {
            out.writeUnshared(ConnectionClient.ListPlace);
            String read = null;
            boolean write;
            try {
                read = in.readUTF();
                System.out.println(read);
            } catch (IOException ex) {
                Logger.getLogger(ClientHendler.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[] str = read.split(":");
            int i = Integer.valueOf(str[0]);
            int j = Integer.valueOf(str[1]);
            boolean b = ifcatch(i, j);
            out.writeBoolean(b);
            //גורם שיהיה חובה להעביר את הכתיבה ללקוח
            out.flush();

        } catch (IOException ex) {
            Logger.getLogger(ClientHendler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

