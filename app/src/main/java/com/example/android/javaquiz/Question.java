package com.example.android.javaquiz;

/**
 * Created by mostafa on 12/5/17.
 */

public class Question {
    private String Question ,Answer1,Answer2,Answer3,Answer4;

    public Question(String Q,String A1,String A2,String A3,String A4){
        this.Question=Q;
        this.Answer1=A1;
        this.Answer2=A2;
        this.Answer3=A3;
        this.Answer4=A4;
    }

    public String getAnswer1() {
        return Answer1;
    }

    public String getAnswer2() {
        return Answer2;
    }

    public String getAnswer3() {
        return Answer3;
    }

    public String getAnswer4() {
        return Answer4;
    }

    public String getQuestion() {
        return Question;
    }
}
