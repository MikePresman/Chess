package com.presman.chess.ChessPieceLogic;


import java.util.Iterator;
import java.util.NoSuchElementException;


public class ChessPositionSet implements Iterable<Node> {
    private Node header;
    private Node trailer;
    private int size;

    public ChessPositionSet(){
        this.header = new Node(-1, -1);
        this.trailer = new Node(-1, -1);

        this.header.setNext(this.trailer);
        this.trailer.setPrevious(this.header);
        size = 0;
    }

    public void add(int row, int tile){
        Node newPair = new Node(row, tile);
        this.trailer.getPrevious().setNext(newPair);
        this.trailer.setPrevious(newPair);
        newPair.setNext(this.trailer);
        size++;
    }

    public Node get(int i){
        int j = 0;
        Node temp = this.header.getNext();
        while (j < i){
            temp = temp.getNext();
            j++;
        }
        return temp;
    }

    public int size(){
        return size;
    }

    @Override
    public Iterator<Node> iterator() {
        return new ChessIterator();
    }

    private class ChessIterator implements Iterator<Node>{
        private int i = 0;
        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public Node next() {
            if (i == size) throw new NoSuchElementException("No next element");
            return get(i++);
        }
    }
}
