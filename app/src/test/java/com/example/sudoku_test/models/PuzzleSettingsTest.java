package com.example.sudoku_test.models;

import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;

import org.junit.Test;

import java.lang.reflect.Field;

public class PuzzleSettingsTest extends TestCase {

    @Test
    public void testGetLanguageMode() {
        PuzzleSettings puzSettings = new PuzzleSettings(null, null, null, null);
        String[] stringArray = {"Word", "Word\n", "\n", "\t", "", "1234567890", "\0", ";", " "};

        try {
            final Field selectedCellField = puzSettings.getClass().getDeclaredField("languageMode");
            selectedCellField.setAccessible(true);

            try {
                assertEquals(true, puzSettings.getLanguageMode() == null);
                for (int i=0; i< stringArray.length; i++) {
                    selectedCellField.set(puzSettings, stringArray[i]);
                    assertEquals(true, puzSettings.getLanguageMode() == stringArray[i]);
                }
            } catch (IllegalAccessException e){
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void testGetLanguageDifficulty() {
        PuzzleSettings puzSettings = new PuzzleSettings(null, null, null, null);
        String[] stringArray = {"Word", "Word\n", "\n", "\t", "", "1234567890", "\0", ";", " "};

        try {
            final Field selectedCellField = puzSettings.getClass().getDeclaredField("languageDifficulty");
            selectedCellField.setAccessible(true);

            try {
                assertEquals(true, puzSettings.getLanguageDifficulty() == null);
                for (int i=0; i< stringArray.length; i++) {
                    selectedCellField.set(puzSettings, stringArray[i]);
                    assertEquals(true, puzSettings.getLanguageDifficulty() == stringArray[i]);
                }
            } catch (IllegalAccessException e){
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void testGetPuzzleDifficulty() {
        PuzzleSettings puzSettings = new PuzzleSettings(null, null, null, null);
        String[] stringArray = {"Word", "Word\n", "\n", "\t", "", "1234567890", "\0", ";", " "};

        try {
            final Field selectedCellField = puzSettings.getClass().getDeclaredField("puzzleDifficulty");
            selectedCellField.setAccessible(true);

            try {
                assertEquals(true, puzSettings.getPuzzleDifficulty() == null);
                for (int i=0; i< stringArray.length; i++) {
                    selectedCellField.set(puzSettings, stringArray[i]);
                    assertEquals(true, puzSettings.getPuzzleDifficulty() == stringArray[i]);
                }
            } catch (IllegalAccessException e){
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void testGetWordCategory() {
        PuzzleSettings puzSettings = new PuzzleSettings(null, null, null, null);
        String[] stringArray = {"Word", "Word\n", "\n", "\t", "", "1234567890", "\0", ";", " "};

        try {
            final Field selectedCellField = puzSettings.getClass().getDeclaredField("wordCategory");
            selectedCellField.setAccessible(true);

            try {
                assertEquals(true, puzSettings.getWordCategory() == null);
                for (int i=0; i< stringArray.length; i++) {
                    selectedCellField.set(puzSettings, stringArray[i]);
                    assertEquals(true, puzSettings.getWordCategory() == stringArray[i]);
                }
            } catch (IllegalAccessException e){
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void testSetLanguageMode() {
        PuzzleSettings puzSettings = new PuzzleSettings(null, null, null, null);
        String[] stringArray = {"Word", "Word\n", "\n", "\t", "", "1234567890", "\0", ";", " "};

        try {
            final Field selectedCellField = puzSettings.getClass().getDeclaredField("languageMode");
            selectedCellField.setAccessible(true);

            try {
                for (int i=0; i< stringArray.length; i++) {
                    puzSettings.setLanguageMode(stringArray[i]);
                    assertEquals(stringArray[i], selectedCellField.get(puzSettings));
                }
            } catch (IllegalAccessException e){
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void testSetLanguageDifficulty() {
        PuzzleSettings puzSettings = new PuzzleSettings(null, null, null, null);
        String[] stringArray = {"Word", "Word\n", "\n", "\t", "", "1234567890", "\0", ";", " "};

        try {
            final Field selectedCellField = puzSettings.getClass().getDeclaredField("languageDifficulty");
            selectedCellField.setAccessible(true);

            try {
                for (int i=0; i< stringArray.length; i++) {
                    puzSettings.setLanguageDifficulty(stringArray[i]);
                    assertEquals(stringArray[i], selectedCellField.get(puzSettings));
                }
            } catch (IllegalAccessException e){
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void testSetPuzzleDifficulty() {
        PuzzleSettings puzSettings = new PuzzleSettings(null, null, null, null);
        String[] stringArray = {"Word", "Word\n", "\n", "\t", "", "1234567890", "\0", ";", " "};

        try {
            final Field selectedCellField = puzSettings.getClass().getDeclaredField("puzzleDifficulty");
            selectedCellField.setAccessible(true);

            try {
                for (int i=0; i< stringArray.length; i++) {
                    puzSettings.setPuzzleDifficulty(stringArray[i]);
                    assertEquals(stringArray[i], selectedCellField.get(puzSettings));
                }
            } catch (IllegalAccessException e){
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void testSetWordCategory() {
        PuzzleSettings puzSettings = new PuzzleSettings(null, null, null, null);
        String[] stringArray = {"Word", "Word\n", "\n", "\t", "", "1234567890", "\0", ";", " "};

        try {
            final Field selectedCellField = puzSettings.getClass().getDeclaredField("wordCategory");
            selectedCellField.setAccessible(true);

            try {
                for (int i=0; i< stringArray.length; i++) {
                    puzSettings.setWordCategory(stringArray[i]);
                    assertEquals(stringArray[i], selectedCellField.get(puzSettings));
                }
            } catch (IllegalAccessException e){
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}