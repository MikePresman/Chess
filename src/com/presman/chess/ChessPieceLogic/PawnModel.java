package com.presman.chess.ChessPieceLogic;

import com.presman.chess.ChessBoardHandler.ChessBoardModel;
import com.presman.chess.ChessBoardHandler.ChessPiece;
import javafx.util.Pair;

import java.util.ArrayList;

public class PawnModel {


    public void verticalMovement(ChessPositionSet potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {
        //HANDLING MOVEMENT UP THE BOARD - NEED TO HANDLE SPECIAL MOVEMENT BACKWARDS WHEN KINGED? IDK READ ABOUT IT
        if (selectedPiece == ChessPiece.BLACK_PAWN && row + 1 <= 7 && ChessBoardModel.isEmptyTile(row+1, tile)) {
            potentialMoveSpots.add(row+1, tile);
        }
        if (selectedPiece == ChessPiece.WHITE_PAWN && row - 1 >= 0  && ChessBoardModel.isEmptyTile(row-1, tile)){
            potentialMoveSpots.add(row -1, tile);
        }


        //HANDLING POTENTIAL ATTACK
        if (selectedPiece == ChessPiece.BLACK_PAWN && row + 1 <= 7 && tile + 1 <= 7 && ChessBoardModel.isWhitePiece(row + 1, tile + 1)) {
            potentialMoveSpots.add(row +1, tile + 1);
        }
        if (selectedPiece == ChessPiece.BLACK_PAWN && row + 1 <= 7 && tile - 1 >= 0 && ChessBoardModel.isWhitePiece(row+1, tile - 1)) {
            potentialMoveSpots.add(row + 1, tile - 1);
        }
        if (selectedPiece == ChessPiece.WHITE_PAWN && row - 1 >= 0 && tile + 1 <= 7 && ChessBoardModel.isBlackPiece(row -1, tile + 1)) {
            potentialMoveSpots.add(row - 1, tile + 1);
        }
        if (selectedPiece == ChessPiece.WHITE_PAWN && row - 1 >= 0 && tile - 1 >= 0 && ChessBoardModel.isBlackPiece(row - 1, tile - 1)) {
            potentialMoveSpots.add(row - 1, tile - 1);
        }
    }




    public void uniqueMovement(ChessPositionSet potentialMoveSpots, ChessPiece selectedPiece, int row, int tile) {
        if (selectedPiece == ChessPiece.BLACK_PAWN && row + 2 <= 7 && ChessBoardModel.isEmptyTile(row+2,tile) && ChessBoardModel.isEmptyTile(row+1, tile) && row == 1) {
            potentialMoveSpots.add(row + 2, tile);
        }

        if (selectedPiece == ChessPiece.WHITE_PAWN && row - 2 >= 0 && ChessBoardModel.isEmptyTile(row-2, tile)  && ChessBoardModel.isEmptyTile(row - 1, tile) && row == 6) {
            potentialMoveSpots.add(row - 2, tile);
        }

    }
}
