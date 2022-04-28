package com.github.therealroguewarlock.dirtbud.ui.garage.inventory;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.therealroguewarlock.dirtbud.databinding.ActivityMainBinding;
import com.github.therealroguewarlock.dirtbud.databinding.FragmentInventoryBinding;
import com.google.android.material.snackbar.Snackbar;


public class InventoryFragment extends Fragment {


    private FragmentInventoryBinding binding;
    private InventoryViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(InventoryViewModel.class);
        binding = FragmentInventoryBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

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
        return "Im inventory fragment";
    }
}
