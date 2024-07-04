package com.example.sudoku_test;

import static org.junit.Assert.assertEquals;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.sudoku_test.models.WordBank;
import com.example.sudoku_test.models.WordBankButton;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class WordBankTest {

    private WordBankButton wordBankButton = new WordBankButton(1,1, "banana");
    private WordBank wordBank = new WordBank(3,3);

    @Test
    public void checkWordBankFunctionality() {

        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        wordBankButton.createButton(appContext);
        wordBank.addWordToWordArray(1, 1, wordBankButton);
        assertEquals("banana", wordBank.getWordButton(1,1).getWord());
        assertEquals(wordBankButton.getWord(), wordBank.getWordButton(1, 1).getWord());
        assertEquals("banana", wordBankButton.getWord());

    }


    public void checkGetWordAndSetWord() {

        wordBankButton.setWord("apple");
        assertEquals("apple",wordBankButton.getWord());

    }

}
