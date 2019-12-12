package com.excessguru.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.excessguru.R;
import com.excessguru.model.DashBoardItems;
import com.excessguru.view.InsuranceListFragment;
import com.excessguru.view.MainActivity;

import java.util.List;
import java.util.Objects;

public class DashBoardAdapter extends RecyclerView.Adapter<DashBoardAdapter.MyViewHolder> {

    private List<DashBoardItems> dashBoardItems;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);

        }
    }
    public DashBoardAdapter(Context context,List<DashBoardItems> moviesList) {
        this.dashBoardItems = moviesList;
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dash_board_items, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DashBoardItems items = dashBoardItems.get(position);
        holder.title.setText(items.getInsuranceType());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) Objects.requireNonNull(mContext)).changeFragment(InsuranceListFragment.newInstance());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dashBoardItems.size();
    }
}