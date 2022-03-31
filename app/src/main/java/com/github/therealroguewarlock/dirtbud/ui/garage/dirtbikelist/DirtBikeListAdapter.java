package com.github.therealroguewarlock.dirtbud.ui.garage.dirtbikelist;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.therealroguewarlock.dirtbud.R;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;

import java.util.ArrayList;
import java.util.List;

public class DirtBikeListAdapter extends RecyclerView.Adapter<DirtBikeListAdapter.ViewHolder> {
	private List<DirtBike> dirtBikeList = new ArrayList<>();

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View view = inflater.inflate(R.layout.list_card, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		// Brand
		holder.headerDirtBikeBrand.setText(R.string.card_info_bike_brand);
		holder.textDirtBikeBrand.setText(dirtBikeList.get(position).getBrand());

		// Displacement
		holder.headerDirtBikeDisplacement.setText(R.string.card_info_bike_displacement);
		holder.textDirtBikeDisplacement.setText(String.valueOf(dirtBikeList.get(position).getDisplacement()));

		// Image
		holder.imgDirtBike.setBackgroundColor(funColor(position));
	}

	private int funColor(int seed) {
		return Color.argb((seed * dirtBikeList.size() * 20) % 100, (seed * 32 + dirtBikeList.size() * dirtBikeList.size()) % 255, (((seed % 4) == 0) ? 18 : (((seed % 3) == 0) ? seed : ((32 * seed) + 20))) % 255, (seed * 196) % 255);
	}

	@Override
	public int getItemCount() {
		return dirtBikeList.size();
	}

	public void setBikeList(List<DirtBike> dirtBikes) {
		dirtBikeList = (dirtBikes == null) ? new ArrayList<>() : dirtBikes;
		notifyDataSetChanged();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		private final TextView headerDirtBikeBrand, headerDirtBikeDisplacement;
		private final TextView textDirtBikeBrand, textDirtBikeDisplacement;
		private final ImageView imgDirtBike;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			headerDirtBikeBrand = itemView.findViewById(R.id.header_one);
			headerDirtBikeDisplacement = itemView.findViewById(R.id.header_two);
			textDirtBikeBrand = itemView.findViewById(R.id.text_box_one);
			textDirtBikeDisplacement = itemView.findViewById(R.id.text_box_two);
			imgDirtBike = itemView.findViewById(R.id.img_dirt_bike);
		}
	}

}
