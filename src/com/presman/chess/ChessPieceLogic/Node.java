package com.presman.chess.ChessPieceLogic;

public class Node{
    private int row;
    private int tile;

    private Node next;
    private Node previous;

    public Node(int row, int tile){
        this.row = row;
        this.tile = tile;
    }

    public void setNext(Node n){
        this.next = n;
    }

    public void setPrevious(Node n){
        this.previous = n;
    }

    public int getRow(){return this.row;}
    public int getTile(){return this.tile;}
    public Node getNext(){return this.next;}
    public Node getPrevious(){return this.previous;}
}
