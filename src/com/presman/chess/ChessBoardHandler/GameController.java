package com.presman.chess.ChessBoardHandler;

import com.presman.chess.ChessBoardHandler.Player;
import javafx.scene.layout.Pane;


import javafx.scene.input.MouseEvent;
import javafx.util.Pair;


public class GameController {
    private ChessBoardModel board;
    public GameController() {

    } //necessary for sample.fxml - leave it alone


    public GameController(Pane canvas) {
        this.board = new ChessBoardModel(canvas); //this will draw the board
        this.board.drawPiecesOnBoard(); //draw initial pieces
    }


    public void handleEvent(MouseEvent m) {
        if (!GameModel.gameRunning) {
            return;
        }

        //Moving Piece Check
        int tileClickedIndex = (int) (Math.floor(m.getX() / 75));
        int rowClickedIndex = (int) (Math.floor(m.getY() / 75));
        System.out.println("CLICKED PIECE");
        System.out.println(tileClickedIndex);
        System.out.println(rowClickedIndex);

        if (this.board.potentialMoveSpots != null) {
            System.out.println("POTENTIAL MOVE SPOTS");
            for (Pair<Integer, Integer> e : this.board.potentialMoveSpots) {
                System.out.println(e.getKey());
                System.out.println(e.getValue());
                int potentialRowIndex = e.getKey(); //row
                int potentialTileIndex = e.getValue();
                if (potentialRowIndex == rowClickedIndex && potentialTileIndex == tileClickedIndex && this.board.pieceSelected) {
                    handleMovingPiece(rowClickedIndex, tileClickedIndex);
                    return;
                }
            }
        }
        if (!isClickableSpot(rowClickedIndex, tileClickedIndex))
            return;
        this.board.getSelectedPiece(m);

    }



    public boolean isClickableSpot(int ySpaceClickedForArrayIndex, int xSpaceClickedForArrayIndex){
        //If spot clickable check
        if (ChessBoardModel.isEmptyTile(ySpaceClickedForArrayIndex, xSpaceClickedForArrayIndex)) {
            return false;
        }
        if (GameModel.currentPlayer == Player.BLACK && ChessBoardModel.isWhitePiece(ySpaceClickedForArrayIndex, xSpaceClickedForArrayIndex)) {
            return false;
        } else if (GameModel.currentPlayer == Player.WHITE && ChessBoardModel.isBlackPiece(ySpaceClickedForArrayIndex, xSpaceClickedForArrayIndex)) {
            return false;
        }
        return true;
    }





    public void handleMovingPiece(int ySpaceClickedForArrayIndex, int xSpaceClickedForArrayIndex) {
        for (int i = 0; i < this.board.potentialMoveSpots.size(); i++) {
            if (this.board.potentialMoveSpots.get(i).getKey() == ySpaceClickedForArrayIndex && this.board.potentialMoveSpots.get(i).getValue() == xSpaceClickedForArrayIndex) {
                ChessBoardModel.getChessBoard()[ySpaceClickedForArrayIndex][xSpaceClickedForArrayIndex] = ChessBoardModel.getChessBoard()[this.board.chessPieceRowIndex][this.board.chessPieceTileIndex];
                ChessBoardModel.getChessBoard()[this.board.chessPieceRowIndex][this.board.chessPieceTileIndex] = ChessPiece.NONE;
                this.board.pieceSelected = false;
                this.board.drawBoard(this.board.getCanvas());
                this.board.redrawPieces();
                GameModel.currentPlayer = GameModel.currentPlayer == Player.WHITE ? Player.BLACK : Player.WHITE;
                return;
            } else {
                continue;
            }

        }

    }
}
