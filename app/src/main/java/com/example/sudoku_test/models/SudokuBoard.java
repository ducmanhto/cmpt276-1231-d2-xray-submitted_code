package com.example.sudoku_test.models;

public class SudokuBoard {

    public static int boardDimensionX;
    public static int boardDimensionY;

    private Cell[][] cellArray;
    public int hintCount = 3;
    private Cell selectedCell = null;

    public SudokuBoard(int boardDimensionX, int boardDimensionY) {
        this.boardDimensionX = boardDimensionX;
        this.boardDimensionY = boardDimensionY;

        cellArray = new Cell[boardDimensionX][boardDimensionY];
    }

    public boolean hintAvailable() {
        return true ? hintCount > 0 : false;
    }

    public void appendCell(Cell cell) {
        this.cellArray[cell.coordinateX][cell.coordinateY] = cell;
    }

    public Cell getSelectedCell() {
        return selectedCell;
    }

    public void setSelectedCell(Cell cell) {
        int row = cell.coordinateX;
        int col = cell.coordinateY;
        boolean rowInBounds = row >= 0 && row < boardDimensionX;
        boolean columnInBounds = col >= 0 && col < boardDimensionY;

        if (rowInBounds && columnInBounds)
            this.selectedCell = cellArray[row][col];
    }

    public void clearSelectedCell() {
        this.selectedCell = null;
    }

    public boolean validateBoard(String[][] solution) {
        for (int row = 0; row < boardDimensionX; row++) {
            for (int col = 0; col < boardDimensionY; col++) {
                Cell cell = cellArray[row][col];
                String word = cell.getWord();

                if (word.equals("?") || !word.equals(solution[row][col])) {
                    return false;
                }
            }
        }
        return true;
    }

}
