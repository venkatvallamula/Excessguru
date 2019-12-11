package com.excessguru.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.excessguru.R;
import com.excessguru.adapter.InsuranceTabAdapter;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InsuranceListFragment extends Fragment {
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private InsuranceTabAdapter insuranceTabAdapter;
public static InsuranceListFragment newInstance() {
    return new InsuranceListFragment();
}

@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                         @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_insurance_list, container, false);
    ButterKnife.bind(this, rootView);
    tabLayout.addTab(tabLayout.newTab().setText("Daily"));
    tabLayout.addTab(tabLayout.newTab().setText("Annual"));
    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    insuranceTabAdapter = new InsuranceTabAdapter(getFragmentManager(),tabLayout.getTabCount());
    viewPager.setAdapter(insuranceTabAdapter);
    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    });
    return rootView;
}




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mViewModel = ViewModelProviders.of(this).get(DashBoardViewModel.class);
        // TODO: Use the ViewModel
    }

}
