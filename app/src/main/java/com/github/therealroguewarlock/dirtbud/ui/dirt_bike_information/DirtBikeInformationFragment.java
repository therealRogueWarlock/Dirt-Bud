package com.github.therealroguewarlock.dirtbud.ui.dirt_bike_information;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.therealroguewarlock.dirtbud.databinding.FragmentDirtBikeInformationBinding;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;
import com.github.therealroguewarlock.dirtbud.ui.garage.inventory.PartListAdapter;

import java.util.Locale;

public class DirtBikeInformationFragment extends Fragment {
	private FragmentDirtBikeInformationBinding binding;
	private DirtBikeInformationViewModel viewModel;

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		viewModel = new ViewModelProvider(this).get(DirtBikeInformationViewModel.class);
		binding = FragmentDirtBikeInformationBinding.inflate(inflater, container, false);
		View root = binding.getRoot();

		int dirtBikeId = getArguments() != null ? getArguments().getInt("dirt_bike_id") : 0;
		viewModel.findDirtBike(dirtBikeId);

		setLiveDataObservers();
		setDirtBikeInformation();

		return root;
	}

	private void setDirtBikeInformation() {
		// viewModel -> getDirtBike -> Observe Things
		LiveData<DirtBike> viewModelDirtBikeLiveData = viewModel.getDirtBikeLiveData();
		viewModelDirtBikeLiveData.observe(getViewLifecycleOwner(), dirtBike -> binding.brand.setText(dirtBike.getBrand()));
		viewModelDirtBikeLiveData.observe(getViewLifecycleOwner(), dirtBike -> binding.displacement.setText(String.format(Locale.ENGLISH, "%d", dirtBike
				.getDisplacement())));
		viewModelDirtBikeLiveData.observe(getViewLifecycleOwner(), dirtBike -> binding.engineSize.setText(String.format(Locale.ENGLISH, "%d", dirtBike
				.getEngineSize())));
		viewModelDirtBikeLiveData.observe(getViewLifecycleOwner(), dirtBike -> binding.rideHeight.setText(String.format(Locale.ENGLISH, "%d", dirtBike
				.getRideHeight())));
		viewModelDirtBikeLiveData.observe(getViewLifecycleOwner(), dirtBike -> binding.forkHeight.setText(String.format(Locale.ENGLISH, "%d", dirtBike
				.getForkHeight())));
		viewModelDirtBikeLiveData.observe(getViewLifecycleOwner(), dirtBike -> binding.wheelSize.setText(String.format(Locale.ENGLISH, "%d", dirtBike
				.getWheelSize())));
		viewModelDirtBikeLiveData.observe(getViewLifecycleOwner(), dirtBike -> binding.weight.setText(String.format(Locale.ENGLISH, "%d", dirtBike
				.getWeight())));
		viewModelDirtBikeLiveData.observe(getViewLifecycleOwner(), dirtBike -> binding.isFourStroke.setText(dirtBike.isFourStrokeEngine()
		                                                                                                    ? "4-stroke"
		                                                                                                    : "2-stroke"));
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}

	private void setLiveDataObservers() {
		RecyclerView partListView = binding.bikePartRecyclerView;
		partListView.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));

		PartListAdapter listAdapter = new PartListAdapter();
		viewModel.getDirtBikeLiveData().observe(getViewLifecycleOwner(), dirtBike -> listAdapter.setPartList(dirtBike.getParts()));
		partListView.setAdapter(listAdapter);
	}

}
