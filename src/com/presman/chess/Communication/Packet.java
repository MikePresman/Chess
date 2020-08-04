package com.presman.chess.Communication;

import java.io.Serializable;

public class Packet<T> implements Serializable {
    private String message;
    private T obj;

    public Packet(String message, T obj){
        this.message = message;
        this.obj = obj;
    }
}
