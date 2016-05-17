package com.example.luis.lifepointscalculator;

import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {


    Button buttonTwo;
    Button buttonOne;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_initial, container, false);

        buttonOne = (Button) rootView.findViewById(R.id.play_button);
        buttonTwo = (Button) rootView.findViewById(R.id.options_button);


        buttonOne.setOnClickListener(new Button.OnClickListener() {
                                         public void onClick(View v) {
                                             Intent intent = new Intent(getActivity().getApplicationContext(), OnePlayerActivity.class);
                                             if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                                 ActivityOptionsCompat options = ActivityOptionsCompat
                                                         .makeSceneTransitionAnimation(getActivity(), v, getString(R.string.start_transition));
                                                 ActivityCompat.startActivity(getActivity(), intent, options.toBundle());
                                             } else {
                                                 startActivity(intent);
                                             }
                                         }
                                     }
        );

        buttonTwo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), OptionsActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat options = ActivityOptionsCompat
                            .makeSceneTransitionAnimation(getActivity(), v, getString(R.string.options_transition));
                    ActivityCompat.startActivity(getActivity(), intent, options.toBundle());
                } else {
                    startActivity(intent);
                }
            }
        });
        return rootView;
    }


}
