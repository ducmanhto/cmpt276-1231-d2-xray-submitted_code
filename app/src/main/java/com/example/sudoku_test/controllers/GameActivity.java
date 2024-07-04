package com.example.sudoku_test.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import com.example.sudoku_test.R;
import com.example.sudoku_test.models.Cell;
import com.example.sudoku_test.models.Puzzle;
import com.example.sudoku_test.models.PuzzleSettings;
import com.example.sudoku_test.models.SudokuBoard;
import com.example.sudoku_test.models.WordBank;
import com.example.sudoku_test.models.WordBankButton;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class GameActivity extends AppCompatActivity {

    public static final int ROW_COUNT_SUDOKU = 9;
    public static final int COLUMN_COUNT_SUDOKU = 9;
    public static int DISPLAY_WIDTH;
    public static int DISPLAY_HEIGHT;

    public static int WORDBANK_ROW_COUNT = 3;
    public static int WORDBANK_COLUMN_COUNT = 3;

    private Puzzle puzzle;
    private SudokuBoard gameBoard;
    private WordBank wordBankBoard;

    private InputStream puzzleInputStream;
    private InputStream solutionInputStream;
    private InputStream vocabInputStream;

    private Button[][] buttonArray;
    private TableLayout boardLayout;
    private TableLayout wordBankLayout;
    private ImageButton exitButton;
    private ImageButton hintButton;
    private ImageButton submitButton;
    private Button clearButton;
    private TextView translationView;
    private String translation;

    private int currentCellX;
    private int currentCellY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        DISPLAY_WIDTH = size.x;
        DISPLAY_HEIGHT = size.y;

        puzzleInputStream = getResources().openRawResource(R.raw.template_1);
        solutionInputStream = getResources().openRawResource(R.raw.template_1_solution);
        vocabInputStream = getResources().openRawResource(R.raw.vocab_fruit);

        PuzzleSettings puzzleSettings = (PuzzleSettings) getIntent().getSerializableExtra("Puzzle_Settings");
        buttonArray = new Button[ROW_COUNT_SUDOKU][COLUMN_COUNT_SUDOKU];

        boardLayout = findViewById(R.id.sudokuboard);
        boardLayout.setShrinkAllColumns(true);

        // board generation
        gameBoard = new SudokuBoard(ROW_COUNT_SUDOKU, COLUMN_COUNT_SUDOKU);

        wordBankBoard = new WordBank(WORDBANK_ROW_COUNT, WORDBANK_COLUMN_COUNT);

        wordBankLayout = findViewById(R.id.wordBank);

        puzzle = new Puzzle(
                readInputStream(puzzleInputStream),
                readInputStream(solutionInputStream),
                readInputStream(vocabInputStream),
                ROW_COUNT_SUDOKU,
                COLUMN_COUNT_SUDOKU
        );

        // button functions
        exitButton = findViewById(R.id.exit_game_button);
        hintButton = findViewById(R.id.hint_button);
        submitButton = findViewById(R.id.submit_puzzle_button);
        clearButton = findViewById(R.id.clear_button);
        translationView = (TextView) findViewById(R.id.selected_word);
        //translation = "hello world";

        exitButton.setOnClickListener(v -> exitOnClickHandler());
        hintButton.setOnClickListener(v -> hintOnClickHandler(gameBoard));
        submitButton.setOnClickListener(v -> submitOnClickHandler(gameBoard));
        clearButton.setOnClickListener(v -> clearOnClickHandler());

        translationView.setText(" ");



        // board rendering
        TableRow.LayoutParams params = new TableRow.LayoutParams(
                DISPLAY_WIDTH / (ROW_COUNT_SUDOKU),
                (DISPLAY_HEIGHT * 3 / 5) / ROW_COUNT_SUDOKU
        );

        for (int row = 0; row < ROW_COUNT_SUDOKU; row++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setBaselineAligned(false);

            for (int col = 0; col < COLUMN_COUNT_SUDOKU; col++) {
                Cell cell = new Cell(row, col);
                Button btn = new Button(this);

                String word = puzzle.getWord(row, col);

                buttonArray[row][col] = btn;
                btn.setLayoutParams(params);
                btn.setOnClickListener(v -> cellButtonOnClickHandler(gameBoard, cell));
                tableRow.addView(btn);

                gameBoard.appendCell(cell);
                initializeDisplayText(cell, word);
                setDefaultColor(cell);

            }
            boardLayout.addView(tableRow);

        }

        double wordBankParamWidth = DISPLAY_WIDTH * 0.75 / WORDBANK_ROW_COUNT;
        double wordBankParamHeight = DISPLAY_HEIGHT / 3.3 / (WORDBANK_COLUMN_COUNT);

        TableRow.LayoutParams wordBankParams = new TableRow.LayoutParams(
                (int) wordBankParamWidth,
                (int) wordBankParamHeight);


        for (int row = 0; row < WORDBANK_ROW_COUNT; row++) {
            TableRow tableRow = new TableRow(this);

            for (int col = 0; col < WORDBANK_COLUMN_COUNT; col++) {

                //Button button = new Button(this);
                WordBankButton wordBankButton = new WordBankButton(row, col, puzzle.getVocabArray()[row * WORDBANK_ROW_COUNT + col][0]);
                wordBankButton.createButton(this);
                wordBankButton.getButton().setLayoutParams(wordBankParams);
                wordBankButton.getButton().setBackgroundResource(R.drawable.dark_grey_rounded_button);
                wordBankButton.getButton().setHeight(10);
                wordBankButton.getButton().setTextColor(getResources().getColor(R.color.white));
                wordBankButton.getButton().setOnClickListener(v -> wordBankButtonClickHandler(wordBankButton.getButton()) );
                //wordBankButton.setButton(button);

                wordBankBoard.addWordToWordArray(row, col, wordBankButton );
                //wordBankBoard.getWordButton(row, col).getButton().setLayoutParams(wordBankParams);
                tableRow.addView(wordBankBoard.getWordButton(row, col).getButton());

            }

            wordBankLayout.addView(tableRow);
        }
    }

    private String[][] readInputStream(InputStream is) {

        String JSONStringBuffer;
        String[][] parsedArray;
        try {
            int streamSize = is.available();
            byte[] buffer = new byte[streamSize];
            is.read(buffer);
            is.close();

            JSONStringBuffer = new String(buffer, "UTF-8");

        } catch (IOException e) {
            JSONStringBuffer = null;
            e.printStackTrace();
        }

        if (JSONStringBuffer != null) {
            try {
                JSONArray JSONTempArray = new JSONArray(JSONStringBuffer);

                int arrayDimensionX = JSONTempArray.length();
                int arrayDimensionY = JSONTempArray.getJSONArray(0).length();
                parsedArray = new String[arrayDimensionX][arrayDimensionY];

                for (int i = 0; i < JSONTempArray.length(); i++) {
                    JSONArray row = JSONTempArray.getJSONArray(i);

                    for (int j = 0; j < row.length(); j++) {
                        parsedArray[i][j] = row.getString(j);
                    }
                }

            } catch (org.json.JSONException e) {
                parsedArray = null;
                e.printStackTrace();
            }
        } else { return null; }

        return parsedArray;
    }

    private String readJSON(InputStream is) {

        try {
            int streamSize = is.available();
            byte[] buffer = new byte[streamSize];
            is.read(buffer);
            is.close();

            return new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void parseJSONStringArray(String JSONString, String[][] array) {

        try {
            JSONArray JSONTempArray = new JSONArray(JSONString);
            for (int i = 0; i < JSONTempArray.length(); i++) {
                JSONArray row =  JSONTempArray.getJSONArray(i);

                for (int j = 0; j < row.length(); j++) {
                    array[i][j] = row.getString(j);
                }
            }

        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    private void exitOnClickHandler() {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
        finish();
    }

    private void hintOnClickHandler(SudokuBoard board) {
        if (board.hintAvailable()) {

        }
    }

    private void submitOnClickHandler(SudokuBoard board) {
        boolean boardSolved = board.validateBoard(
                puzzle.getMappedSolution()
        );

        if (!boardSolved) {
            Toast.makeText(this, "The puzzle is not correct!", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, MainMenuActivity.class);
        Toast.makeText(this, "Well done! Thanks for playing!", Toast.LENGTH_SHORT).show();
        startActivity(intent);
        finish();
    }

    private void clearOnClickHandler() {

        Cell selectedCell = gameBoard.getSelectedCell();
        Button currentButton = buttonArray[selectedCell.coordinateX][selectedCell.coordinateY];
        if(selectedCell.isMutable()) { currentButton.setText(""); }

    }
    private void cellButtonOnClickHandler(SudokuBoard board, Cell cell) {
        System.out.println("Selected Cell: " + cell.coordinateX + " | " + cell.coordinateY);
        Cell selectedCell = board.getSelectedCell();
        currentCellX = cell.coordinateX;
        currentCellY = cell.coordinateY;

        if (selectedCell != cell) {
            if (selectedCell != null) {
                setDefaultColor(selectedCell);
            }

            board.setSelectedCell(cell);
            setColor(
                    cell,
                    getResources().getDrawable(R.drawable.button_highlight)
            );

            String currWord = (String) buttonArray[currentCellX][currentCellY].getText();
            String translation = puzzle.getTranslation(currWord);
            String textTranslation = currWord + " : " + translation;
            translationView.setText(textTranslation);
            System.out.println(puzzle.getTranslation((String) buttonArray[currentCellX][currentCellY].getText()));



            return;
        }

        board.clearSelectedCell();
        setDefaultColor(cell);
    }

    private Button getButton(Cell cell) {
        return buttonArray[cell.coordinateX][cell.coordinateY];
    }

    private Drawable getCellDefaultColor(int coordinateX, int coordinateY) {
        boolean xThreshold = (coordinateX % (2 * ROW_COUNT_SUDOKU / 3) < ROW_COUNT_SUDOKU /3);
        boolean yThreshold = (coordinateY % (2 * COLUMN_COUNT_SUDOKU / 3) < COLUMN_COUNT_SUDOKU /3);

        if (xThreshold ^ yThreshold) {
            return getResources().getDrawable(R.drawable.button_green);
        }
        return getResources().getDrawable(R.drawable.button_dark);
    }

    private void setDefaultColor(Cell cell) {
        Button btn = getButton(cell);
        btn.setBackground(getCellDefaultColor(cell.coordinateX, cell.coordinateY));
    }

    private void setColor(Cell cell, Drawable color) {
        Button btn = getButton(cell);
        btn.setBackground(color);
    }

    private void initializeDisplayText(Cell cell, String word) {
        Button btn = getButton(cell);
        btn.setTextSize(8.4f);
        btn.setBackground(getResources().getDrawable(R.drawable.button_green));
        btn.setTextColor(getResources().getColor(R.color.white));

        if (word.equals("?")) {
            btn.setText("\0");
            cell.setMutable(true);
        } else {
            btn.setText(word);
        }
        cell.setWord(word);

    }

    /*
        This method should be used for the interactive word bank
     */
    private void setDisplayText(Cell cell, String word) {
        Button btn = getButton(cell);

        if (cell.isMutable()) {
            btn.setText(word);
            cell.setWord(word);
        }
    }

    private void wordBankButtonClickHandler(Button button) {
        System.out.println("Button has been pressed");
        String translation = puzzle.getTranslation((String) button.getText());
        Cell selectedCell = gameBoard.getSelectedCell();

        if (selectedCell == null)
            return;

        setDisplayText(
                selectedCell,
                translation
        );

        String currWord = (String) button.getText();
        String textTranslation = currWord + " : " + translation;
        translationView.setText(textTranslation);
    }
}

