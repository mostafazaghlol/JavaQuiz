package com.example.android.javaquiz;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    ArrayList<Question> QA = new ArrayList<>();
    TextView TxQuestion, TxAnswer1, TxAnswer2, TxAnswer3, TxAnswer4,TxResult;
    Button BuNext;
    RadioButton R1,R2,R3,R4;
    Stack<Character> Answers=new Stack<>();
    char choosedCharacter;
    Stack<Character> RightAnswers=new Stack<>();
    int count=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TxQuestion = (TextView) findViewById(R.id.QuestionTX);
        TxAnswer1 = (TextView) findViewById(R.id.Answer1);
        TxAnswer2 = (TextView) findViewById(R.id.Answer2);
        TxAnswer3 = (TextView) findViewById(R.id.Answer3);
        TxAnswer4 = (TextView) findViewById(R.id.Answer4);
        TxResult = (TextView) findViewById(R.id.result_is);
        BuNext = (Button) findViewById(R.id.BuNext);
        R1=(RadioButton) findViewById(R.id.A_radio_button);
        R2=(RadioButton) findViewById(R.id.B_radio_button);
        R3=(RadioButton) findViewById(R.id.C_radio_button);
        R4=(RadioButton) findViewById(R.id.D_radio_button);

        RightAnswers.push('A');
        RightAnswers.push('C');
        RightAnswers.push('A');


        QA.add(new Question("Q 1 - What is a class in java?", "A - A class is a blue print from which individual objects are created. A class can contain fields and methods to describe the behavior of an object."
                , "B - class is a special data type.", "C - class is used to allocate memory to a data type.", "D - none of the above."));
        QA.add(new Question("Q 2 - What is the size of int variable?", "A - 8 bit.", "B - 16 bit.", "C - 32 bit.", "D - 64 bit."));
        QA.add(new Question("Q 3 - What is the default value of byte variable?", "A - 0", "B - 0.0", "C - null", "D - not defined"));
        QA.add(new Question("Q 4       - What is the default value of byte variable?", "A - 0", "B - 0.0", "C - null", "D - not defined"));

        BuNext.setOnClickListener(new View.OnClickListener() {
            int i=1;
                                      @Override
                                      public void onClick(View view) {
                                          try {
                                              BuNext.setText("Next");
                                              Question object = QA.get(i);
                                              TxQuestion.setText(object.getQuestion());
                                              TxAnswer1.setText(object.getAnswer1());
                                              TxAnswer2.setText(object.getAnswer2());
                                              TxAnswer3.setText(object.getAnswer3());
                                              TxAnswer4.setText(object.getAnswer4());
                                              Answers.push(choosedCharacter);
                                              i++;
                                              TxResult.setText(String.valueOf(theResult(RightAnswers,Answers)));
                                          }catch (IndexOutOfBoundsException e){

                                          }

                                      }
                                  }
        );


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.A_radio_button:
                if (checked)
                    choosedCharacter='A';
                    break;
            case R.id.B_radio_button:
                if (checked)
                    choosedCharacter='B';
                    break;
            case R.id.C_radio_button:
                if (checked)
                    choosedCharacter='C';
                break;
            case R.id.D_radio_button:
                if (checked)
                    choosedCharacter='D';
                    break;
        }
    }

    public int theResult(Stack<Character> RightAnswer,Stack<Character> Answer){
    String char1,char2;
    char1=RightAnswer.pop().toString();
    char2=Answer.pop().toString();

    if(char1.equals(char2)){
        count++;
    }
    return count;
    }
}
