package com.github.therealroguewarlock.dirtbud.ui.garage.dirtbikelist;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.therealroguewarlock.dirtbud.R;
import com.github.therealroguewarlock.dirtbud.databinding.FragmentDirtBikeListBinding;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;

public class DirtBikeListFragment extends Fragment {
	private FragmentDirtBikeListBinding binding;
	private DirtBikeListViewModel viewModel;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		viewModel = new ViewModelProvider(this).get(DirtBikeListViewModel.class);
		binding = FragmentDirtBikeListBinding.inflate(inflater, container, false);

		View root = binding.getRoot();

		setLiveDataObservers();
		setOnClickListeners();

		return root;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}

	private void setOnClickListeners() {
		binding.addDirtBikeId.setOnClickListener(this::addDirtBikeClicked);
	}

	private void setLiveDataObservers() {
		RecyclerView dirtBikeListView = binding.DirtBikeRecyclerView;
		dirtBikeListView.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));

		// Recycler View Adapter
		DirtBikeListAdapter listAdapter = new DirtBikeListAdapter();
		viewModel.getDirtBikes().observe(getViewLifecycleOwner(), listAdapter::setBikeList);
		listAdapter.setOnClickListener(this::dirtBikeClicked);
		dirtBikeListView.setAdapter(listAdapter);
	}

	private void dirtBikeClicked(DirtBike dirtBike) {
		Bundle dataTransferBundle = new Bundle();
		dataTransferBundle.putInt("dirt_bike_id", dirtBike.getDirtBikeId());

		NavHostFragment.findNavController(this).navigate(R.id.action_nav_dirt_bike_info, dataTransferBundle);
	}

	public void addDirtBikeClicked(View view) {

		Log.i("Button", "addDirtBikeClicked: ");
		NavHostFragment.findNavController(this).navigate(R.id.action_nav_dirt_bike_list_to_addDirtBike);

	}

}
