package com.example.sudoku_test.models;

import android.widget.Button;

public class WordBankButton{

    private Button button;
    private String word;
    private int coordinateX;
    private int coordinateY;


    public WordBankButton(int row, int col, String word) {
        this.coordinateX = row;
        this.coordinateY = col;
        this.word = word;
        //button = new Button(context);

        //create button with word and style


       // set button listener


    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() { return this.word; }

    public Button getButton() {return button;}

    public void setButton(Button button) {
        this.button = button;
        this.button.setText(word);
    }

    public void createButton(android.content.Context context) {

        Button button = new Button(context);
        this.button = new Button(context);
        this.button.setText(word);

    }
}
