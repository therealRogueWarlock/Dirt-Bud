package com.github.therealroguewarlock.dirtbud.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.therealroguewarlock.dirtbud.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

	private FragmentHomeBinding binding;

	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

		binding = FragmentHomeBinding.inflate(inflater, container, false);
		View root = binding.getRoot();

		final TextView textView = binding.textHome;
		homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
		return root;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}


	@NonNull
	@Override
	public String toString() {
		return "Im home fragment";
	}
}