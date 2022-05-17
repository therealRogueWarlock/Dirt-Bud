package com.github.therealroguewarlock.dirtbud.ui.garage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.therealroguewarlock.dirtbud.R;

public class AddDirtBike extends Fragment {

    private AddDirtBikeViewModel mViewModel;
    private Spinner brandSpinner, displacementSpinner, strokeSpinner;
    private Button addNewBikeButton;

    public static AddDirtBike newInstance() {
        return new AddDirtBike();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_dirt_bike, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AddDirtBikeViewModel.class);
        // TODO: Use the ViewModel
    }

}
