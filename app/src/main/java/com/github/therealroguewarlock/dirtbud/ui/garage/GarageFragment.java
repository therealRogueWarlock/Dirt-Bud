package com.github.therealroguewarlock.dirtbud.ui.garage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.therealroguewarlock.dirtbud.databinding.FragmentGarageBinding;

public class GarageFragment extends Fragment {

    private FragmentGarageBinding binding;

    private GarageViewModel garageViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        garageViewModel = new ViewModelProvider(this).get(GarageViewModel.class);
        binding = FragmentGarageBinding.inflate(inflater, container, false);
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
        TextView garageText = binding.GaragePageText;
        garageViewModel.getText().observe(getViewLifecycleOwner(), garageText::setText);
    }
}
