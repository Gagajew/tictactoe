package org.example;

public class Tictactoe {
    Player player1;
    Player player2;
    Player currentPlayer;
    Board board;

        void constructor() {
            this.player1 = new Player('X');
            this.player2 = new Player('O');
            this.currentPlayer = this.player1;
            this.board = new Board();
        }

        void start() {
            this.board.clear(); // Ensures the board is clear before starting
            // Game loop can be implemented here
        }

        void switchCurrentPlayer() {
            this.currentPlayer = this.currentPlayer == this.player1 ? this.player2 : this.player1;
        }

        boolean hasWinner() {
            // This method should be implemented to check for a winner
            return false; // Placeholder
        }
}