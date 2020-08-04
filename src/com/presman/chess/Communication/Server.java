package com.presman.chess.Communication;

import com.presman.chess.Main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    private ServerSocket server;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inStream;

    private Socket client;


    public Server(){
        try{
            server = new ServerSocket(Integer.parseInt(Main.configProperties.get("HOST_PORT")));

            while (true){
                client = server.accept();
                System.out.println("Connection Received");
                outputStream = new ObjectOutputStream(client.getOutputStream());
                inStream = new ObjectInputStream(client.getInputStream());
                if (client != null) break;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
