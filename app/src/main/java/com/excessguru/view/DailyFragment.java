package com.excessguru.view;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.excessguru.R;
import com.excessguru.adapter.DailyAdapter;
import com.excessguru.adapter.DashBoardAdapter;
import com.excessguru.model.DashBoardItems;
import com.excessguru.model.DashBoardViewModel;
import com.excessguru.model.InsuranceListItems;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DailyFragment extends Fragment {

    private DailyViewModel mViewModel;
    @BindView(R.id.dailyRecyclerView)
    RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    DailyAdapter dailyAdapter;
    private ArrayList<InsuranceListItems> itemlist = new ArrayList<>();
    private String[] items = {"Daily UK & Europe","Daily Worldwide (ex.CDW & SLI)","Daily Worldwide (ex.CDW & SLI)","Daily UK & Europe","Daily Worldwide (ex.CDW & SLI)","Daily Worldwide (ex.CDW & SLI)"};
    private String[] price = {"1.99","4.99","7.99","1.99","4.99","7.99"};
    private ArrayList<DashBoardItems> arrayList;

    public static DailyFragment newInstance() {
        return new DailyFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.daily_fragment, container, false);
        ButterKnife.bind(this, rootView);
        setUp();
        return rootView;
    }
    private void setUp() {
        itemlist = proResult();
        dailyAdapter = new DailyAdapter(getActivity(),itemlist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(dailyAdapter);
    }

    private ArrayList<InsuranceListItems> proResult() {
        ArrayList<InsuranceListItems> arrayList = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            InsuranceListItems insuranceListItems = new InsuranceListItems();
            insuranceListItems.setInsuranceType(items[i]);
            insuranceListItems.setPrice(price[i]);
            arrayList.add(insuranceListItems);
        }
        return arrayList;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DailyViewModel.class);
        // TODO: Use the ViewModel
    }

}
