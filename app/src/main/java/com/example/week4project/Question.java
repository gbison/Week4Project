package com.example.week4project;

import android.content.Context;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Question {

    //Declarations
    private String a;
    private String b;
    private String c;
    private String d;

    private String question;

    private RadioButton buttonA;
    private RadioButton buttonB;
    private RadioButton buttonC;
    private RadioButton buttonD;

    private int correctAnswer;

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    //Getters & Setters
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    //Constructor
    public Question(Context context) {

        //Here we are hardcoding this values, ideally you want to format a text file that you
        //could read values from so that you could plug question sets into the app.
        a = "Sir George Boole";
        b = "Sir Anthony Hopkins";
        c = "King Henry VIII";
        d = "Leonardo Divinci";

        question = "Who was the inventor of Boolean logic?";

        //Configure constant IDS, if we dont the group box will keep incrementing them over time.
        final int AID = 10;
        final int BID = 20;
        final int CID = 30;
        final int DID = 40;

        //Create buttons and associate answers
        buttonA = new RadioButton(context);
        buttonA.setText(a);
        buttonA.setId(AID);
        buttonB = new RadioButton(context);
        buttonB.setText(b);
        buttonB.setId(BID);
        buttonC = new RadioButton(context);
        buttonC.setText(c);
        buttonC.setId(CID);
        buttonD = new RadioButton(context);
        buttonD.setText(d);
        buttonD.setId(DID);

        //define the correct answer
        correctAnswer = AID; //first object in the RadioGroup
    }

    //General Methods.
    public void AddGroup(RadioGroup buttonGroup) {
        //Add to group
        buttonGroup.addView(buttonA);
        buttonGroup.addView(buttonB);
        buttonGroup.addView(buttonC);
        buttonGroup.addView(buttonD);
    }


}
