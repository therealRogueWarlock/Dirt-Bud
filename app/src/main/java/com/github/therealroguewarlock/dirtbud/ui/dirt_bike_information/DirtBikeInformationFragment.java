package com.github.therealroguewarlock.dirtbud.ui.dirt_bike_information;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.therealroguewarlock.dirtbud.R;

public class DirtBikeInformationFragment extends Fragment {

	private DirtBikeInformationViewModel mViewModel;

	public static DirtBikeInformationFragment newInstance() {
		return new DirtBikeInformationFragment();
	}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_dirt_bike_information, container, false);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mViewModel = new ViewModelProvider(this).get(DirtBikeInformationViewModel.class);
		// TODO: Use the ViewModel
	}

}
