package com.example.sudoku_test.models;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class PuzzleTest {

    private static final int rowLength = 9;
    private static final int columnLength = 9;

    private static String[][] puzzleArrayTemplate = {
            {"?", "7", "?", "?", "2", "?", "?", "4", "6"},
            {"?", "6", "?", "?", "?", "?", "8", "9", "?"},
            {"2", "?", "?", "8", "?", "?", "7", "1", "5"},
            {"?", "8", "4", "?", "9", "7", "?", "?", "?"},
            {"7", "1", "?", "?", "?", "?", "?", "5", "9"},
            {"?", "?", "?", "1", "3", "?", "4", "8", "?"},
            {"6", "9", "7", "?", "?", "2", "?", "?", "8"},
            {"?", "5", "8", "?", "?", "?", "?", "6", "?"},
            {"4", "3", "?", "?", "8", "?", "?", "7", "?"}
        };

    private static String[][] solutionArrayTemplate = {
            {"8", "7", "5", "9", "2", "1", "3", "4", "6"},
            {"3", "6", "1", "7", "5", "4", "8", "9", "2"},
            {"2", "4", "9", "8", "6", "3", "7", "1", "5"},
            {"5", "8", "4", "6", "9", "7", "1", "2", "3"},
            {"7", "1", "3", "2", "4", "8", "6", "5", "9"},
            {"9", "2", "6", "1", "3", "5", "4", "8", "7"},
            {"6", "9", "7", "4", "1", "2", "5", "3", "8"},
            {"1", "5", "8", "3", "7", "9", "2", "6", "4"},
            {"4", "3", "2", "5", "8", "6", "9", "7", "1"}
        };

    private static String[][] vocabArrayTemplate = {
            {"Apple", "Pomme"},
            {"Banana", "Banane"},
            {"Lemon", "Citron"},
            {"Orange", "Orange"},
            {"Pear", "Poire"},
            {"Tomato", "Tomate"},
            {"Cherry", "Cerise"},
            {"Mango", "Mangue"},
            {"Grape", "Raisin"}
        };

    @Test
    public void getWord() {

        String[][] expectedWord = {
                {"?", "Cerise", "?", "?", "Banane", "?", "?", "Orange", "Tomate"},
                {"?", "Tomate", "?", "?", "?", "?", "Mangue", "Raisin", "?"},
                {"Banane", "?", "?", "Mangue", "?", "?", "Cerise", "Pomme", "Poire"},
                {"?", "Mangue", "Orange", "?", "Raisin", "Cerise", "?", "?", "?"},
                {"Cerise", "Pomme", "?", "?", "?", "?", "?", "Poire", "Raisin"},
                {"?", "?", "?", "Pomme", "Citron", "?", "Orange", "Mangue", "?"},
                {"Tomate", "Raisin", "Cerise", "?", "?", "Banane", "?", "?", "Mangue"},
                {"?", "Poire", "Mangue", "?", "?", "?", "?", "Tomate", "?"},
                {"Orange", "Citron", "?", "?", "Mangue", "?", "?", "Cerise", "?"}
        };

        Puzzle puzzle = new Puzzle(
                puzzleArrayTemplate,
                solutionArrayTemplate,
                vocabArrayTemplate,
                rowLength,
                columnLength
                );

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                assertEquals(expectedWord[i][j], puzzle.getWord(i, j));
            }
        }
    }

    @Test
    public void getMappedSolution() {

        String[][] expectedSolution = {
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

        Puzzle puzzle = new Puzzle(
                puzzleArrayTemplate,
                solutionArrayTemplate,
                vocabArrayTemplate,
                rowLength,
                columnLength
        );

        assertArrayEquals(expectedSolution, puzzle.getMappedSolution());

    }

    @Test
    public void getVocabArray() {

        String[][] expectedList = {
                {"Apple", "Pomme"},
                {"Banana", "Banane"},
                {"Lemon", "Citron"},
                {"Orange", "Orange"},
                {"Pear", "Poire"},
                {"Tomato", "Tomate"},
                {"Cherry", "Cerise"},
                {"Mango", "Mangue"},
                {"Grape", "Raisin"}
        };

        Puzzle puzzle = new Puzzle(
                puzzleArrayTemplate,
                solutionArrayTemplate,
                vocabArrayTemplate,
                rowLength,
                columnLength
        );

        assertArrayEquals(expectedList, puzzle.getVocabArray());

    }

    @Test
    public void getTranslation() {

        String[][] vocabularyList = {
                {"Apple", "Pomme"},
                {"Banana", "Banane"},
                {"Lemon", "Citron"},
                {"Orange", "Orange"},
                {"Pear", "Poire"},
                {"Tomato", "Tomate"},
                {"Cherry", "Cerise"},
                {"Mango", "Mangue"},
                {"Grape", "Raisin"}
        };

        Puzzle puzzle = new Puzzle(
                puzzleArrayTemplate,
                solutionArrayTemplate,
                vocabArrayTemplate,
                rowLength,
                columnLength
        );

        // English to French
        for (int i = 0; i < vocabularyList.length; i++) {
            String word = vocabularyList[i][1];
            assertEquals(vocabularyList[i][0], puzzle.getTranslation(word));
        }

        // French to English
        for (int i = 0; i < vocabularyList.length; i++) {
            String word = vocabularyList[i][0];
            assertEquals(vocabularyList[i][1], puzzle.getTranslation(word));
        }

        // Non-existent word
        assertEquals(null, puzzle.getTranslation("Strawberry"));
    }

    @Test
    public void shuffleBoard() {

        Puzzle puzzle = new Puzzle(
                puzzleArrayTemplate,
                solutionArrayTemplate,
                vocabArrayTemplate,
                rowLength,
                columnLength
        );

        String[][] expectedSolution1 = {
                {"Mangue", "Cerise", "Poire", "Raisin", "Banane", "Pomme", "Citron", "Tomate", "Orange"},
                {"Citron", "Tomate", "Pomme", "Cerise", "Poire", "Orange", "Mangue", "Banane", "Raisin"},
                {"Poire", "Mangue", "Orange", "Tomate", "Raisin", "Cerise", "Pomme", "Citron", "Banane"},
                {"Banane", "Orange", "Raisin", "Mangue", "Tomate", "Citron", "Cerise", "Poire", "Pomme"},
                {"Cerise", "Pomme", "Citron", "Banane", "Orange", "Mangue", "Tomate", "Raisin", "Poire"},
                {"Raisin", "Banane", "Tomate", "Pomme", "Citron", "Poire", "Orange", "Cerise", "Mangue"},
                {"Tomate", "Raisin", "Cerise", "Orange", "Pomme", "Banane", "Poire", "Mangue", "Citron"},
                {"Pomme", "Poire", "Mangue", "Citron", "Cerise", "Raisin", "Banane", "Orange", "Tomate"},
                {"Orange", "Citron", "Banane", "Poire", "Mangue", "Tomate", "Raisin", "Pomme", "Cerise"},
        };


        puzzle.shuffleBoard(2,7);
        assertArrayEquals(expectedSolution1, puzzle.getMappedSolution());

        String[][] expectedSolution2 = {
                {"Tomate", "Citron", "Pomme", "Cerise", "Poire", "Orange", "Mangue", "Banane", "Raisin"},
                {"Cerise", "Mangue", "Poire", "Raisin", "Banane", "Pomme", "Citron", "Tomate", "Orange"},
                {"Mangue", "Poire", "Orange", "Tomate", "Raisin", "Cerise", "Pomme", "Citron", "Banane"},
                {"Orange", "Banane", "Raisin", "Mangue", "Tomate", "Citron", "Cerise", "Poire", "Pomme"},
                {"Pomme", "Cerise", "Citron", "Banane", "Orange", "Mangue", "Tomate", "Raisin", "Poire"},
                {"Banane", "Raisin", "Tomate", "Pomme", "Citron", "Poire", "Orange", "Cerise", "Mangue"},
                {"Raisin", "Tomate", "Cerise", "Orange", "Pomme", "Banane", "Poire", "Mangue", "Citron"},
                {"Poire", "Pomme", "Mangue", "Citron", "Cerise", "Raisin", "Banane", "Orange", "Tomate"},
                {"Citron", "Orange", "Banane", "Poire", "Mangue", "Tomate", "Raisin", "Pomme", "Cerise"},
        };


        puzzle.shuffleBoard(0,0);
        assertArrayEquals(expectedSolution2, puzzle.getMappedSolution());

        String[][] expectedSolution3 = {
                {"Tomate", "Citron", "Pomme", "Cerise", "Poire", "Mangue", "Orange", "Banane", "Raisin"},
                {"Cerise", "Mangue", "Poire", "Raisin", "Banane", "Citron", "Pomme", "Tomate", "Orange"},
                {"Mangue", "Poire", "Orange", "Tomate", "Raisin", "Pomme", "Cerise", "Citron", "Banane"},
                {"Orange", "Banane", "Raisin", "Mangue", "Tomate", "Cerise", "Citron", "Poire", "Pomme"},
                {"Pomme", "Cerise", "Citron", "Banane", "Orange", "Tomate", "Mangue", "Raisin", "Poire"},
                {"Raisin", "Tomate", "Cerise", "Orange", "Pomme", "Poire", "Banane", "Mangue", "Citron"},
                {"Banane", "Raisin", "Tomate", "Pomme", "Citron", "Orange", "Poire", "Cerise", "Mangue"},
                {"Poire", "Pomme", "Mangue", "Citron", "Cerise", "Banane", "Raisin", "Orange", "Tomate"},
                {"Citron", "Orange", "Banane", "Poire", "Mangue", "Raisin", "Tomate", "Pomme", "Cerise"},
        };

        puzzle.shuffleBoard(5,5);
        assertArrayEquals(expectedSolution3, puzzle.getMappedSolution());

        puzzle.shuffleBoard(8,8);
        puzzle.shuffleBoard(-1,0);
        assertArrayEquals(expectedSolution3, puzzle.getMappedSolution());

    }
}