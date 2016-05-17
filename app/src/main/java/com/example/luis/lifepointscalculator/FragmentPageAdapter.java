package com.example.luis.lifepointscalculator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Luis on 09/09/2015.
 */
public class FragmentPageAdapter extends FragmentPagerAdapter {

    int mainPosition;

    public FragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        mainPosition = position;
        switch (position) {
            case 0:
                return new FirstPlayerFragment();
            case 1:
                return new SecondPlayerFragment();
            case 2:
                return new ThirdPlayerFragment();
            case 3:
                return new FourthPlayerFragment();
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
