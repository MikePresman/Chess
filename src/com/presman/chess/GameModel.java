package com.presman.chess;
import com.presman.chess.ChessPieceLogic.*;
import javafx.util.Pair;
import java.util.ArrayList;

enum Player {
    WHITE,
    BLACK
}


public class GameModel {
    public static boolean gameRunning = true;
    public static Player currentPlayer = Player.WHITE;

    public GameModel() {

    }


    public static ArrayList<Pair<Integer, Integer>> getPotentialMoveSpots(ChessPiece[][] chessBoard, int row, int tile) {
        ChessPiece selectedPiece = chessBoard[row][tile];
        ArrayList<Pair<Integer, Integer>> potentialMoveSpots = new ArrayList<>();

        //Pawn
        if (selectedPiece == ChessPiece.WHITE_PAWN || selectedPiece == ChessPiece.BLACK_PAWN) {
            PawnModel pawnMovement = new PawnModel();
            pawnMovement.verticalMovement(potentialMoveSpots, selectedPiece, row, tile);
            pawnMovement.uniqueMovement(potentialMoveSpots, selectedPiece, row, tile);
        }

        //Rook
        if (selectedPiece == ChessPiece.BLACK_ROOK || selectedPiece == ChessPiece.WHITE_ROOK) {
            RookModel rookMovement = new RookModel();
            rookMovement.verticalMovement(potentialMoveSpots, selectedPiece, row, tile);
            rookMovement.horizontalMovement(potentialMoveSpots, selectedPiece, row, tile);
        }

        //Knight
        if (selectedPiece == ChessPiece.BLACK_KNIGHT || selectedPiece == ChessPiece.WHITE_KNIGHT) {
            KnightModel knightMovement = new KnightModel();
            knightMovement.uniqueMovement(potentialMoveSpots, selectedPiece, row, tile);
        }

        //Bishop
        if (selectedPiece == ChessPiece.BLACK_BISHOP || selectedPiece == ChessPiece.WHITE_BISHOP){
            BishopModel bishopMovement = new BishopModel();
            bishopMovement.diagonalMovement(potentialMoveSpots, selectedPiece, row, tile);
        }

        //King
        if (selectedPiece == ChessPiece.BLACK_KING || selectedPiece == ChessPiece.WHITE_KING) {
            KingModel kingMovement = new KingModel();
            kingMovement.diagonalMovement(potentialMoveSpots, selectedPiece, row, tile);
            kingMovement.horizontalMovement(potentialMoveSpots, selectedPiece, row, tile);
            kingMovement.verticalMovement(potentialMoveSpots, selectedPiece, row, tile);
        }

        //Queen
        if (selectedPiece == ChessPiece.BLACK_QUEEN || selectedPiece == ChessPiece.WHITE_QUEEN) {
            QueenModel queenMovement = new QueenModel();
            queenMovement.diagonalMovement(potentialMoveSpots, selectedPiece, row, tile);
            queenMovement.horizontalMovement(potentialMoveSpots, selectedPiece, row, tile);
            queenMovement.verticalMovement(potentialMoveSpots, selectedPiece, row, tile);
        }


        return potentialMoveSpots;
    }

}


