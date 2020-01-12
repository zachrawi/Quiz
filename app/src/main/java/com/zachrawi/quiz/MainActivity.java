package com.zachrawi.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textViewQuestion;
    private TextView textViewScore;
    private Button buttonTrue;
    private Button buttonFalse;
    private Question[] questions;
    private int index = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewScore = findViewById(R.id.textViewScore);
        buttonTrue = findViewById(R.id.buttonTrue);
        buttonFalse = findViewById(R.id.buttonFalse);

        questions = new Question[] {
                new Question(R.string.question_1, false),
                new Question(R.string.question_2, false),
                new Question(R.string.question_3, true),
                new Question(R.string.question_4, false),
                new Question(R.string.question_5, false),
                new Question(R.string.question_6, true),
                new Question(R.string.question_7, true),
                new Question(R.string.question_8, true),
                new Question(R.string.question_9, true),
                new Question(R.string.question_10, true),
        };

        showQuestion();

        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question question = questions[index];

                if (question.isAnswerTrue()) {
                    score = score + 1;
                    Toast.makeText(MainActivity.this, getText(R.string.answer_correct), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, getText(R.string.answer_wrong), Toast.LENGTH_SHORT).show();
                }

                index = index + 1;
                showQuestion();
            }
        });

        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question question = questions[index];

                if (!question.isAnswerTrue()) {
                    score = score + 1;
                    Toast.makeText(MainActivity.this, getText(R.string.answer_correct), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, getText(R.string.answer_wrong), Toast.LENGTH_SHORT).show();
                }

                index = index + 1;
                showQuestion();
            }
        });
    }

    private void showQuestion() {
        if (index < questions.length) {
            Question question = questions[index];
            textViewQuestion.setText(question.getQuestion());
            textViewScore.setText("Score: " + score + "/" + questions.length);
        } else {
            textViewQuestion.setText("Nilai Anda " + score);
            textViewScore.setVisibility(View.INVISIBLE);
            buttonTrue.setEnabled(false);
            buttonFalse.setEnabled(false);
        }
    }
}
