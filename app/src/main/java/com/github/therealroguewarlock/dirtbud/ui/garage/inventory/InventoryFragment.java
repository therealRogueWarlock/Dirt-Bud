package com.github.therealroguewarlock.dirtbud.ui.garage.inventory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.therealroguewarlock.dirtbud.databinding.FragmentInventoryBinding;

public class InventoryFragment extends Fragment {

	private FragmentInventoryBinding binding;
	private InventoryViewModel viewModel;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		viewModel = new ViewModelProvider(this).get(InventoryViewModel.class);
		binding = FragmentInventoryBinding.inflate(inflater, container, false);
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
		RecyclerView partListView = binding.partRecyclerView;
		partListView.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));

		PartListAdapter listAdapter = new PartListAdapter();
		viewModel.getParts().observe(getViewLifecycleOwner(), listAdapter::setPartList);
		partListView.setAdapter(listAdapter);
	}

}
