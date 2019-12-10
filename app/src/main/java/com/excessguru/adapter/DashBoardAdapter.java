package com.excessguru.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.excessguru.R;
import com.excessguru.model.DashBoardItems;

import java.util.List;

public class DashBoardAdapter extends RecyclerView.Adapter<DashBoardAdapter.MyViewHolder> {

    private List<DashBoardItems> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);

        }
    }


    public DashBoardAdapter(List<DashBoardItems> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dash_board_items, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DashBoardItems items = moviesList.get(position);
        holder.title.setText(items.getInsuranceType());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}