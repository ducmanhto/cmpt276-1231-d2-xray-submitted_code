package com.example.sudoku_test.controllers;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.sudoku_test.R;

public class MainMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        View decorView = getWindow().getDecorView();
        //Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        //Hide the action bar
        ActionBar actionBar = getSupportActionBar();
//        assert actionBar != null;
//        actionBar.hide();

        //Play button
        Button button = (Button) findViewById(R.id.playbtn);
        button.setOnClickListener(view -> openGeneratePuzzle());
    }

    private void openGeneratePuzzle() {
        Intent generate = new Intent(this, GenerateActivity.class);
        startActivity(generate);
    }
}