package com.example.luis.lifepointscalculator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class OptionsActivity extends FragmentActivity {

    String LP;
    String LP50;
    String LP100;
    String LP500;
    String LP1000;
    EditText lifePointsText;
    EditText lifePointsText50;
    EditText lifePointsText100;
    EditText lifePointsText500;
    EditText lifePointsText1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_options);
        lifePointsText = (EditText)findViewById(R.id.one_player_lp);
        lifePointsText50 = (EditText)findViewById(R.id.one_player_lp_50);
        lifePointsText100 = (EditText)findViewById(R.id.one_player_lp_100);
        lifePointsText500 = (EditText)findViewById(R.id.one_player_lp_500);
        lifePointsText1000 = (EditText)findViewById(R.id.one_player_lp_1000);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void resetValues (View view) {
        LP = "8000";
        LP50 = "50";
        LP100 = "100";
        LP500 = "500";
        LP1000 = "1000";
        lifePointsText.setText(LP);
        lifePointsText50.setText(LP50);
        lifePointsText100.setText(LP100);
        lifePointsText500.setText(LP500);
        lifePointsText1000.setText(LP1000);
    }

    public void setModifications(View view) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Context context = getApplicationContext();
        LP = prefs.getString(context.getString(R.string.pref_life_points_key), context.getString(R.string.pref_life_points_default));
        LP50 = prefs.getString(context.getString(R.string.pref_life_points_key_50), context.getString(R.string.pref_life_points_default_50));
        LP100 = prefs.getString(context.getString(R.string.pref_life_points_key_100), context.getString(R.string.pref_life_points_default_100));
        LP500 = prefs.getString(context.getString(R.string.pref_life_points_key_500), context.getString(R.string.pref_life_points_default_500));
        LP1000 = prefs.getString(context.getString(R.string.pref_life_points_key_1000), context.getString(R.string.pref_life_points_default_1000));

        if (!lifePointsText.getText().toString().equals("")) {
            LP = lifePointsText.getText().toString();
        }
        if (!lifePointsText50.getText().toString().equals("")) {
            LP50 = lifePointsText50.getText().toString();
        }
        if (!lifePointsText100.getText().toString().equals("")) {
            LP100 = lifePointsText100.getText().toString();
        }
        if (!lifePointsText500.getText().toString().equals("")) {
            LP500 = lifePointsText500.getText().toString();
        }
        if (!lifePointsText1000.getText().toString().equals("")) {
            LP1000 = lifePointsText1000.getText().toString();
        }
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(context.getString(R.string.pref_life_points_key), LP);
        editor.putString(context.getString(R.string.pref_life_points_key_50), LP50);
        editor.putString(context.getString(R.string.pref_life_points_key_100), LP100);
        editor.putString(context.getString(R.string.pref_life_points_key_500), LP500);
        editor.putString(context.getString(R.string.pref_life_points_key_1000), LP1000);
        editor.commit();

        Intent intent = new Intent(context, OnePlayerActivity.class);
        startActivity(intent);
    }

    public void back (View view) {
        OptionsActivityFragment.back();
    }
}
