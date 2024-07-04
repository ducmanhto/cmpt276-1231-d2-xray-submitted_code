package com.example.sudoku_test.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sudoku_test.R;
import com.example.sudoku_test.models.PuzzleSettings;


public class GenerateActivity extends AppCompatActivity  {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_puzzle);
        PuzzleSettings puzzleSettings = new PuzzleSettings(null, null, null, null); // initialize to null

        // Word Lists
        Button NumbersBtn = (Button) findViewById(R.id.numbers_btn);
        Button ColoursBtn = (Button) findViewById(R.id.colours_btn);
        Button FoodBtn = (Button) findViewById(R.id.food_btn);
        Button DatesBtn = (Button) findViewById(R.id.dates_btn);
        Button PlacesBtn = (Button) findViewById(R.id.places_btn);
        Button WeatherBtn = (Button) findViewById(R.id.weather_btn);
        View.OnClickListener WordListListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button)v; //get selected button, update settings list
                String buttonText = button.getText().toString();
                //Medium language difficulty can't have a word list: only random words.
                if (puzzleSettings.getWordCategory() == "Random") {
                    Toast.makeText(getApplicationContext(),"Warning: Medium Language Difficulty doesn't have a word list." +
                                    "\nChanging to Easy difficulty.", Toast.LENGTH_LONG).show();
                    puzzleSettings.setLanguageDifficulty("Easy");
                }
                puzzleSettings.setWordCategory(buttonText);
            }
        };
        NumbersBtn.setOnClickListener(WordListListener);
        ColoursBtn.setOnClickListener(WordListListener);
        FoodBtn.setOnClickListener(WordListListener);
        DatesBtn.setOnClickListener(WordListListener);
        PlacesBtn.setOnClickListener(WordListListener);
        WeatherBtn.setOnClickListener(WordListListener);


        // Language Difficulty
        Button EasyBtn = (Button) findViewById(R.id.easy_language_btn);
        Button MediumBtn = (Button) findViewById(R.id.medium_language_btn);
        Button HardBtn = (Button) findViewById(R.id.hard_language_btn);
        View.OnClickListener LanguageDifficultyListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button)v;
                String buttonText = button.getText().toString();

                // if button was previously medium difficulty, remove Random word list setting
                if (puzzleSettings.getLanguageDifficulty() == MediumBtn.getText().toString()) {
                    Toast.makeText(getApplicationContext(),"Removing randomized setting, please choose a Word List.",
                            Toast.LENGTH_SHORT).show();
                    puzzleSettings.setWordCategory(null);
                }
                if (button == MediumBtn) {  // medium difficulty: set LanguageMode to be Random.
                    Toast.makeText(getApplicationContext(),"Setting Word Lists to Random",
                            Toast.LENGTH_SHORT).show();
                    puzzleSettings.setWordCategory("Random");
                }
                puzzleSettings.setLanguageDifficulty(buttonText);
            }
        };
        EasyBtn.setOnClickListener(LanguageDifficultyListener);
        MediumBtn.setOnClickListener(LanguageDifficultyListener);
        HardBtn.setOnClickListener(LanguageDifficultyListener);


        // Puzzle Difficulty
        Button NormalBtn = (Button) findViewById(R.id.normal_puzzle_btn);
        Button DifficultBtn = (Button) findViewById(R.id.difficult_puzzle_btn);
        View.OnClickListener PuzzleDifficultyListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button)v; //get selected button, update settings list
                String buttonText = button.getText().toString();
                puzzleSettings.setPuzzleDifficulty(buttonText);
            }
        };
        NormalBtn.setOnClickListener(PuzzleDifficultyListener);
        DifficultBtn.setOnClickListener(PuzzleDifficultyListener);


        // Language Mode
        Button EnglishBtn = (Button) findViewById(R.id.english_btn);
        Button FrenchBtn = (Button) findViewById(R.id.french_btn);
        View.OnClickListener LanguageModeListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button)v; //get selected button, update settings list
                String buttonText = button.getText().toString();
                puzzleSettings.setLanguageMode(buttonText);
            }
        };
        EnglishBtn.setOnClickListener(LanguageModeListener);
        FrenchBtn.setOnClickListener(LanguageModeListener);


        // Go to Puzzle Page
        Button GeneratePuzzleButton = (Button) findViewById(R.id.generatepuzzlebtn);
        GeneratePuzzleButton.setOnClickListener(view -> GenerateGameActivity(puzzleSettings));

        //Go back to Main Menu
        Button BackButton = (Button) findViewById(R.id.back_btn);
        BackButton.setOnClickListener(view -> GenerateMainMenu());

        //render activity buttons
    }

    //pass data to game activity
    //opens GameActivity class
    public void GenerateGameActivity(PuzzleSettings puzSet) {
        if (CheckAllNull(puzSet)) {
            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra("Puzzle_Settings", puzSet);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(),"Choose an option for each category.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public boolean CheckAllNull (PuzzleSettings puzSet) {
        if (puzSet.getWordCategory() != null) {
            if (puzSet.getLanguageDifficulty() != null) {
                if (puzSet.getPuzzleDifficulty() != null) {
                    if (puzSet.getLanguageMode() != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //opens MainMenu class
    public void GenerateMainMenu() {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}
