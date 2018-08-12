package com.udacity.gradle.builditbigger;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    ProgressBar progressIndicator;
    private Button getJokeButton;


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_activity, container, false);
        getJokeButton = root.findViewById(R.id.get_joke_btn);
        progressIndicator = root.findViewById(R.id.progress_indicator);

        getJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressIndicator.setVisibility(View.VISIBLE);
                tellJoke();

            }
        });

        progressIndicator.setVisibility(View.GONE);


        return root;
    }

    private void tellJoke() {

        new EndpointsAsyncTask().execute(this);


    }
}
