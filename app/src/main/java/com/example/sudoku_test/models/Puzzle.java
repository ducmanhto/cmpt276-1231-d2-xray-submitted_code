package com.example.sudoku_test.models;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

/*
    Puzzle Class:
        Primarily used to initialize the game board
        Stores the puzzle template as a 2D-array
        Generates variations of the puzzle by shuffling rows and columns
 */

public class Puzzle {

    private final int VOCAB_ARRAY_WIDTH = 2;

    private String[][] puzzleArray;
    private String[][] solutionArray;
    private String[][] vocabArray;
    private String[][] mappedSolutionArray;

    private int puzzleDimensionX;
    private int puzzleDimensionY;

    public Puzzle(
            String[][] puzzleArray,
            String[][] solutionArray,
            String[][] vocabArray,
            int puzzleDimensionX,
            int puzzleDimensionY
    ) {
        this.puzzleDimensionX = puzzleDimensionX;
        this.puzzleDimensionY = puzzleDimensionY;
        this.puzzleArray = puzzleArray;
        this.solutionArray = solutionArray;
        this.vocabArray = vocabArray;

        mapSolution();
    }

    public String getWord(int coordinateX, int coordinateY) {
        String map = puzzleArray[coordinateX][coordinateY];

        if (map.equals("?")) {
            return map;
        }

        return vocabArray[Integer.parseInt(map) - 1][VOCAB_ARRAY_WIDTH - 1];
    }

    /*
        Returns the mapped solution
        Not the raw solution template
     */
    public String[][] getMappedSolution() {
        return mappedSolutionArray;
    }

    public String[][] getVocabArray() {
        return vocabArray;
    }

    public String getTranslation(String word) {
        for (int i = 0; i < vocabArray.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (vocabArray[i][j].equals(word)) {
                    if (j == 0)
                        return vocabArray[i][j+1];
                    else
                        return vocabArray[i][j-1];
                }
            }
        }
        return " ";
    }

    public void shuffleBoard(int row, int col) {
        if (row + col < 15 && row + col >= 0) {
            swapRows(puzzleArray, row);
            swapRows(solutionArray, row);
            swapRows(mappedSolutionArray, row);

            swapColumns(puzzleArray, col);
            swapColumns(solutionArray, col);
            swapColumns(mappedSolutionArray, col);
        }
    }

    private void mapSolution() {
        mappedSolutionArray = new String[puzzleDimensionX][puzzleDimensionY];

        for (int row = 0; row < puzzleDimensionX; row++) {
            for (int col = 0; col < puzzleDimensionY; col++) {
                int map = Integer.parseInt(solutionArray[row][col]);
                mappedSolutionArray[row][col] = vocabArray[map - 1][1];
            }
        }
    }

    private void swapRows(String[][] array, int rowIndex) {
        for (int i = 0; i < puzzleDimensionX; i++) {
            String tmp = array[rowIndex][i];
            array[rowIndex][i] = array[rowIndex + 1][i];
            array[rowIndex + 1][i] = tmp;

        }
    }

    private void swapColumns(String[][] array, int columnIndex) {
        for (int i = 0; i < puzzleDimensionY; i++) {
            String tmp = array[i][columnIndex];
            array[i][columnIndex] = array[i][columnIndex + 1];
            array[i][columnIndex + 1] = tmp;
        }
    }
}
