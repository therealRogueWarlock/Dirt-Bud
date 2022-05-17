package com.github.therealroguewarlock.dirtbud.ui.garage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.therealroguewarlock.dirtbud.R;
import com.github.therealroguewarlock.dirtbud.databinding.FragmentAddDirtBikeBinding;
import com.github.therealroguewarlock.dirtbud.model.entities.dirtbike.DirtBike;

public class AddDirtBike extends Fragment {

    private AddDirtBikeViewModel mViewModel;
    private Spinner brandSpinner, displacementSpinner, strokeSpinner;
    private Button addNewBikeButton;
    private FragmentAddDirtBikeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(AddDirtBikeViewModel.class);
        binding = FragmentAddDirtBikeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        bindings();
        spinnerAdapter();
        return root;
    }

    private void bindings(){
        brandSpinner = binding.markSpinnerId;
        displacementSpinner = binding.displacmentSpinnerId;
        strokeSpinner = binding.strokeSpinnerId;
        addNewBikeButton = binding.confirmAddDirtBikeId;
        addNewBikeButton.setOnClickListener(this::addDirtBike);
    }

    public void addDirtBike(View view){

        DirtBike newDirtBike = new DirtBike(brandSpinner.getSelectedItem().toString(), (Integer) displacementSpinner.getSelectedItem(),80,60,21,120, 0,0,strokeSpinner.getSelectedItemPosition() == 1);
        mViewModel.addDirtBike(newDirtBike);
    }

    private void spinnerAdapter() {
        //FIXME: er der en smartere måde at lave en spinner?

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(),
                R.array.dirt_bike_brand_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        // Apply the adapter to the spinner
        brandSpinner.setAdapter(adapter1);


        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(),
                R.array.dirt_bike_displacement_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        displacementSpinner.setAdapter(adapter2);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getContext(),
                R.array.dirt_bike_stroke, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        strokeSpinner.setAdapter(adapter3);
    }


}
