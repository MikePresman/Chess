package com.presman.chess;

public interface ChessPieceMovement {

    public void horizontalMovement();

    public void verticalMovement();

    public void diagonalMovement();

}

interface UniqueChessPieceMovement extends ChessPieceMovement{
    public void uniqueMovement();
}
