package com.example.androidjokeslibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class JokeDisplayFragment extends Fragment {

    public JokeDisplayFragment(){

    }




    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_joke_display, container, false);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            String joke = intent.getStringExtra(JokeDisplay.JOKE_KEY);
            TextView jokeTextView = root.findViewById(R.id.jokes_tv);
            if (joke != null && joke.length() != 0) {
                jokeTextView.setText(joke);
            }
        }

        return root;

    }


}