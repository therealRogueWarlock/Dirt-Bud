package com.github.therealroguewarlock.dirtbud.ui.garage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.therealroguewarlock.dirtbud.R;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;

import java.util.ArrayList;

public class DirtBikeListAdapter  extends RecyclerView.Adapter<DirtBikeListAdapter.ViewHolder>{
    private ArrayList<DirtBike> dirtBikes;

    public DirtBikeListAdapter(ArrayList<DirtBike> dirtBikes) {
        this.dirtBikes = dirtBikes;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_card_dirt_bike,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.brand.setText(dirtBikes.get(position).getBrand());
        holder.displacment.setText(String.valueOf(dirtBikes.get(position).getDisplacement()));
    }

    @Override
    public int getItemCount() {
        return dirtBikes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView brand, displacment;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            brand = itemView.findViewById(R.id.brand);
            displacment = itemView.findViewById(R.id.displacement);

        }
    }

}
