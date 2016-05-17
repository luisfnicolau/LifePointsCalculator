package com.example.luis.lifepointscalculator;

import android.app.ActionBar;
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

public class OnePlayerActivity extends FragmentActivity implements ActionBar.TabListener {

    ActionBar actionBar;
    ViewPager viewPager;
    FragmentPagerAdapter ft;
    SharedPreferences prefs;
    Context context;
    int initialLP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_one_player);


        context = getApplicationContext();
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        initialLP = Integer.parseInt(prefs.getString(context.getString(R.string.pref_life_points_key), context.getString(R.string.pref_life_points_default)));

        viewPager = (ViewPager) findViewById(R.id.pager);
        ft = new FragmentPageAdapter(getSupportFragmentManager());

        viewPager.setAdapter(ft);

        FirstPlayerFragment.addLifePoints(initialLP);
        SecondPlayerFragment.addLifePoints(initialLP);
        ThirdPlayerFragment.addLifePoints(initialLP);
        FourthPlayerFragment.addLifePoints(initialLP);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

    }

    public void settings(View view) {
        Intent intent = new Intent(context, OptionsActivity.class);
        startActivity(intent);
    }
}