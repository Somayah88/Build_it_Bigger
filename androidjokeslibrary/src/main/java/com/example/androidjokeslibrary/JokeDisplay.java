package com.example.androidjokeslibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class JokeDisplay extends AppCompatActivity {
    private String joke;
    public static final String JOKE_KEY = "joke";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);


    }
}
