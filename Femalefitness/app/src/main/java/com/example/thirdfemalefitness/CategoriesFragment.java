package com.example.thirdfemalefitness;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CategoriesFragment extends Fragment {

    RecyclerView rvFullBody, rvFlatBelly, rvTonedArms, rvSlimLegs, rvNeckAndBack, rvBooty;
    CategoriesAdapter categoriesAdapter;

    public CategoriesFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_categories, container, false);


        rvFullBody = v.findViewById(R.id.rvFullBody);
        rvFlatBelly = v.findViewById(R.id.rvFlatBelly);
        rvTonedArms = v.findViewById(R.id.rvTonedArms);
        rvSlimLegs = v.findViewById(R.id.rvSlimLegs);
        rvNeckAndBack = v.findViewById(R.id.rvNeckAndBack);
        rvBooty = v.findViewById(R.id.rvBooty);

        rvFullBody.setHasFixedSize(true);
        rvFlatBelly.setHasFixedSize(true);
        rvTonedArms.setHasFixedSize(true);
        rvSlimLegs.setHasFixedSize(true);
        rvNeckAndBack.setHasFixedSize(true);
        rvBooty.setHasFixedSize(true);

        rvFullBody.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvFlatBelly.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvTonedArms.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvSlimLegs.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvNeckAndBack.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvBooty.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<DataWCategories> dataWorkouts1 = new ArrayList<DataWCategories>()
        {{
            add(new DataWCategories("Full body workout", "7", "beginner", R.drawable.full_body1));
            add(new DataWCategories("Full body workout", "10", "intermediate", R.drawable.full_body2));
            add(new DataWCategories("Full body workout", "15", "advanced", R.drawable.full_body3));
        }};

        rvFullBody.setAdapter(new CategoriesAdapter(dataWorkouts1, getActivity()));

        ArrayList<DataWCategories> dataWorkouts2 = new ArrayList<DataWCategories>()
        {{
            add(new DataWCategories("Flat belly workout", "7", "beginner", R.drawable.flat_belly1));
            add(new DataWCategories("Flat belly workout", "10", "intermediate", R.drawable.flat_belly2));
            add(new DataWCategories("Flat belly workout", "15", "advanced", R.drawable.flat_belly3));
        }};

        rvFlatBelly.setAdapter(new CategoriesAdapter(dataWorkouts2, getActivity()));

        ArrayList<DataWCategories> dataWorkouts3 = new ArrayList<DataWCategories>()
        {{
            add(new DataWCategories("Toned arms workout", "7", "beginner", R.drawable.toned_arms1));
            add(new DataWCategories("Toned arms workout", "10", "intermediate", R.drawable.toned_arms2));
            add(new DataWCategories("Toned arms workout", "15", "advanced", R.drawable.toned_arms3));
        }};

        rvTonedArms.setAdapter(new CategoriesAdapter(dataWorkouts3, getActivity()));

        ArrayList<DataWCategories> dataWorkouts4 = new ArrayList<DataWCategories>()
        {{
            add(new DataWCategories("Slim legs workout", "7", "beginner", R.drawable.slim_legs1));
            add(new DataWCategories("Slim legs workout", "10", "intermediate", R.drawable.slim_legs2));
            add(new DataWCategories("Slim legs workout", "15", "advanced", R.drawable.slim_legs3));
        }};

        rvSlimLegs.setAdapter(new CategoriesAdapter(dataWorkouts4, getActivity()));

        ArrayList<DataWCategories> dataWorkouts5 = new ArrayList<DataWCategories>()
        {{
            add(new DataWCategories("Neck and back workout", "7", "beginner", R.drawable.neck_and_back1));
            add(new DataWCategories("Neck and back workout", "10", "intermediate", R.drawable.neck_and_back2));
            add(new DataWCategories("Neck and back workout", "15", "advanced", R.drawable.neck_and_back3));
        }};

        rvNeckAndBack.setAdapter(new CategoriesAdapter(dataWorkouts5, getActivity()));

        ArrayList<DataWCategories> dataWorkouts6 = new ArrayList<DataWCategories>()
        {{
            add(new DataWCategories("Booty workout", "7", "beginner", R.drawable.booty1));
            add(new DataWCategories("Booty workout", "10", "intermediate", R.drawable.booty2));
            add(new DataWCategories("Booty workout", "15", "advanced", R.drawable.booty3));
        }};

        rvBooty.setAdapter(new CategoriesAdapter(dataWorkouts6, getActivity()));

        return v;
    }
}
