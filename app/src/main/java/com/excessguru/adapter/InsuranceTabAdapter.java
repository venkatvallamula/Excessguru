package com.excessguru.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.excessguru.view.AnnualFragment;
import com.excessguru.view.DailyFragment;

public class InsuranceTabAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    public InsuranceTabAdapter(FragmentManager fm, int NoofTabs){
        super(fm);
        this.mNumOfTabs = NoofTabs;
    }
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                DailyFragment dailyFragment = new DailyFragment();
                return dailyFragment;
            case 1:
                AnnualFragment annualFragment = new AnnualFragment();
                return annualFragment;
            default:
                return null;
        }
    }
}
