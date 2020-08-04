package com.presman.chess.Communication;

import com.presman.chess.ChessBoardHandler.ChessBoardModel;
import com.presman.chess.ChessBoardHandler.ChessPiece;
import com.presman.chess.Main;
import javafx.application.Platform;

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

    private ChessBoardModel chessModel;

    public Client() {
        try {
            s = new Socket(IP, PORT);
            objOut = new ObjectOutputStream(s.getOutputStream());
            objIn = new ObjectInputStream(s.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setChessModel(ChessBoardModel c) {
        this.chessModel = c;
    }

    public void getMove() {
        System.out.println("am i herEE??E?");
        try {
            while (true) {
                Packet recv = (Packet) objIn.readObject();
                System.out.println(recv.message);
                if (recv.message.equals("Board")) {
                    System.out.println("RECIEVED");
                    ChessBoardModel.chessBoardLayout = (ChessPiece[][]) recv.obj;
                    this.chessModel.redrawPieces();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

