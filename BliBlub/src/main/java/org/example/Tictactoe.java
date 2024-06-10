package org.example;

import java.util.Scanner;

public class Tictactoe {
    Player player1;
    Player player2;
    Player currentPlayer;
    Board board;

    public Tictactoe() {
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.currentPlayer = this.player1;
        this.board = new Board();
    }

    public void start() {
        System.out.println("The game has started!");
        this.board.clear(); // Ensures the board is clear before starting

        hasWinner();
    }

    public void switchCurrentPlayer() {
        this.currentPlayer = (this.currentPlayer == this.player1) ? this.player2 : this.player1;

    }

        public boolean hasWinner() {
            Scanner scanner = new Scanner(System.in);
            boolean winner = false;


            while (!board.isFull() && !winner){
                this.board.print();
                System.out.println("Current player: " + this.currentPlayer.getMarker());

                int row,  col;
                while (true){
                    System.out.print("Enter row (0, 1, 2):");
                    row = scanner.nextInt();
                    System.out.print("Enter col (0, 1, 2):");
                    col = scanner.nextInt();

                    if (row >= 0 && row < 3 && col >= 0 && col < 3 && board.isCellEmpty(row, col)){
                        break;
                    }
                    else{
                        System.out.println("Invalid input! Please try again.");
                    }
                }

                board.place(row, col, currentPlayer.getMarker());

                if (board.checkWin(currentPlayer.getMarker())){
                    winner = true;
                    this.board.print();
                    System.out.println("Player " + this.currentPlayer.getMarker() + " won!");
                }
                else{
                    switchCurrentPlayer();
                }
            }
            if (!winner){
                System.out.println("Wow...it's a draw!");
            }

            scanner.close();

            return false; // Placeholder
        }
}