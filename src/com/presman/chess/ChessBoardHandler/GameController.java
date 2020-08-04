package com.presman.chess.ChessBoardHandler;

import com.presman.chess.ChessBoardHandler.Player;
import com.presman.chess.ChessPieceLogic.Node;
import com.presman.chess.Main;
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

        if (Main.singlePlayer){
            GameModel.currentPlayer = Player.WHITE;
        }else{
            GameModel.currentPlayer = Main.server != null ? Player.WHITE : Player.BLACK;
        }

        if (GameModel.currentPlayer == Player.WHITE) GameModel.playerHasControl = true;

    }


    public void handleEvent(MouseEvent m) {
        if (!GameModel.gameRunning) {
            return;
        }

        if (!GameModel.playerHasControl) return;

        //Moving Piece Check
        int tileClickedIndex = (int) (Math.floor(m.getX() / 75));
        int rowClickedIndex = (int) (Math.floor(m.getY() / 75));

        if (this.board.potentialMoveSpots != null) {
            for (Node e : this.board.potentialMoveSpots) {
                int potentialRowIndex = e.getRow(); //row
                int potentialTileIndex = e.getTile();
                if (potentialRowIndex == rowClickedIndex && potentialTileIndex == tileClickedIndex && this.board.pieceSelected) {
                    handleMovingPiece(rowClickedIndex, tileClickedIndex);

                    //tell other player that has been moved
                    if (!Main.singlePlayer){

                    }


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
            if (this.board.potentialMoveSpots.get(i).getRow() == ySpaceClickedForArrayIndex && this.board.potentialMoveSpots.get(i).getTile() == xSpaceClickedForArrayIndex) {
                ChessBoardModel.getChessBoard()[ySpaceClickedForArrayIndex][xSpaceClickedForArrayIndex] = ChessBoardModel.getChessBoard()[this.board.chessPieceRowIndex][this.board.chessPieceTileIndex];
                ChessBoardModel.getChessBoard()[this.board.chessPieceRowIndex][this.board.chessPieceTileIndex] = ChessPiece.NONE;
                this.board.pieceSelected = false;
                this.board.drawBoard(this.board.getCanvas());
                this.board.redrawPieces();

                if (Main.singlePlayer)
                    GameModel.currentPlayer = GameModel.currentPlayer == Player.WHITE ? Player.BLACK : Player.WHITE;
                return;
            } else {
                continue;
            }

        }

    }
}
