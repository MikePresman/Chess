package com.presman.chess.Communication;

import com.presman.chess.Main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private final String IP = Main.configProperties.get("HOST_IP");
    private final int PORT = Integer.parseInt(Main.configProperties.get("HOST_PORT"));
    private Socket s;
    private ObjectOutputStream objOut;
    private ObjectInputStream objIn;

    public Client(){
        try {
            s = new Socket(IP, PORT);
            objOut = new ObjectOutputStream(s.getOutputStream());
            objIn = new ObjectInputStream(s.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
