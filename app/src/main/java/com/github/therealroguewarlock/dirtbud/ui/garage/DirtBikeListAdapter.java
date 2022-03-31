package com.github.therealroguewarlock.dirtbud.ui.garage;

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

import java.util.List;

public class DirtBikeListAdapter extends RecyclerView.Adapter<DirtBikeListAdapter.ViewHolder> {
	private final List<DirtBike> dirtBikeList;

	public DirtBikeListAdapter(List<DirtBike> dirtBikeList) {
		this.dirtBikeList = dirtBikeList;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View view = inflater.inflate(R.layout.list_card_dirt_bike, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		holder.textDirtBikeBrand.setText(dirtBikeList.get(position).getBrand());
		holder.textDirtBikeDisplacement.setText(String.valueOf(dirtBikeList.get(position).getDisplacement()));
		holder.imgDirtBike.setBackgroundColor(funColor(position));
	}

	private int funColor(int seed) {
		return Color.argb(
				(seed * dirtBikeList.size() * 20) % 100,
				(seed * 32 + dirtBikeList.size() * dirtBikeList.size()) % 255,
				(((seed % 4) == 0) ? 18 : (((seed % 3) == 0) ? seed : ((32 * 48) + 20))) % 255,
				(seed * 196) % 255
		);
	}

	@Override
	public int getItemCount() {
		return dirtBikeList.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		private final TextView textDirtBikeBrand, textDirtBikeDisplacement;
		private final ImageView imgDirtBike;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);

			textDirtBikeBrand = itemView.findViewById(R.id.brand);
			textDirtBikeDisplacement = itemView.findViewById(R.id.displacement);
			imgDirtBike = itemView.findViewById(R.id.img_dirt_bike);
		}
	}

}
