package com.example.sudoku_test.models;

public class WordBank {

    private int wordBankX = 3;
    private int wordBankY = 3;

    //private android.content.Context wordBankContext;

    private WordBankButton[][] wordBankArray;

    public WordBank(int wordBankX, int wordBankY) {

        this.wordBankX = wordBankX;
        this.wordBankY = wordBankY;

        wordBankArray = new WordBankButton[wordBankX][wordBankY];

    }

    public void addWordToWordArray(int x, int y, WordBankButton word) {

        wordBankArray[x][y] = word;


    }

    public WordBankButton getWordButton(int x, int y) {

        return wordBankArray[x][y];

    }

}
