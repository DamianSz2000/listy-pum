package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.quizapp.model.Question;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Question> questions = new ArrayList<>();
    private int currentQuestionIndex = 0;
    private int score = 0;
    private TextView questionNumberTextView;
    private ProgressBar progressBar;
    private TextView questionTextView;
    private RadioGroup answersRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questions.add(new Question("Jakim symbolem oznaczamy siłę?",
                new String[]{"M", "P", "S", "F"}, 3));
        questions.add(new Question("Czego skróconym opisem jest zdanie \"każdej akcji towarzyszy reakcja”?",
                new String[]{"I ZASADY DYNAMIKI", "II ZASADY DYNAMIKI", "III ZASADY DYNAMIKI", "IV ZASADY DYNAMIKI"}, 2));
        questions.add(new Question("Co określa się wzorem p = m*v ?",
                new String[]{"przyspieszenie", "prędkość", "pęd", "kierunek ruchu"}, 2));
        questions.add(new Question("Jaka jest podstawowa jednostka natężenia prądu elektrycznego?",
                new String[]{"kelwin", "wolt", "dżul", "amper"}, 3));
        questions.add(new Question("Kto jest autorem szczególnej teorii względności?",
                new String[]{"Isaac Newton", "Niels Bohr", "Nikola Tesla", "Albert Einstein"}, 3));
        questions.add(new Question("Czego dotyczy prawo powszechnego ciążenia?",
                new String[]{"ciężaru", "grawitacji", "oporu elektrycznego", "indukcji magnetycznej"}, 1));
        questions.add(new Question("Z którym pojęciem związane są hasła: kierunek, zwrot i moduł?",
                new String[]{"z pracą", "z prędkością światła", "z indukcją", "z wektorem"}, 3));
        questions.add(new Question("Z czym związane jest prawo Ohma?",
                new String[]{"z natężeniem prądu", "z prędkością światła", "z grawitacją", "z teorią strun"}, 0));
        questions.add(new Question("Jak inaczej powiemy na ugięcie się fali?",
                new String[]{"dyfrakcja", "dyfuzja", "dyfraktometria", "dyferencja"}, 0));
        questions.add(new Question("Czego jednostką jest dżul?",
                new String[]{"oddziaływania magnetycznego", "energii kinetycznej", "przyspieszenia", "stałej grawitacji"}, 1));

        questionNumberTextView = findViewById(R.id.questionNumber);
        progressBar = findViewById(R.id.progressBar);
        questionTextView = findViewById(R.id.question);
        answersRadioGroup = findViewById(R.id.answers);

        updateQuestionUI();
    }

    private void updateQuestionUI() {
        Question currentQuestion = questions.get(currentQuestionIndex);

        questionNumberTextView.setText("Pytanie " + (currentQuestionIndex + 1) + "/10");
        progressBar.setProgress((currentQuestionIndex + 1) * 10);
        questionTextView.setText(currentQuestion.getQuestionText());

        answersRadioGroup.removeAllViews();
        for (String option : currentQuestion.getOptions()) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(option);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.MATCH_PARENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT,
                    1.0f
            );
            layoutParams.setMargins(0, 0, 0, 16);
            radioButton.setLayoutParams(layoutParams);
            radioButton.setPadding(16, 16, 16, 16);
            radioButton.setBackgroundResource(R.drawable.rounded_corners);

            answersRadioGroup.addView(radioButton);
        }
    }

    public void onNextButtonClick(View view) {
        int selectedOptionIndex = answersRadioGroup.indexOfChild(
                findViewById(answersRadioGroup.getCheckedRadioButtonId()));

        if (selectedOptionIndex != -1) {
            Question currentQuestion = questions.get(currentQuestionIndex);

            if (selectedOptionIndex == currentQuestion.getCorrectOptionIndex()) {
                score += 10;
            }

            currentQuestionIndex++;

            if (currentQuestionIndex < questions.size()) {
                updateQuestionUI();
            } else {
                displayFinalScore();
            }
        }
    }

    private void displayFinalScore() {
        String message = "Gratulacje!\nUzyskałeś " + score + " punktów!";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Quiz zakończony")
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }
}
