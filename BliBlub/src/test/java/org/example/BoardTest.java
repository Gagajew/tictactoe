package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
        board.clear(); // Sicherstellen, dass das Board leer ist
    }

    @Test
    void isCellEmpty() {
        assertTrue(board.isCellEmpty(0, 0));
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    void isCellEmpty1() {
        assertTrue(board.isCellEmpty(2, 2));
        board.place(2, 2, 'O');
        assertFalse(board.isCellEmpty(2, 2));
    }

    @Test
    void place() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    void place1() {
        board.place(1, 1, 'O');
        assertFalse(board.isCellEmpty(1, 1));
    }

    @Test
    void isFull() {
        assertFalse(board.isFull());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    void isFull1() {
        assertFalse(board.isFull());
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');
        assertFalse(board.isFull());
    }

    @Test
    void clear() {
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void clear1() {
        board.place(1, 1, 'O');
        board.place(2, 2, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(1, 1));
        assertTrue(board.isCellEmpty(2, 2));
    }

    @Test
    void print() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            board.print();
            String expectedOutput =
                    "-------\n" +
                            "| | | |\n" +
                            "| | | |\n" +
                            "| | | |\n" +
                            "-------\n";

            assertEquals(expectedOutput, outContent.toString().replace("\r", ""));
        } finally {
            System.setOut(originalOut); // Reset to the standard output
        }
    }

    @Test
    void print1() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        board.place(2, 2, 'X');

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            board.print();
            String expectedOutput =
                    "-------\n" +
                            "|X| | |\n" +
                            "| |O| |\n" +
                            "| | |X|\n" +
                            "-------\n";

            assertEquals(expectedOutput, outContent.toString().replace("\r", ""));
        } finally {
            System.setOut(originalOut); // Reset to the standard output
        }
    }

    @Test
    void checkWin() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');
        assertTrue(board.checkWin('X'));
    }

    @Test
    void checkWin1() {
        board.place(0, 2, 'O');
        board.place(1, 1, 'O');
        board.place(2, 0, 'O');
        assertTrue(board.checkWin('O'));
    }
}
