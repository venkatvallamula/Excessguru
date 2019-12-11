package com.excessguru.adapter;

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

public class AnnualAdapter extends RecyclerView.Adapter<AnnualAdapter.MyViewHolder> {

    private List<InsuranceListItems> moviesList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, price;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.tvTripType);
            price = (TextView) view.findViewById(R.id.tvPrice);

        }
    }
    public AnnualAdapter(Context context, List<InsuranceListItems> moviesList) {
        this.moviesList = moviesList;
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.daily_items_rows, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        InsuranceListItems items = moviesList.get(position);
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
        return moviesList.size();
    }
}