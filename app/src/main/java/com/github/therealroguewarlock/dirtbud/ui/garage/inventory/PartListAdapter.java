package com.github.therealroguewarlock.dirtbud.ui.garage.inventory;

import android.graphics.Color;
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

public class PartListAdapter extends RecyclerView.Adapter<PartListAdapter.ViewHolder> {
	private List<Part> partList = new ArrayList<>();

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
		holder.textPartNumber.setText(partList.get(position).getPartNumber());

		// Part Name
		holder.headerPartName.setText(R.string.card_info_part_name);
		holder.textPartName.setText(partList.get(position).getPartName());

		// Image
		holder.imgPart.setBackgroundColor(funColor(position));
	}

	private int funColor(int seed) {
		return Color.argb((seed * partList.size() * 20) % 100, (seed * 32 + partList.size() * partList.size()) % 255, (((seed % 4) == 0) ? 18 : (((seed % 3) == 0) ? seed : ((32 * seed) + 20))) % 255, (seed * 196) % 255);
	}

	@Override
	public int getItemCount() {
		return partList.size();
	}

	public void setPartList(List<Part> parts) {
		partList = (parts == null) ? new ArrayList<>() : parts;
		notifyDataSetChanged();
	}

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
