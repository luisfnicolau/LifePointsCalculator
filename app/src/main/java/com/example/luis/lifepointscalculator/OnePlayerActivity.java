package com.example.luis.lifepointscalculator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;

public class OnePlayerActivity extends FragmentActivity {

    ViewPager viewPager;
    FragmentPagerAdapter ft;
    SharedPreferences prefs;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        context = getApplicationContext();

        setContentView(R.layout.activity_one_player);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544/6300978111");

        final com.google.android.gms.ads.AdView mAdView = (com.google.android.gms.ads.AdView) findViewById(R.id.adViewOnePlayer);
        if (mAdView != null) {
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
            mAdView.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    mAdView.setVisibility(View.VISIBLE);
                }
            });
        }

        prefs = PreferenceManager.getDefaultSharedPreferences(context);

        int lastLPFirst = prefs.getInt(getApplicationContext().getString(R.string.first_player_lp), -1);
        int lastLPSecond = prefs.getInt(getApplicationContext().getString(R.string.second_player_lp), -1);
        int lastLPThird = prefs.getInt(getApplicationContext().getString(R.string.third_player_lp), -1);
        int lastLPFourth = prefs.getInt(getApplicationContext().getString(R.string.fourth_player_lp), -1);

        int initialLPFirst;
        int initialLPSecond;
        int initialLPThird;
        int initialLPFourth;

        if (lastLPFirst >= 0)
            initialLPFirst = lastLPFirst;
        else
            initialLPFirst = Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key), context.getString(R.string.pref_life_points_default)));

        if (lastLPSecond >= 0)
            initialLPSecond = lastLPSecond;
        else
            initialLPSecond = Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key), context.getString(R.string.pref_life_points_default)));

        if (lastLPThird >= 0)
            initialLPThird = lastLPThird;
        else
            initialLPThird = Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key), context.getString(R.string.pref_life_points_default)));

        if (lastLPFourth >= 0)
            initialLPFourth = lastLPFourth;
        else
            initialLPFourth = Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key), context.getString(R.string.pref_life_points_default)));

        viewPager = (ViewPager) findViewById(R.id.pager);
        ft = new FragmentPageAdapter(getSupportFragmentManager());

        viewPager.setAdapter(ft);
        FirstPlayerFragment.addLifePoints(Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key), context.getString(R.string.pref_life_points_default))));
        FirstPlayerFragment.addLifePoints(initialLPFirst);
        SecondPlayerFragment.addLifePoints(Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key), context.getString(R.string.pref_life_points_default))));
        SecondPlayerFragment.addLifePoints(initialLPSecond);
        ThirdPlayerFragment.addLifePoints(Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key), context.getString(R.string.pref_life_points_default))));
        ThirdPlayerFragment.addLifePoints(initialLPThird);
        FourthPlayerFragment.addLifePoints(Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key), context.getString(R.string.pref_life_points_default))));
        FourthPlayerFragment.addLifePoints(initialLPFourth);

    }


    public void settings(View view) {
        Intent intent = new Intent(context, OptionsActivity.class);
        startActivity(intent);
    }
}