package com.edupointbd.amirul.quizeappsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private QuestionBank myQuestionBank = new QuestionBank();
    private TextView mScoreView;
    private TextView mQuestionView;
    private TextView mChoice1,mChoice2,mChoice3,mChoice4;


    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.tvQuestion);
        mChoice1 = (TextView)findViewById(R.id.ch1);
        mChoice2 = (TextView)findViewById(R.id.ch2);
        mChoice3 = (TextView)findViewById(R.id.ch3);
        mChoice4 = (TextView)findViewById(R.id.ch4);

        updateQuestion();
        updateScore(mQuestionNumber);

    }


    private void updateQuestion() {
        if(mQuestionNumber < myQuestionBank.getLength()){
            mQuestionView.setText(myQuestionBank.getQuestion(mQuestionNumber));
            mChoice1.setText(myQuestionBank.getChoice(mQuestionNumber,1));
            mChoice2.setText(myQuestionBank.getChoice(mQuestionNumber,2));
            mChoice3.setText(myQuestionBank.getChoice(mQuestionNumber,3));
            mChoice4.setText(myQuestionBank.getChoice(mQuestionNumber,4));
            mChoice1.setOnClickListener(this);
            mChoice2.setOnClickListener(this);
            mChoice3.setOnClickListener(this);
            mChoice4.setOnClickListener(this);

            mAnswer = myQuestionBank.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }
        else {
            Toast.makeText(getApplicationContext(),"the last was indeed",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this,HighScoreActitvity.class);
            intent.putExtra("highscore",mScore);
            startActivity(intent);
        }
    }

    private void updateScore(int inPoint) {
        mScoreView.setText("question no: "+mQuestionNumber+" Score "+mScore+"/"+myQuestionBank.getLength());


    }

    public  void onClick(View view){
        Button answer = (Button)view;
        if(answer.getText() == mAnswer){
            mScore =mScore+1;
            Toast.makeText(getApplicationContext(),"Correct !!",Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(getApplicationContext(),"wrong answer..",Toast.LENGTH_LONG).show();
        }
        updateScore(mQuestionNumber);
        updateQuestion();

    }
}
