package com.presman.chess;

import javafx.scene.layout.Pane;


import javafx.scene.input.MouseEvent;


public class GameController {
    private ChessBoardModel board;


    public GameController(){

    } //necessary for sample.fxml - leave it alone


    //REPLACE ALL INSTANCES OF CHESSBOARDMODEL[][] WITH IS WHITE PIECE, BLACK PIECE ETC.

    public GameController(Pane canvas){
         this.board = new ChessBoardModel(canvas); //this will draw the board
         this.board.drawPiecesOnBoard(); //draw initial pieces
    }



    public void handleEvent(MouseEvent m){
        this.board.getSelectedPiece(m);
    }




}
