package com.example.sudoku_test.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.lang.reflect.Field;

public class CellTest {

    @Test
    public void setWord() {
        Cell cell = new Cell(0,0);
        String[] strArr = {"Bonjour", "Hello!\n", "\n", "\0", ""};

        try {
            final Field wordField = cell.getClass().getDeclaredField("word");
            wordField.setAccessible(true);
            try {

                for (int i = 0; i < strArr.length; i++) {
                    cell.setWord(strArr[i]);
                    String word = (String) wordField.get(cell);
                    assertEquals(strArr[i], word);
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getWord() {
        Cell cell = new Cell(0,0);
        String[] strArr = {"Bonjour", "Hello!\n", "\n", "\0", ""};

        try {
            final Field wordField = cell.getClass().getDeclaredField("word");
            wordField.setAccessible(true);
            try {

                for (int i = 0; i < strArr.length; i++) {
                    wordField.set(cell, strArr[i]);
                    assertEquals(strArr[i], cell.getWord());
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void clearCell() {
        Cell cell = new Cell(0,0);

        try {
            final Field wordField = cell.getClass().getDeclaredField("word");
            wordField.setAccessible(true);
            try {

                wordField.set(cell, "Bonjour");
                cell.clearCell();
                assertEquals("\0", (String) wordField.get(cell));

                wordField.set(cell, "\0");
                cell.clearCell();
                assertEquals("\0", (String) wordField.get(cell));

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void isEmpty() {
        Cell cell = new Cell(0,0);

        try {
            final Field wordField = cell.getClass().getDeclaredField("word");
            wordField.setAccessible(true);
            try {

                assertEquals(true, cell.isEmpty());

                wordField.set(cell, "Bonjour");
                cell.isEmpty();
                assertEquals(false, cell.isEmpty());

                wordField.set(cell, "\0");
                assertEquals(true, cell.isEmpty());

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getIsMutable() {
        Cell cell = new Cell(0,0);

        try {
            final Field wordField = cell.getClass().getDeclaredField("isMutable");
            wordField.setAccessible(true);
            try {

                assertEquals(false, cell.isMutable());

                wordField.set(cell, true);
                cell.isEmpty();
                assertEquals(true, cell.isMutable());

                wordField.set(cell, false);
                assertEquals(false, cell.isMutable());

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void setMutable() {
        Cell cell = new Cell(0,0);

        try {
            final Field wordField = cell.getClass().getDeclaredField("isMutable");
            wordField.setAccessible(true);
            try {

                cell.setMutable(true);
                assertEquals(true, (Boolean) wordField.get(cell));

                wordField.set(cell, false);
                cell.isEmpty();
                assertEquals(false, (Boolean) wordField.get(cell));

                wordField.set(cell, true);
                assertEquals(true, (Boolean) wordField.get(cell));

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}