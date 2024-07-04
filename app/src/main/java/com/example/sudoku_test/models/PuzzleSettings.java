package com.example.sudoku_test.models;

import java.io.Serializable;

public class PuzzleSettings implements Serializable {

    private String languageMode;
    private String languageDifficulty;
    private String puzzleDifficulty;
    private String wordCategory;

    public PuzzleSettings(String languageMode, String languageDifficulty, String puzzleDifficulty, String wordCategory) {

        this.languageMode = languageMode;
        this.languageDifficulty = languageDifficulty;
        this.puzzleDifficulty = puzzleDifficulty;
        this.wordCategory = wordCategory;

    }

    // for medium difficulty
    public PuzzleSettings(String languageMode, String languageDifficulty, String puzzleDifficulty) {

        this.languageMode = languageMode;
        this.languageDifficulty = languageDifficulty;
        this.puzzleDifficulty = puzzleDifficulty;
        this.wordCategory = "Random";
    }
    // Getters
    public String getLanguageMode() {return languageMode;}
    public String getLanguageDifficulty() {
        return languageDifficulty;
    }
    public String getPuzzleDifficulty() {
        return puzzleDifficulty;
    }
    public String getWordCategory() {
        return wordCategory;
    }

    // Setters
    public void setLanguageMode(String newLanguageMode) {
        this.languageMode = newLanguageMode;
    }
    public void setLanguageDifficulty(String newLanguageDifficulty) {
        this.languageDifficulty = newLanguageDifficulty;
    }
    public void setPuzzleDifficulty(String newPuzzleDifficulty) {
        this.puzzleDifficulty = newPuzzleDifficulty;
    }
    public void setWordCategory(String newWordCategory) {
        this.wordCategory = newWordCategory;
    }

}
