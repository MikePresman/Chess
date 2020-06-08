package com.presman.chess.ChessPieceLogic;

import com.presman.chess.ChessPiece;
import javafx.util.Pair;

import java.util.ArrayList;

public interface UniqueMovement {
    public void uniqueMovement(ArrayList<Pair<Integer, Integer>> potentialMoveSpots, ChessPiece selectedPiece, int row, int tile);
}
