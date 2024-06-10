package org.example;

public class Player {
    private final char marker; //marker definiert

    public Player(char marker) {
        this.marker = marker; //der Player bekommt einen Marker zugewiesen
    }

    public char getMarker() {
        return marker; //marker wird ausgegeben
    }
}
