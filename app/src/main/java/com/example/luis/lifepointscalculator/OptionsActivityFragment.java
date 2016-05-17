package com.example.luis.lifepointscalculator;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class OptionsActivityFragment extends Fragment implements View.OnClickListener {

    int playerLP = R.id.one_player_lp;
    int playerLP50 = R.id.one_player_lp_50;
    int playerLP100 = R.id.one_player_lp_100;
    int playerLP500 = R.id.one_player_lp_500;
    int playerLP1000 = R.id.one_player_lp_1000;
    static Activity activity;

    public OptionsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_options, container, false);

        activity = getActivity();

        EditText lp = (EditText) rootView.findViewById(playerLP);
        EditText lp50 = (EditText) rootView.findViewById(playerLP50);
        EditText lp100 = (EditText) rootView.findViewById(playerLP100);
        EditText lp500 = (EditText) rootView.findViewById(playerLP500);
        EditText lp1000 = (EditText) rootView.findViewById(playerLP1000);

        Context context = getActivity().getApplicationContext();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        lp.setHint(prefs.getString(context.getString(R.string.pref_life_points_key), context.getString(R.string.pref_life_points_default)));
        lp50.setHint(prefs.getString(context.getString(R.string.pref_life_points_key_50), context.getString(R.string.pref_life_points_default_50)));
        lp100.setHint(prefs.getString(context.getString(R.string.pref_life_points_key_100), context.getString(R.string.pref_life_points_default_100)));
        lp500.setHint(prefs.getString(context.getString(R.string.pref_life_points_key_500), context.getString(R.string.pref_life_points_default_500)));
        lp1000.setHint(prefs.getString(context.getString(R.string.pref_life_points_key_1000), context.getString(R.string.pref_life_points_default_1000)));

        return rootView;
    }

    @Override
    public void onClick(View v) {

    }

    public static void back() {
        activity.finish();
    }
}
