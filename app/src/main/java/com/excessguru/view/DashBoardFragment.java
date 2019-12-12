package com.excessguru.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.excessguru.R;
import com.excessguru.adapter.DashBoardAdapter;
import com.excessguru.model.DashBoardItems;
import com.excessguru.viewmodel.DashBoardViewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashBoardFragment extends Fragment {

    private DashBoardViewModel mViewModel;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    DashBoardAdapter dashBoardAdapter;
    private ArrayList<DashBoardItems> itemlist = new ArrayList<>();
    private String[] items = {"CAR HIRE EXCESS INSURANCE","PRIVATE CAR HIRE EXCESS INSURANCE","VAN & CV EXCESS INSURANCE","CLAIMS",
            "FAQ'S","ABOUT US","CONTACT US"};
    private ArrayList<DashBoardItems> arrayList;

    public static DashBoardFragment newInstance() {
        return new DashBoardFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dash_board_fragment, container, false);
        ButterKnife.bind(this, rootView);
        setUp();
        return rootView;
    }
    private void setUp() {
        itemlist = proResult();
        dashBoardAdapter = new DashBoardAdapter(getActivity(),itemlist);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(dashBoardAdapter);
    }

    private ArrayList<DashBoardItems> proResult() {
        ArrayList<DashBoardItems> arrayList = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            DashBoardItems dashBoardItems = new DashBoardItems();
            dashBoardItems.setInsuranceType(items[i]);
            arrayList.add(dashBoardItems);
        }
        return arrayList;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DashBoardViewModel.class);
        // TODO: Use the ViewModel
    }

}
