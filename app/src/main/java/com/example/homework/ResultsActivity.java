package com.example.homework;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        TextView resultsTextView = findViewById(R.id.resultsTextView);
        int score = getIntent().getIntExtra("score", 0);

        resultsTextView.setText("Your score: " + score + " out of 4");
    }
}
