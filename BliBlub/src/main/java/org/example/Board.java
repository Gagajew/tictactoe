package org.example;

public class Board {
    private char[][] cells;

    public Board() {
        this.cells = new char[3][3];
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        return this.cells[x][y] == ' ';
    }

    public void place(int x, int y, char marker) {
        if (isCellEmpty(x, y)) {
            this.cells[x][y] = marker;
        }
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public void print() {
        for (int i = 0; i < 3; i++) {
            System.out.println(cells[i][0] + "|" + cells[i][1] + "|" + cells[i][2]);
            if (i < 2) {
                System.out.println("-----");
            }
        }
    }

    public boolean checkWin(char marker) {
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == marker && cells[i][1] == marker && cells[i][2] == marker) {
                return true;
            }
            if (cells[0][i] == marker && cells[1][i] == marker && cells[2][i] == marker) {
                return true;
            }
        }
        if (cells[0][0] == marker && cells[1][1] == marker && cells[2][2] == marker) {
            return true;
        }
        if (cells[0][2] == marker && cells[1][1] == marker && cells[2][0] == marker) {
            return true;
        }
        return false;
    }
}
