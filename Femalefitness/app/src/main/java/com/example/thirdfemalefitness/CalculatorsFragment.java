package com.example.thirdfemalefitness;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Calendar;

public class CalculatorsFragment extends Fragment {

    ImageView clDailyCalories, clWaterNorm, clBodyFat, clChangeWeight;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calculators, container, false);

        clDailyCalories = v.findViewById(R.id.clDailyCalories);
        clDailyCalories.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), DailyCalories.class);
                startActivity(intent1);
            }
        });

        clWaterNorm = v.findViewById(R.id.clWaterNorm);
        clWaterNorm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), WaterNorm.class);
                startActivity(intent1);
            }
        });

        clBodyFat = v.findViewById(R.id.clBodyFat);
        clBodyFat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), BodyFat.class);
                startActivity(intent1);
            }
        });

        clChangeWeight = v.findViewById(R.id.clChangeWeight);
        clChangeWeight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), ChangeWeight.class);
                startActivity(intent1);
            }
        });
        return v;
    }
}