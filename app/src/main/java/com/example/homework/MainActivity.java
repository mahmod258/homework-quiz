package com.example.homework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Quiz quiz = new Quiz();
    private int currentQuestionIndex = 0;
    private int score = 0;

    private TextView questionTextView;
    private LinearLayout answersLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        answersLayout = findViewById(R.id.answersLayout);


        displayQuestion();
    }

    private void displayQuestion() {
        questionTextView.setText(quiz.getQuestions()[currentQuestionIndex].getQuestion());
        answersLayout.removeAllViews();

        String[] answers = quiz.getQuestions()[currentQuestionIndex].getAnswers();
        for (int i = 0; i < answers.length; i++) {
             int index = i;
            Button answerButton = new Button(this);
            answerButton.setText(answers[i]);
            answerButton.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            answerButton.setPadding(16, 16, 16, 16);

            answerButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (index == quiz.getQuestions()[currentQuestionIndex].getCorrectIndex()) {
                        score++;
                    }

                    if (currentQuestionIndex < quiz.getQuestions().length - 1) {
                        currentQuestionIndex++;
                        displayQuestion();
                    } else {
                        showResults();
                    }
                }
            });

            answersLayout.addView(answerButton);
        }
    }

    public void showResults() {
        Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
        finish();
    }
}
