package com.github.therealroguewarlock.dirtbud.ui.garage.dirtbikelist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

		return root;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
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
		Toast.makeText(getContext().getApplicationContext(), "DirtBike: " + dirtBike.getBrand(), Toast.LENGTH_SHORT).show();
		// TODO: Implement navigation from here, to a View with information about the DirtBike, including a list of all the parts it has

	}
}
