package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 */
public class ConnectionClient {

    private ServerSocket server;

    static List<Place> ListPlace = new ArrayList<>(30);

    public ConnectionClient() {
        try {
            initializationPlace();
            ServerSocket server = new ServerSocket(1728);
            //לולאה שמחכה שלקוחות יצרו קשר עם השרת
            while (true) {
                Socket conection = server.accept();
                //מחלקה מקבילית כדי לא לחסום את השרת
                ClientHendler ch = new ClientHendler(conection);


            }
        } catch (IOException e) {
            System.out.println("server shut doun with eror:" + e);
        }



    }

    public  void initializationPlace(){

        for ( int i= 0; i < 5; i++) {
            for ( int j  = 0; j < 6; j++) {
                Place p = new Place(i,j,false);
                ListPlace.add(p);

            }

        }


    }

    public static void main(String[] args) {

        new ConnectionClient();

    }

}

