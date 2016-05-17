package com.example.luis.lifepointscalculator;

import android.content.Context;
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
public class MultiPlayerActivityFragment extends Fragment implements View.OnClickListener {

    View rootView;
    final int singlePaneBtn = R.id.single_pane_button;
    final int newGameBtn = R.id.multi_new_game;
    final int lpToGainBtn = R.id.multi_lp_to_gain;
    final int firstPlayerLPBtn = R.id.player_one_button;
    final int secondPlayerLPBtn = R.id.player_two_button;
    final int thirdPlayerLPBtn = R.id.player_three_button;
    final int fourthPlayerLPBtn = R.id.player_four_button;
    final int firstPlayerBackBtn = R.id.player_one_back_button;
    final int secondPlayerBackBtn = R.id.player_two_back_button;
    final int thirdPlayerBackBtn = R.id.player_three_back_button;
    final int fourthPlayerBackBtn = R.id.player_four_back_button;
    final int plus50 = R.id.multi_button_50_plus;
    final int plus100 = R.id.multi_button_100_plus;
    final int plus500 = R.id.multi_button_500_plus;
    final int plus1000 = R.id.multi_button_1000_plus;
    final int minus50 = R.id.multi_button_50_minus;
    final int minus100 = R.id.multi_button_100_minus;
    final int minus500 = R.id.multi_button_500_minus;
    final int minus1000 = R.id.multi_button_1000_minus;
    final int text50 = R.id.points_text_50;
    final int text100 = R.id.points_text_100;
    final int text500 = R.id.points_text_500;
    final int text1000 = R.id.points_text_1000;

    EditText player1name;
    EditText player2name;
    EditText player3name;
    EditText player4name;

    final int PORTRAIT = Configuration.ORIENTATION_PORTRAIT;
    final int LANDSCAPE = Configuration.ORIENTATION_LANDSCAPE;

    Button firstPlayerButton;
    Button secondPlayerButton;
    Button thirdPlayerButton;
    Button fourthPlayerButton;
    Button lpGainViewButton;

    ArrayList<Integer> listLifePoints1;
    ArrayList<Integer> listLifePoints2;
    public static ArrayList<Integer> listLifePoints3;
    public static ArrayList<Integer> listLifePoints4;

    Context context;
    SharedPreferences prefs;

    int gainLP = 0;

    public MultiPlayerActivityFragment() {
        listLifePoints1 = new ArrayList<Integer>(FirstPlayerFragment.getListLifePoints());
        listLifePoints2 = new ArrayList<Integer>(SecondPlayerFragment.getListLifePoints());
        listLifePoints3 = new ArrayList<Integer>(ThirdPlayerFragment.getListLifePoints());
        listLifePoints4 = new ArrayList<Integer>(FourthPlayerFragment.getListLifePoints());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_multi_player, container, false);

        context = getActivity().getApplicationContext();

        prefs = PreferenceManager.getDefaultSharedPreferences(context);

        ImageButton singlePaneButton = (ImageButton) rootView.findViewById(singlePaneBtn);
        Button newGameButton = (Button) rootView.findViewById(newGameBtn);
        firstPlayerButton = (Button) rootView.findViewById(firstPlayerLPBtn);
        secondPlayerButton = (Button) rootView.findViewById(secondPlayerLPBtn);
        thirdPlayerButton = (Button) rootView.findViewById(thirdPlayerLPBtn);
        fourthPlayerButton = (Button) rootView.findViewById(fourthPlayerLPBtn);
        lpGainViewButton = (Button) rootView.findViewById(lpToGainBtn);
        ImageButton firstPlayerBackButton = (ImageButton) rootView.findViewById(firstPlayerBackBtn);
        ImageButton secondPlayerBackButton = (ImageButton) rootView.findViewById(secondPlayerBackBtn);
        ImageButton thirdPlayerBackButton = (ImageButton) rootView.findViewById(thirdPlayerBackBtn);
        ImageButton fourthPlayerBackButton = (ImageButton) rootView.findViewById(fourthPlayerBackBtn);
        Button plus50Button = (Button) rootView.findViewById(plus50);
        Button plus100Button = (Button) rootView.findViewById(plus100);
        Button plus500Button = (Button) rootView.findViewById(plus500);
        Button plus1000Button = (Button) rootView.findViewById(plus1000);
        Button minus50Button = (Button) rootView.findViewById(minus50);
        Button minus100Button = (Button) rootView.findViewById(minus100);
        Button minus500Button = (Button) rootView.findViewById(minus500);
        Button minus1000Button = (Button) rootView.findViewById(minus1000);
        TextView textView50 = (TextView) rootView.findViewById(text50);
        TextView textView100 = (TextView) rootView.findViewById(text100);
        TextView textView500 = (TextView) rootView.findViewById(text500);
        TextView textView1000 = (TextView) rootView.findViewById(text1000);

        player1name = (EditText) rootView.findViewById(R.id.player_1_name);
        player2name = (EditText) rootView.findViewById(R.id.player_2_name);
        player3name = (EditText) rootView.findViewById(R.id.player_3_name);
        player4name = (EditText) rootView.findViewById(R.id.player_4_name);

        player1name.setText(prefs.getString(context.getString(R.string.pref_name_key_player1), context.getString(R.string.pref_default_player1)));
        player2name.setText(prefs.getString(context.getString(R.string.pref_name_key_player2), context.getString(R.string.pref_default_player2)));
        player3name.setText(prefs.getString(context.getString(R.string.pref_name_key_player3), context.getString(R.string.pref_default_player3)));
        player4name.setText(prefs.getString(context.getString(R.string.pref_name_key_player4), context.getString(R.string.pref_default_player4)));

        textView50.setText(prefs.getString(context.getString(R.string.pref_life_points_key_50), context.getString(R.string.pref_life_points_default_50)));
        textView100.setText(prefs.getString(context.getString(R.string.pref_life_points_key_100), context.getString(R.string.pref_life_points_default_100)));
        textView500.setText(prefs.getString(context.getString(R.string.pref_life_points_key_500), context.getString(R.string.pref_life_points_default_500)));
        textView1000.setText(prefs.getString(context.getString(R.string.pref_life_points_key_1000), context.getString(R.string.pref_life_points_default_1000)));


        int LP1 = listLifePoints1.get(listLifePoints1.size() - 1);
        int LP2 = listLifePoints2.get(listLifePoints2.size() - 1);
        int LP3 = listLifePoints3.get(listLifePoints3.size() - 1);
        int LP4 = listLifePoints4.get(listLifePoints4.size() - 1);

        int screenOrientation = getScreenOrientation();

        if (LP1 >= 10000 && screenOrientation == PORTRAIT ) {
            firstPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 42);
        } else if (LP1 < 10000 && firstPlayerButton.getTextSize() != 54 && screenOrientation == PORTRAIT) {
            firstPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 54);
        } else if (LP1 >= 10000 && screenOrientation == LANDSCAPE) {
            firstPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        }
        else if (LP1 < 10000 && firstPlayerButton.getTextSize() != 36 && screenOrientation == LANDSCAPE) {
            firstPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
        }

        if (LP2 >= 10000 && screenOrientation == PORTRAIT) {
            secondPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 42);
        } else if (LP2 < 10000 && secondPlayerButton.getTextSize() != 54 && screenOrientation == PORTRAIT) {
            secondPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 54);
        } else if (LP2 >= 10000 && screenOrientation == LANDSCAPE) {
            secondPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        }
        else if (LP2 < 10000 && secondPlayerButton.getTextSize() != 36 && screenOrientation == LANDSCAPE) {
            secondPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
        }

        if (LP3 >= 10000 && screenOrientation == PORTRAIT) {
            thirdPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 42);
        } else if (LP3 < 10000 && thirdPlayerButton.getTextSize() != 54 && screenOrientation == PORTRAIT) {
            thirdPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 54);
        } else if (LP3 >= 10000 && screenOrientation == LANDSCAPE) {
            thirdPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        }
        else if (LP3 < 10000 && thirdPlayerButton.getTextSize() != 36 && screenOrientation == LANDSCAPE) {
            thirdPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
        }

        if (LP4 >= 10000 && screenOrientation == PORTRAIT) {
            fourthPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 42);
        } else if (LP4 < 10000 && fourthPlayerButton.getTextSize() != 54 && screenOrientation == PORTRAIT) {
            fourthPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 54);
        } else if (LP4 >= 10000 && screenOrientation == LANDSCAPE) {
            fourthPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        }
        else if (LP4 < 10000 && fourthPlayerButton.getTextSize() != 36 && screenOrientation == LANDSCAPE) {
            fourthPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
        }

        firstPlayerButton.setText(listLifePoints1.get(listLifePoints1.size() - 1).toString());
        secondPlayerButton.setText(listLifePoints2.get(listLifePoints2.size() - 1).toString());
        thirdPlayerButton.setText(listLifePoints3.get(listLifePoints3.size() - 1).toString());
        fourthPlayerButton.setText(listLifePoints4.get(listLifePoints4.size() - 1).toString());


        singlePaneButton.setOnClickListener(this);
        newGameButton.setOnClickListener(this);
        lpGainViewButton.setOnClickListener(this);
        firstPlayerButton.setOnClickListener(this);
        secondPlayerButton.setOnClickListener(this);
        thirdPlayerButton.setOnClickListener(this);
        fourthPlayerButton.setOnClickListener(this);
        firstPlayerBackButton.setOnClickListener(this);
        secondPlayerBackButton.setOnClickListener(this);
        thirdPlayerBackButton.setOnClickListener(this);
        fourthPlayerBackButton.setOnClickListener(this);
        plus50Button.setOnClickListener(this);
        plus100Button.setOnClickListener(this);
        plus500Button.setOnClickListener(this);
        plus1000Button.setOnClickListener(this);
        minus50Button.setOnClickListener(this);
        minus100Button.setOnClickListener(this);
        minus500Button.setOnClickListener(this);
        minus1000Button.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {

        int LP;
        int screenOrientation = getScreenOrientation();

        switch (v.getId()) {

            case singlePaneBtn:
                getActivity().finish();
                break;

            case newGameBtn:
                eraseAll();
                int initialLP = listLifePoints1.get(listLifePoints1.size() - 1);
                firstPlayerButton.setText(String.valueOf(initialLP));
                secondPlayerButton.setText(String.valueOf(initialLP));
                thirdPlayerButton.setText(String.valueOf(initialLP));
                fourthPlayerButton.setText(String.valueOf(initialLP));
                break;

            case lpToGainBtn:
                gainLP = 0;
                lpGainViewButton.setVisibility(View.GONE);
                break;

            case firstPlayerLPBtn:
                if (gainLP != 0) {
                    LP = listLifePoints1.get(listLifePoints1.size() - 1) + gainLP;
                    if (LP <= 0) {
                        Toast.makeText(getActivity().getApplicationContext(), "Game Over", Toast.LENGTH_LONG).show();
                        LP = 0;
                    }
                    listLifePoints1.add(LP);
                    FirstPlayerFragment.addLifePoints(LP);
                    if (LP >= 10000  && screenOrientation == PORTRAIT) {
                        firstPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 42);
                    } else if (LP < 10000 && firstPlayerButton.getTextSize() != 54  && screenOrientation == PORTRAIT) {
                        firstPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 54);
                    } else if (LP >= 10000 && screenOrientation == LANDSCAPE) {
                        firstPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                    }
                    else if (LP < 10000 && firstPlayerButton.getTextSize() != 36 && screenOrientation == LANDSCAPE) {
                        firstPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                    }
                    firstPlayerButton.setText(String.valueOf(LP));
                    gainLP = 0;
                }
                lpGainViewButton.setVisibility(View.GONE);
                break;

            case secondPlayerLPBtn:
                if (gainLP != 0) {
                    LP = listLifePoints2.get(listLifePoints2.size() - 1) + gainLP;
                    if (LP <= 0) {
                        Toast.makeText(getActivity().getApplicationContext(), "Game Over", Toast.LENGTH_LONG).show();
                        LP = 0;
                    }
                    listLifePoints2.add(LP);
                    SecondPlayerFragment.addLifePoints(LP);
                    if (LP >= 10000 && screenOrientation == PORTRAIT) {
                        secondPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 42);
                    } else if (LP < 10000 && secondPlayerButton.getTextSize() != 54 && screenOrientation == PORTRAIT) {
                        secondPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 54);
                    } else if (LP >= 10000 && screenOrientation == LANDSCAPE) {
                        secondPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                    }
                    else if (LP < 10000 && secondPlayerButton.getTextSize() != 36 && screenOrientation == LANDSCAPE) {
                        secondPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                    }
                    secondPlayerButton.setText(String.valueOf(LP));
                    gainLP = 0;
                }
                lpGainViewButton.setVisibility(View.GONE);
                break;

            case thirdPlayerLPBtn:
                if (gainLP != 0) {
                    LP = listLifePoints3.get(listLifePoints3.size() - 1) + gainLP;
                    if (LP <= 0) {
                        Toast.makeText(getActivity().getApplicationContext(), "Game Over", Toast.LENGTH_LONG).show();
                        LP = 0;
                    }
                    listLifePoints3.add(LP);
                    ThirdPlayerFragment.addLifePoints(LP);
                    if (LP >= 10000 && screenOrientation == PORTRAIT) {
                        thirdPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 42);
                    } else if (LP < 10000 && thirdPlayerButton.getTextSize() != 54 && screenOrientation == PORTRAIT) {
                        thirdPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 54);
                    } else if (LP >= 10000 && screenOrientation == LANDSCAPE) {
                        thirdPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                    }
                    else if (LP < 10000 && thirdPlayerButton.getTextSize() != 36 && screenOrientation == LANDSCAPE) {
                        thirdPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                    }
                    thirdPlayerButton.setText(String.valueOf(LP));
                    gainLP = 0;
                }
                lpGainViewButton.setVisibility(View.GONE);
                break;

            case fourthPlayerLPBtn:
                if (gainLP != 0) {
                    LP = listLifePoints4.get(listLifePoints4.size() - 1) + gainLP;
                    if (LP <= 0) {
                        Toast.makeText(getActivity().getApplicationContext(), "Game Over", Toast.LENGTH_LONG).show();
                        LP = 0;
                    }
                    listLifePoints4.add(LP);
                    FourthPlayerFragment.addLifePoints(LP);
                    if (LP >= 10000 && screenOrientation == PORTRAIT) {
                        fourthPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 42);
                    } else if (LP < 10000 && fourthPlayerButton.getTextSize() != 54 && screenOrientation == PORTRAIT) {
                        fourthPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 54);
                    } else if (LP >= 10000 && screenOrientation == LANDSCAPE) {
                        fourthPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                    }
                    else if (LP < 10000 && fourthPlayerButton.getTextSize() != 36 && screenOrientation == LANDSCAPE) {
                        fourthPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                    }
                    fourthPlayerButton.setText(String.valueOf(LP));
                    gainLP = 0;
                }
                lpGainViewButton.setVisibility(View.GONE);
                break;

            case firstPlayerBackBtn:
                lpGainViewButton.setVisibility(View.GONE);
                if (listLifePoints1.size() > 1) {
                    listLifePoints1.remove(listLifePoints1.size() - 1);
                    FirstPlayerFragment.removeLastLifePoints();
                    LP = listLifePoints1.get(listLifePoints1.size() - 1);
                    if (LP >= 10000  && screenOrientation == PORTRAIT) {
                        firstPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 42);
                    } else if (LP < 10000 && firstPlayerButton.getTextSize() != 54  && screenOrientation == PORTRAIT) {
                        firstPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 54);
                    } else if (LP >= 10000 && screenOrientation == LANDSCAPE) {
                        firstPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                    }
                    else if (LP < 10000 && firstPlayerButton.getTextSize() != 36 && screenOrientation == LANDSCAPE) {
                        firstPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                    }
                    firstPlayerButton.setText(String.valueOf(LP));
                } else {
                    LP = Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key), context.getString(R.string.pref_life_points_default)));
                    firstPlayerButton.setText(String.valueOf(LP));
                }
                gainLP = 0;
                break;

            case secondPlayerBackBtn:
                lpGainViewButton.setVisibility(View.GONE);
                if (listLifePoints2.size() > 1) {
                    listLifePoints2.remove(listLifePoints2.size() - 1);
                    SecondPlayerFragment.removeLastLifePoints();
                    LP = listLifePoints2.get(listLifePoints2.size() - 1);
                    if (LP >= 10000 && screenOrientation == PORTRAIT) {
                        secondPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 42);
                    } else if (LP < 10000 && secondPlayerButton.getTextSize() != 54 && screenOrientation == PORTRAIT) {
                        secondPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 54);
                    } else if (LP >= 10000 && screenOrientation == LANDSCAPE) {
                        secondPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                    }
                    else if (LP < 10000 && secondPlayerButton.getTextSize() != 36 && screenOrientation == LANDSCAPE) {
                        secondPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                    }
                    secondPlayerButton.setText(String.valueOf(LP));
                } else {
                    LP = Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key), context.getString(R.string.pref_life_points_default)));
                    secondPlayerButton.setText(String.valueOf(LP));
                }
                gainLP = 0;
                break;

            case thirdPlayerBackBtn:
                lpGainViewButton.setVisibility(View.GONE);
                if (listLifePoints3.size() > 1) {
                    listLifePoints3.remove(listLifePoints3.size() - 1);
                    ThirdPlayerFragment.removeLastLifePoints();
                    LP = listLifePoints3.get(listLifePoints3.size() - 1);
                    if (LP >= 10000 && screenOrientation == PORTRAIT) {
                        thirdPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 42);
                    } else if (LP < 10000 && thirdPlayerButton.getTextSize() != 54 && screenOrientation == PORTRAIT) {
                        thirdPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 54);
                    } else if (LP >= 10000 && screenOrientation == LANDSCAPE) {
                        thirdPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                    }
                    else if (LP < 10000 && thirdPlayerButton.getTextSize() != 36 && screenOrientation == LANDSCAPE) {
                        thirdPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
                    }
                    thirdPlayerButton.setText(String.valueOf(LP));
                } else {
                    LP = Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key), context.getString(R.string.pref_life_points_default)));
                    thirdPlayerButton.setText(String.valueOf(LP));
                }
                gainLP = 0;
                break;

            case fourthPlayerBackBtn:
                lpGainViewButton.setVisibility(View.GONE);
                if (listLifePoints4.size() > 1) {
                    listLifePoints4.remove(listLifePoints4.size() - 1);
                    FourthPlayerFragment.removeLastLifePoints();
                    LP = listLifePoints4.get(listLifePoints4.size() - 1);
                    if (LP >= 10000 && screenOrientation == PORTRAIT) {
                        fourthPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 42);
                    } else if (LP < 10000 && fourthPlayerButton.getTextSize() != 54 && screenOrientation == PORTRAIT) {
                        fourthPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 54);
                    } else if (LP >= 10000 && screenOrientation == LANDSCAPE) {
                        fourthPlayerButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                    }
                    fourthPlayerButton.setText(String.valueOf(LP));
                } else {
                    LP = Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key), context.getString(R.string.pref_life_points_default)));
                    fourthPlayerButton.setText(String.valueOf(LP));
                }
                gainLP = 0;
                break;

            case plus50:
                gainLP = gainLP + Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key_50), context.getString(R.string.pref_life_points_default_50)));
                lpGainViewButton.setText(String.valueOf(gainLP));
                lpGainViewButton.setVisibility(View.VISIBLE);
                break;

            case plus100:
                gainLP = gainLP + Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key_100), context.getString(R.string.pref_life_points_default_100)));
                lpGainViewButton.setText(String.valueOf(gainLP));
                lpGainViewButton.setVisibility(View.VISIBLE);
                break;

            case plus500:
                gainLP = gainLP + Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key_500), context.getString(R.string.pref_life_points_default_500)));
                lpGainViewButton.setText(String.valueOf(gainLP));
                lpGainViewButton.setVisibility(View.VISIBLE);
                break;

            case plus1000:
                gainLP = gainLP + Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key_1000), context.getString(R.string.pref_life_points_default_1000)));
                lpGainViewButton.setText(String.valueOf(gainLP));
                lpGainViewButton.setVisibility(View.VISIBLE);
                break;

            case minus50:
                gainLP = gainLP - Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key_50), context.getString(R.string.pref_life_points_default_50)));
                lpGainViewButton.setText(String.valueOf(gainLP));
                lpGainViewButton.setVisibility(View.VISIBLE);
                break;

            case minus100:
                gainLP = gainLP - Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key_100), context.getString(R.string.pref_life_points_default_100)));
                lpGainViewButton.setText(String.valueOf(gainLP));
                lpGainViewButton.setVisibility(View.VISIBLE);
                break;

            case minus500:
                gainLP = gainLP - Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key_500), context.getString(R.string.pref_life_points_default_500)));
                lpGainViewButton.setText(String.valueOf(gainLP));
                lpGainViewButton.setVisibility(View.VISIBLE);
                break;

            case minus1000:
                gainLP = gainLP - Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key_1000), context.getString(R.string.pref_life_points_default_1000)));
                lpGainViewButton.setText(String.valueOf(gainLP));
                lpGainViewButton.setVisibility(View.VISIBLE);
                break;

        }

    }

    public void eraseAll() {
        for (int i = listLifePoints1.size() - 1; i > 0; i--) {
            listLifePoints1.remove(i);
            FirstPlayerFragment.removeLastLifePoints();
        }
        for (int i = listLifePoints2.size() - 1; i > 0; i--) {
            listLifePoints2.remove(i);
            SecondPlayerFragment.removeLastLifePoints();
        }
        for (int i = listLifePoints3.size() - 1; i > 0; i--) {
            listLifePoints3.remove(i);
            ThirdPlayerFragment.removeLastLifePoints();
        }
        for (int i = listLifePoints4.size() - 1; i > 0; i--) {
            listLifePoints4.remove(i);
            FourthPlayerFragment.removeLastLifePoints();
        }
    }

    public int getScreenOrientation()
    {
        return getActivity().getResources().getConfiguration().orientation;
    }
}
