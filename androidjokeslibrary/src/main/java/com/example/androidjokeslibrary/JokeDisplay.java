package com.example.androidjokeslibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;



public class JokeDisplay extends AppCompatActivity {
    private String joke;
     public static String JOKE_KEY="joke";
    //TextView jokesTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
      /*  jokesTextView=findViewById(R.id.jokes_tv);
        Intent intent=getIntent();
        joke=intent.getStringExtra(JOKE_KEY);
        if(joke!=null)
            jokesTextView.setText(joke);
            */



    }
}
