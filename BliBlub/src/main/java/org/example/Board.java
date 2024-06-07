package org.example;

public class Board {
    classBoard {
        constructor() {
            this.cells = [
            [' ', ' ', ' '],
            [' ', ' ', ' '],
            [' ', ' ', ' ']
        ];
        }

        isCellEmpty(x, y) {
            returnthis.cells[x][y] === ' ';
        }

        place(x, y, marker) {
            if (this.isCellEmpty(x, y)) {
                this.cells[x][y] = marker;
            }
        }

        isFull() {
            returnthis.cells.flat().every(cell => cell !== ' ');
        }

        clear() {
            for (let i = 0; i < 3; i++) {
                for (let j = 0; j < 3; j++) {
                    this.cells[i][j] = ' ';
                }
            }
        }

        print() {
            console.log(this.cells.map(row => row.join('|')).join('\n'));
        }
    }
}
