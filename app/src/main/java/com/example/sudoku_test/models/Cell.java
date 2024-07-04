package com.example.sudoku_test.models;

public class Cell {

    private String word = "\0";
    private boolean isMutable = false;

    public int coordinateX;
    public int coordinateY;

    public Cell(int row, int col) {
        this.coordinateX = row;
        this.coordinateY = col;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() { return this.word; }

    public void clearCell() {
        this.word = "\0";
    }

    public boolean isEmpty() {
        return true ? word.equals("\0") : false;
    }

    public boolean isMutable() {
        return isMutable;
    }

    public void setMutable(boolean isMutable) {
        this.isMutable = this.isMutable == false ? isMutable : this.isMutable;
    }
}
