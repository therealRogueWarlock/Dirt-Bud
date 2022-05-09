package com.github.therealroguewarlock.dirtbud.ui.dirt_bike_information;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.therealroguewarlock.dirtbud.R;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.Part;

import java.util.ArrayList;
import java.util.List;

public class DirtBikePartListAdapter extends RecyclerView.Adapter<DirtBikePartListAdapter.ViewHolder> {
	private List<Part> dirtBikeParts = new ArrayList<>();

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View view = inflater.inflate(R.layout.list_card, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		// Part Number
		holder.headerPartNumber.setText(R.string.card_info_part_number);
		holder.textPartNumber.setText(dirtBikeParts.get(position).getPartNumber());

		// Part Name
		holder.headerPartName.setText(R.string.card_info_part_name);
		holder.textPartName.setText(dirtBikeParts.get(position).getPartName());
	}

	@Override
	public int getItemCount() {
		return dirtBikeParts.size();
	}

	// INFO: Duplicate of PartListAdapter > ViewHolder
	public class ViewHolder extends RecyclerView.ViewHolder {
		private final TextView headerPartNumber, headerPartName;
		private final TextView textPartNumber, textPartName;
		private final ImageView imgPart;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			headerPartNumber = itemView.findViewById(R.id.header_one);
			headerPartName = itemView.findViewById(R.id.header_two);
			textPartNumber = itemView.findViewById(R.id.text_box_one);
			textPartName = itemView.findViewById(R.id.text_box_two);
			imgPart = itemView.findViewById(R.id.img_dirt_bike);
		}
	}

}
