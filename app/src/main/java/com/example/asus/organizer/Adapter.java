package com.example.asus.organizer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Asus on 01.08.2017.
 */

public class Adapter extends FragmentPagerAdapter {

    public Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ContactActivity();
            case 1:
                return new CallActivity();
            case 2:
                return new NotificationActivity();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Contacts";
            case 1:
                return "Calls";
            case 2:
                return "Notifications";
        }
        return null;
    }
}
