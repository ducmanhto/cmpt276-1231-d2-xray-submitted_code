package com.example.sudoku_test.models;

import static org.junit.Assert.*;

import org.junit.Test;

import java.lang.reflect.Field;

public class SudokuBoardTest {

    @Test
    public void hintAvailable() {
        SudokuBoard board = new SudokuBoard(9, 9);

        assertEquals(true, board.hintAvailable());

        board.hintCount = 2;

        assertEquals(true, board.hintAvailable());

        board.hintCount = 0;

        assertEquals(false, board.hintAvailable());

        board.hintCount = -1;

        assertEquals(false, board.hintAvailable());
    }

    @Test
    public void appendCell() {
        SudokuBoard board = new SudokuBoard(9, 9);
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(8, 8);
        Cell cell3 = new Cell(4, 5);


        board.appendCell(cell1);
        board.appendCell(cell2);
        board.appendCell(cell3);

        try {
            final Field field = board.getClass().getDeclaredField("cellArray");
            field.setAccessible(true);
            try {
                Cell[][] cellArray = (Cell[][]) field.get(board);
                assertEquals(cell1, cellArray[0][0]);
                assertEquals(cell2, cellArray[8][8]);
                assertEquals(cell3, cellArray[4][5]);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getSelectedCell() {
        SudokuBoard board = new SudokuBoard(9, 9);
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(8, 8);

        assertEquals(null, board.getSelectedCell());

        try {
            final Field selectedCellField = board.getClass().getDeclaredField("selectedCell");
            selectedCellField.setAccessible(true);

            try {
                selectedCellField.set(board, cell1);
                assertEquals(cell1, board.getSelectedCell());

                selectedCellField.set(board, cell2);
                assertEquals(cell2, board.getSelectedCell());

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setSelectedCell() {
        SudokuBoard board = new SudokuBoard(9, 9);
        Cell cell = new Cell(0, 0);

        try {
            final Field selectedCellField = board.getClass().getDeclaredField("selectedCell");
            selectedCellField.setAccessible(true);

            try {
                board.appendCell(cell);
                board.setSelectedCell(cell);
                assertEquals(cell, (Cell) selectedCellField.get(board));

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void clearSelectedCell() {
        SudokuBoard board = new SudokuBoard(9, 9);
        Cell cell = new Cell(0, 0);

        try {
            final Field selectedCellField = board.getClass().getDeclaredField("selectedCell");
            selectedCellField.setAccessible(true);

            try {
                board.appendCell(cell);
                board.setSelectedCell(cell);
                selectedCellField.set(board, cell);

                board.clearSelectedCell();
                assertEquals(null, selectedCellField.get(board));

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void validateBoard() {
        SudokuBoard board = new SudokuBoard(9, 9);

        String[][] validSolution = {
                {"Mangue", "Cerise", "Poire", "Raisin", "Banane", "Pomme", "Citron", "Orange", "Tomate"},
                {"Citron", "Tomate", "Pomme", "Cerise", "Poire", "Orange", "Mangue", "Raisin", "Banane"},
                {"Banane", "Orange", "Raisin", "Mangue", "Tomate", "Citron", "Cerise", "Pomme", "Poire"},
                {"Poire", "Mangue", "Orange", "Tomate", "Raisin", "Cerise", "Pomme", "Banane", "Citron"},
                {"Cerise", "Pomme", "Citron", "Banane", "Orange", "Mangue", "Tomate", "Poire", "Raisin"},
                {"Raisin", "Banane", "Tomate", "Pomme", "Citron", "Poire", "Orange", "Mangue", "Cerise"},
                {"Tomate", "Raisin", "Cerise", "Orange", "Pomme", "Banane", "Poire", "Citron", "Mangue"},
                {"Pomme", "Poire", "Mangue", "Citron", "Cerise", "Raisin", "Banane", "Tomate", "Orange"},
                {"Orange", "Citron", "Banane", "Poire", "Mangue", "Tomate", "Raisin", "Cerise", "Pomme"},
        };

        String[][] incorrectSolution = {
                {"Mangue", "Cerise", "Poire", "Raisin", "Banane", "Pomme", "Citron", "Orange", "Tomate"},
                {"Citron", "Tomate", "Pomme", "Cerise", "Poire", "Orange", "Mangue", "Raisin", "Banane"},
                {"Banane", "Orange", "Raisin", "Mangue", "Tomate", "Citron", "Cerise", "Pomme", "Poire"},
                {"Poire", "Mangue", "Orange", "Tomate", "Raisin", "Cerise", "Pomme", "Banane", "Citron"},
                {"Cerise", "Pomme", "Citron", "Banane", "Mangue", "Orange", "Tomate", "Poire", "Raisin"},
                {"Raisin", "Banane", "Tomate", "Pomme", "Citron", "Poire", "Orange", "Mangue", "Cerise"},
                {"Tomate", "Raisin", "Cerise", "Orange", "Pomme", "Banane", "Poire", "Citron", "Mangue"},
                {"Pomme", "Poire", "Mangue", "Citron", "Cerise", "Raisin", "Banane", "Tomate", "Orange"},
                {"Orange", "Citron", "Banane", "Poire", "Mangue", "Tomate", "Raisin", "Cerise", "Pomme"},
        };

        String[][] incompleteSolution = {
                {"Mangue", "Cerise", "Poire", "Raisin", "Banane", "Pomme", "Citron", "Orange", "Tomate"},
                {"Citron", "Tomate", "?", "Cerise", "Poire", "Orange", "Mangue", "Raisin", "Banane"},
                {"Banane", "Orange", "Raisin", "Mangue", "Tomate", "Citron", "Cerise", "Pomme", "Poire"},
                {"Poire", "Mangue", "Orange", "Tomate", "Raisin", "Cerise", "?", "Banane", "Citron"},
                {"Cerise", "Pomme", "Citron", "Banane", "Mangue", "Orange", "Tomate", "Poire", "Raisin"},
                {"Raisin", "Banane", "Tomate", "Pomme", "Citron", "Poire", "?", "Mangue", "Cerise"},
                {"Tomate", "Raisin", "Cerise", "?", "Pomme", "Banane", "Poire", "Citron", "Mangue"},
                {"Pomme", "Poire", "Mangue", "Citron", "Cerise", "Raisin", "Banane", "Tomate", "?"},
                {"Orange", "Citron", "Banane", "Poire", "Mangue", "Tomate", "Raisin", "Cerise", "Pomme"},
        };

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Cell cell = new Cell(i,j);
                cell.setWord(validSolution[i][j]);
                board.appendCell(cell);
            }
        }

        assertEquals(true, board.validateBoard(validSolution));
        assertEquals(false, board.validateBoard(incorrectSolution));
        assertEquals(false, board.validateBoard(incompleteSolution));
    }
}