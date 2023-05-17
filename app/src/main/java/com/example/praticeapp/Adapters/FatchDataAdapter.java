package com.example.praticeapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praticeapp.Models.FatchDataModel;
import com.example.praticeapp.R;

import java.util.List;

public class FatchDataAdapter extends RecyclerView.Adapter<FatchDataAdapter.MyViewHolder> {

    private final List<FatchDataModel> fatchDataModels;
    private final Context context;

    public FatchDataAdapter(List<FatchDataModel> fatchDataModels, Context context) {
        this.fatchDataModels = fatchDataModels;
        this.context = context;
    }

    @NonNull
    @Override
    public FatchDataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

         return new MyViewHolder(LayoutInflater.from(parent.getContext()). inflate(R.layout.fatchdatalist,null));
    }

    @Override
    public void onBindViewHolder(@NonNull FatchDataAdapter.MyViewHolder holder, int position) {
        //Getting MyItem details
        FatchDataModel fdm = fatchDataModels.get(position);

        //holder = setting user details to text view
        holder.routedate.setText(fdm.getDate());
        holder.routetime.setText(fdm.getBusTime());
        holder.pickup.setText(fdm.getPickup());
        holder.drop.setText(fdm.getDrop());



    }

    @Override
    public int getItemCount() {
        return fatchDataModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        private final TextView routedate,routetime, pickup, drop;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            routedate = itemView.findViewById(R.id.busdate);
            routetime = itemView.findViewById(R.id.bustime);
            pickup = itemView.findViewById(R.id.pickup);
            drop = itemView.findViewById(R.id.drop);
        }
    }
}
