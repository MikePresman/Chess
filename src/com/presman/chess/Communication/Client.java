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

    public ChessBoardModel chessModel;

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
        try {
            while (true) {
                Packet recv = (Packet) objIn.readObject();
                if (recv.message.equals("Board")) {
                    ChessBoardModel.chessBoardLayout = (ChessPiece[][]) recv.obj;
                    Platform.runLater(() -> {
                        this.chessModel.redrawPieces();
                    });
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendBoard(ChessPiece[][] board){
        try {
            Packet<ChessPiece[][]> send = new Packet("Board", ChessBoardModel.getChessBoard());
            this.objOut.writeObject(send);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

