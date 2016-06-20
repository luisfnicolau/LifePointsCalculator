package com.example.luis.lifepointscalculator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class FourthPlayerFragment extends Fragment implements View.OnClickListener {

    View rootView;
    final int calcBut = R.id.calculate_button;
    final int playerLP = R.id.one_player_lp;
    final int undoBut = R.id.undo_button;
    final int newGame = R.id.new_game_button;
    final int plus50 = R.id.button_50_plus;
    final int plus100 = R.id.button_100_plus;
    final int plus500 = R.id.button_500_plus;
    final int plus1000 = R.id.button_1000_plus;
    final int minus50 = R.id.button_50_minus;
    final int minus100 = R.id.button_100_minus;
    final int minus500 = R.id.button_500_minus;
    final int minus1000 = R.id.button_1000_minus;
    final int multiPane = R.id.multi_pane_button;
    final int text50 = R.id.points_text_50;
    final int text100 = R.id.points_text_100;
    final int text500 = R.id.points_text_500;
    final int text1000 = R.id.points_text_1000;

    EditText player4Name;

    String playerName;
    int gainLP = 0;
    int lifePoints;
    static public ArrayList<Integer> listLifePoints = new ArrayList<>();
    final int LANDSCAPE = Configuration.ORIENTATION_LANDSCAPE;
    Context context;
    SharedPreferences prefs;


    public FourthPlayerFragment() {
        if (listLifePoints.size() != 0) {
            lifePoints = listLifePoints.get(listLifePoints.size() - 1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_one_player, container, false);

        context = getActivity().getApplicationContext();

        prefs = PreferenceManager.getDefaultSharedPreferences(context);

        playerName = prefs.getString(context.getString(R.string.pref_name_key_player4), context.getString(R.string.pref_default_player4));

        player4Name = (EditText) rootView.findViewById(R.id.player_name);
        player4Name.setText(this.playerName);

        TextView lpGainView = (TextView) rootView.findViewById(R.id.one_player_lp);
        lpGainView.setText(String.valueOf(lifePoints));

        ImageButton calculateButton = (ImageButton) rootView.findViewById(calcBut);
        Button onePlayerLP = (Button) rootView.findViewById(playerLP);
        ImageButton undoButton = (ImageButton) rootView.findViewById(undoBut);
        Button newGameButton = (Button) rootView.findViewById(newGame);
        Button plus50Button = (Button) rootView.findViewById(plus50);
        Button plus100Button = (Button) rootView.findViewById(plus100);
        Button plus500Button = (Button) rootView.findViewById(plus500);
        Button plus1000Button = (Button) rootView.findViewById(plus1000);
        Button minus50Button = (Button) rootView.findViewById(minus50);
        Button minus100Button = (Button) rootView.findViewById(minus100);
        Button minus500Button = (Button) rootView.findViewById(minus500);
        Button minus1000Button = (Button) rootView.findViewById(minus1000);
        ImageButton multiPaneButton = (ImageButton) rootView.findViewById(multiPane);
        TextView textView50 = (TextView) rootView.findViewById(text50);
        TextView textView100 = (TextView) rootView.findViewById(text100);
        TextView textView500 = (TextView) rootView.findViewById(text500);
        TextView textView1000 = (TextView) rootView.findViewById(text1000);

        onePlayerLP.setText(listLifePoints.get(listLifePoints.size() - 1).toString());
        textView50.setText(prefs.getString(context.getString(R.string.pref_life_points_key_50), context.getString(R.string.pref_life_points_default_50)));
        textView100.setText(prefs.getString(context.getString(R.string.pref_life_points_key_100), context.getString(R.string.pref_life_points_default_100)));
        textView500.setText(prefs.getString(context.getString(R.string.pref_life_points_key_500), context.getString(R.string.pref_life_points_default_500)));
        textView1000.setText(prefs.getString(context.getString(R.string.pref_life_points_key_1000), context.getString(R.string.pref_life_points_default_1000)));


        calculateButton.setOnClickListener(this);
        onePlayerLP.setOnClickListener(this);
        undoButton.setOnClickListener(this);
        newGameButton.setOnClickListener(this);
        plus50Button.setOnClickListener(this);
        plus100Button.setOnClickListener(this);
        plus500Button.setOnClickListener(this);
        plus1000Button.setOnClickListener(this);
        minus50Button.setOnClickListener(this);
        minus100Button.setOnClickListener(this);
        minus500Button.setOnClickListener(this);
        minus1000Button.setOnClickListener(this);
        multiPaneButton.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();
        TextView view = (TextView) rootView.findViewById(R.id.one_player_lp);
        view.setText(listLifePoints.get(listLifePoints.size() - 1).toString());
    }


    @Override
    public void onClick(View v) {
        TextView lpGainView = (TextView) rootView.findViewById(R.id.one_player_lp_to_change);
        lpGainView.setVisibility(View.VISIBLE);
        int screenOrientation = getScreenOrientation();
        SharedPreferences.Editor editor = prefs.edit();

        switch (v.getId()) {

            case undoBut:
                lpGainView.setVisibility(View.INVISIBLE);
                if (listLifePoints.size() > 1) {
                    listLifePoints.remove(listLifePoints.size() - 1);
                    lifePoints = listLifePoints.get(listLifePoints.size() - 1);
                    TextView lpView = (TextView) rootView.findViewById(R.id.one_player_lp);
                    lpView.setText(String.valueOf(lifePoints));
                }
                else{
                    lifePoints = Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key), context.getString(R.string.pref_life_points_default)));
                    TextView lpView = (TextView) rootView.findViewById(R.id.one_player_lp);
                    lpView.setText(String.valueOf(lifePoints));
                }
                editor.putInt(context.getString(R.string.first_player_lp), lifePoints);
                editor.commit();
                gainLP = 0;
                break;

            case playerLP:

            case calcBut:
                if(gainLP != 0) {
                    lifePoints = listLifePoints.get(listLifePoints.size() - 1) + gainLP;
                    TextView lpView = (TextView) rootView.findViewById(R.id.one_player_lp);

                    if (lifePoints >= 10000 && screenOrientation == LANDSCAPE) {
                        lpView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 64);
                    }
                    else if (lifePoints < 10000 && lpView.getTextSize() != 72 && screenOrientation == LANDSCAPE) {
                        lpView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 72);
                    }

                    if (lifePoints <= 0) {
                        Toast.makeText(getActivity().getApplicationContext(), "Game Over", Toast.LENGTH_LONG).show();
                        lifePoints = 0;
                    }
                    gainLP = 0;
                    lpView.setText(String.valueOf(lifePoints));
                    listLifePoints.add(lifePoints);
                    editor = prefs.edit();
                    editor.putInt(context.getString(R.string.fourth_player_lp), lifePoints);
                    editor.commit();
                }
                lpGainView.setVisibility(View.INVISIBLE);
                break;

            case newGame:
                resetGame();
                lpGainView.setVisibility(View.INVISIBLE);
                break;

            case multiPane:
                lpGainView.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(getActivity().getApplicationContext(), MultiPlayerActivity.class);
                startActivity(intent);
                break;

            case plus50:
                gainLP = gainLP + Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key_50), context.getString(R.string.pref_life_points_default_50)));;
                lpGainView.setText(String.valueOf(gainLP));
                break;

            case plus100:
                gainLP = gainLP + Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key_100), context.getString(R.string.pref_life_points_default_100)));
                lpGainView.setText(String.valueOf(gainLP));
                break;

            case plus500:
                gainLP = gainLP + Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key_500), context.getString(R.string.pref_life_points_default_500)));
                lpGainView.setText(String.valueOf(gainLP));
                break;

            case plus1000:
                gainLP = gainLP + Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key_1000), context.getString(R.string.pref_life_points_default_1000)));
                lpGainView.setText(String.valueOf(gainLP));
                break;

            case minus50:
                gainLP = gainLP - Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key_50), context.getString(R.string.pref_life_points_default_50)));;
                lpGainView.setText(String.valueOf(gainLP));
                break;

            case minus100:
                gainLP = gainLP - Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key_100), context.getString(R.string.pref_life_points_default_100)));
                lpGainView.setText(String.valueOf(gainLP));
                break;

            case minus500:
                gainLP = gainLP - Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key_500), context.getString(R.string.pref_life_points_default_500)));
                lpGainView.setText(String.valueOf(gainLP));
                break;

            case minus1000:
                gainLP = gainLP - Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key_1000), context.getString(R.string.pref_life_points_default_1000)));
                lpGainView.setText(String.valueOf(gainLP));
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (prefs != null) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(context.getString(R.string.pref_name_key_player4), player4Name.getText().toString());
            editor.commit();
        }
        ArrayList<String> token = new ArrayList<>();
        for (int i = 0; i < listLifePoints.size(); i++){
            token.add(String.valueOf(listLifePoints.get(i)));
        }
        outState.putStringArrayList("list", token);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        if (Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key), context.getString(R.string.pref_life_points_default))) != listLifePoints.get(0)) {
            resetGame();
        }
        ArrayList<String> token = new ArrayList<>();
        if (savedInstanceState != null) {
            token = savedInstanceState.getStringArrayList("list");
            for (String s : token) {
                listLifePoints.add(Integer.parseInt(s));
            }
            TextView lpView = (TextView) rootView.findViewById(R.id.one_player_lp);
            lpView.setText(String.valueOf(listLifePoints.get(listLifePoints.size() - 1)));
        }
        super.onViewStateRestored(savedInstanceState);
    }

    public void resetGame() {
        lifePoints = Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key), context.getString(R.string.pref_life_points_default)));
        gainLP = 0;
        listLifePoints.clear();
        listLifePoints.add(lifePoints);
        TextView textView = (TextView) rootView.findViewById(R.id.one_player_lp);
        textView.setText(String.valueOf(lifePoints));
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(context.getString(R.string.fourth_player_lp), -1);
        editor.commit();
    }

    static public ArrayList<Integer> getListLifePoints() {
        return listLifePoints;
    }

    public static  void setListLifePoints(ArrayList<Integer> lifeP) {
        listLifePoints = lifeP;
    }

    public static void addLifePoints(int lPoints) {
        listLifePoints.add(lPoints);
    }

    public static void removeLastLifePoints() {
        listLifePoints.remove(listLifePoints.size() - 1);
    }

    public int getScreenOrientation()
    {
        return getActivity().getResources().getConfiguration().orientation;
    }


}
