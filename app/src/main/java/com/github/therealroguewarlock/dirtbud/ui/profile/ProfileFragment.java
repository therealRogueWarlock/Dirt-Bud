package com.github.therealroguewarlock.dirtbud.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.therealroguewarlock.dirtbud.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {

	private TextView tv_firstName, tv_lastName, tv_birthDay;

	//Fitness
	private TextView tv_vo2Max, tv_height, tv_weight;

	private TextView tv_ridingYears;

	private FragmentProfileBinding binding;
	ProfileViewModel profileViewModel;

	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

		binding = FragmentProfileBinding.inflate(inflater, container, false);
		View root = binding.getRoot();

		bindings();
		observers();

		return root;
	}

	private void observers() {
		profileViewModel.getUserData().observe(getViewLifecycleOwner(),user -> {
			tv_firstName.setText(user.getFirstName());
			tv_lastName.setText(user.getLastName());
			tv_birthDay.setText(user.getAge());
			tv_height.setText(user.getHeight());
			tv_weight.setText(user.getWeight());
			tv_vo2Max.setText(user.getVo2Max());
			tv_ridingYears.setText(user.getYearsRiding());
		});
	}

	private void bindings() {
		tv_firstName = binding.tvFirstName;
		tv_lastName = binding.tvLastName;
		tv_birthDay = binding.tvBirthday;

		//Fitness
		tv_vo2Max = binding.tvVo2Max;
		tv_height = binding.tvHeight;
		tv_weight = binding.tvWeight;

		tv_ridingYears = binding.tvRidingYears;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}

	@NonNull
	@Override
	public String toString() {
		return "Im profile fragment";
	}
}