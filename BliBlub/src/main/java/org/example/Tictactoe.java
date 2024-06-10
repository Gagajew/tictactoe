package org.example;

import java.util.Scanner;

public class Tictactoe { //public Methode Tictactoe
    Player player1; //Variable player1 vom Typ Player
    Player player2; //Variable player2 vom Typ Player
    Player currentPlayer; //Variable currentPlayer vom Typ Player
    Board board; //Variable board vom Typ Board

    public Tictactoe() { //public Konstruktor Tictactoe
        this.player1 = new Player('X'); //marker X für player1 zugewiesen
        this.player2 = new Player('O'); //marker O für player2 zugewiesen
        this.currentPlayer = this.player1; //erster Spieler ist player1
        this.board = new Board(); //dem Board wird die Methode Board() zugewiesen
    }

    public void start() {
        System.out.println("The game has started!");
        this.board.clear(); // Das Board ist leer beim Spielstart

        hasWinner(); //Methode wird bei Start aufgerufen
    }

    public void switchCurrentPlayer() {
        this.currentPlayer = (this.currentPlayer == this.player1) ? this.player2 : this.player1;
        //Die Spieler werden gewechselt

    }

        public void hasWinner() { //Methode zur Überprüfung, ob es einen Gewinner gibt und wer gewonnen hat
            Scanner scanner = new Scanner(System.in);
            boolean winner = false;


            while (!board.isFull() && !winner){ //während das Board leer ist und es keinen Gewinner gibt
                this.board.print(); //wird das Board dargestellt
                System.out.println("Current player: " + this.currentPlayer.getMarker()); //der Spieler, der an der Reihe ist, wird angezeigt

                int row,  col; //Spalte und Reihe definiert als Integer
                while (true){
                    System.out.print("Enter row (0, 1, 2):"); //Ausgabe des Textes in der Klammer
                    row = scanner.nextInt(); //Eingabe der Reihe
                    System.out.print("Enter col (0, 1, 2):");
                    col = scanner.nextInt(); //Eingabe der Zeile

                    if (row >= 0 && row < 3 && col >= 0 && col < 3 && board.isCellEmpty(row, col)){ //wenn der eingegebene Wert innerhalb der Matrix liegt und das Feld leer ist
                        break; //wird die Schleife aufgehalten
                    }
                    else{
                        System.out.println("Invalid input! Please try again."); //sonst kommt die Meldung
                    }
                }

                board.place(row, col, currentPlayer.getMarker()); //marker wird entsprechend gesetzt

                if (board.checkWin(currentPlayer.getMarker())){ //wenn der gesetzte Marker richtig gesetzt wurde und einen Gewinner markiert
                    winner = true; //wird ein Gewinner bestimmt
                    this.board.print(); //das Board wird noch dargestellt
                    System.out.println("Player " + this.currentPlayer.getMarker() + " won!"); //Gewinner wird angezeigt
                }
                else{
                    switchCurrentPlayer(); //sonst wird der Spieler gewechselt
                }
            }
            if (!winner){ //wenn es keinen Gewinner gibt
                System.out.println("Wow...it's a draw!");
            }

            scanner.close();

        }
}