package com.presman.chess.Communication;

import java.io.Serializable;

public class Packet<T> implements Serializable {
    public String message;
    public T obj;

    public Packet(String message, T obj){
        this.message = message;
        this.obj = obj;
    }
}
