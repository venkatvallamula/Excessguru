package com.excessguru.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.excessguru.R;
import com.excessguru.model.DashBoardItems;
import com.excessguru.model.InsuranceListItems;
import com.excessguru.view.InsuranceListFragment;
import com.excessguru.view.MainActivity;

import java.util.List;
import java.util.Objects;

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.MyViewHolder> {

    private List<InsuranceListItems> insuranceListItems;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, price;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.tvTripType);
            price = (TextView) view.findViewById(R.id.tvPrice);
        }
    }
    public DailyAdapter(Context context, List<InsuranceListItems> moviesList) {
        this.insuranceListItems = moviesList;
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.daily_items_rows, parent, false);

        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        InsuranceListItems items = insuranceListItems.get(position);
        holder.title.setText(items.getInsuranceType());
        holder.price.setText(mContext.getResources().getString(R.string.euroSymbol)+items.getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) Objects.requireNonNull(mContext)).changeFragment(InsuranceListFragment.newInstance());
            }
        });
    }

    @Override
    public int getItemCount() {
        return insuranceListItems.size();
    }
}