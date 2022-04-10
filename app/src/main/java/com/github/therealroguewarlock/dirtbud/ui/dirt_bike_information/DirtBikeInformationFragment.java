package com.github.therealroguewarlock.dirtbud.ui.dirt_bike_information;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.therealroguewarlock.dirtbud.databinding.FragmentDirtBikeInformationBinding;

public class DirtBikeInformationFragment extends Fragment {
	private FragmentDirtBikeInformationBinding binding;
	private DirtBikeInformationViewModel viewModel;

	// QUESTION: How would we get access to the Java Code, which acts on an embedded Fragment?
//	private InventoryFragment invFragment;

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		viewModel = new ViewModelProvider(this).get(DirtBikeInformationViewModel.class);
		binding = FragmentDirtBikeInformationBinding.inflate(inflater, container, false);
		View root = binding.getRoot();

		// QUESTION: Is this how you get Fragment Java Code?
//		invFragment = FragmentManager.findFragment(binding.fragmentContainerView);
//
//		Log.d("ISNULL", "Inv Fragment: " + (invFragment == null));
//		Log.d("FRAGMENT", "Inv Fragment ViewModel: " + invFragment.getViewModel());

		return root;
	}

}
