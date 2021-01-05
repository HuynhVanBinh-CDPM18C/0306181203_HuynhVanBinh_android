package com.example.demo11_11;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> dsFragment = new ArrayList<>();
    private List<String> dsTitle = new ArrayList<>();

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return dsFragment.get(i);
    }

    @Override
    public int getCount() {
        return dsFragment.size();
    }
    public void addFragment(Fragment fragment, String title){
        dsFragment.add(fragment);
        dsTitle.add(title);
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return dsTitle.get(position);
    }
}
