package com.example.week4project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button nextButton;
    TextView questionView;
    RadioGroup buttonGroup;
    Question currentQuestion;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get our STATIC objects we have placed in the Activity scene
        nextButton = findViewById(R.id.NextButton);
        questionView = findViewById(R.id.QuestionView);
        buttonGroup = findViewById(R.id.ButtonGroup);
    }

    public void OnNextClick(View v) {
        // clear the current content
        currentQuestion = null;
        questionView.setText("");
        buttonGroup.clearCheck();
        buttonGroup.removeAllViews();

        // create new content
        currentQuestion = new Question(getApplicationContext());
        currentQuestion.AddGroup(buttonGroup);
        questionView.setText(currentQuestion.getQuestion());
    }

    public void CheckAnswer(View v) {
        System.out.println(buttonGroup.getCheckedRadioButtonId());
        System.out.println(currentQuestion.getCorrectAnswer());
        if (buttonGroup.getCheckedRadioButtonId() == currentQuestion.getCorrectAnswer()) {
            CharSequence text = "CORRECT";
            //Question was answered correctly!
            Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
            toast.show();

            ShowDialog("Congratulations!", "You answered CORRECTLY!");
        } else {
            //They got it wrong!87455*-\
            Toast toast = Toast.makeText(getApplicationContext(), "WRONG", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void ShowDialog(String title, String message) {
        builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);

        // add a button
        builder.setPositiveButton("OK", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
