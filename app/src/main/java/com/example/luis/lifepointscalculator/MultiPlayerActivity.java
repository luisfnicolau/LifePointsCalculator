package com.example.luis.lifepointscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class MultiPlayerActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_multi_player);

//        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544/6300978111");
//
//        final com.google.android.gms.ads.AdView mAdView = (com.google.android.gms.ads.AdView) findViewById(R.id.adView);
//        if (mAdView != null) {
//            AdRequest adRequest = new AdRequest.Builder().build();
//            mAdView.loadAd(adRequest);
//            mAdView.setAdListener(new AdListener() {
//                @Override
//                public void onAdLoaded() {
//                    super.onAdLoaded();
//                    mAdView.setVisibility(View.VISIBLE);
//                }
//            });
//        }
    }

    public void settings(View view) {
        Intent intent = new Intent(getApplicationContext(), OptionsActivity.class);
        startActivity(intent);
    }




//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_multi_player, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
