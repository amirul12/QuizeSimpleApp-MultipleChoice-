package com.edupointbd.amirul.quizeappsdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class HighScoreActitvity extends AppCompatActivity {

    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score_actitvity);

        TextView Tvscore = (TextView)findViewById(R.id.scoreid);
        TextView high = (TextView)findViewById(R.id.highScore);

        Bundle b = getIntent().getExtras();
        if(b !=null){
            score  =b.getInt("highscore");
        }
        Tvscore.setText("your score: "+score);

        SharedPreferences mySpre = getPreferences(MODE_PRIVATE);
        int hightScore = mySpre.getInt("HightScore",score);
        Log.d("hightScore", String.valueOf(hightScore));
        if(hightScore >=  score){
            high.setText("High Score: "+hightScore);

        }else {
            high.setText("Score"+score);
            SharedPreferences.Editor editor = mySpre.edit();
            editor.putInt("HightScore",score);
            Log.d("hightScore 3", String.valueOf(hightScore));
            editor.commit();
        }

    }
    public void onClick(View view){
        Intent intent = new Intent(HighScoreActitvity.this,MainActivity.class);
        startActivity(intent);
    }
}
