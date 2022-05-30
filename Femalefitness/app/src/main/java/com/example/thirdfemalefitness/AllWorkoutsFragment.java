package com.example.thirdfemalefitness;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class AllWorkoutsFragment extends Fragment {

    RecyclerView rvWorkout;
    AllWorkoutsAdapter mAdapter;
    TextView tvInformation;
    SearchView searchWorkout;
    ArrayList<DataAllWorkouts> dataAllWorkouts;
    public AllWorkoutsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_all_workouts, container, false);
        rvWorkout = v.findViewById(R.id.rvWorkoutList);
        tvInformation = v.findViewById(R.id.tvWorkouts);
        rvWorkout.setHasFixedSize(true);

        searchWorkout = v.findViewById(R.id.search_workout);
        searchWorkout.clearFocus();
        searchWorkout.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvWorkout.setLayoutManager(layoutManager);

        dataAllWorkouts = new ArrayList<DataAllWorkouts>()
        {{
            add(new DataAllWorkouts("FULL BODY\nbeginner", "7", R.drawable.full_body1));
            add(new DataAllWorkouts("FLAT BELLY\nbeginner", "7", R.drawable.flat_belly1));
            add(new DataAllWorkouts("SLIM LEGS\nbeginner", "7", R.drawable.slim_legs1));
            add(new DataAllWorkouts("TONED ARMS\nbeginner", "7", R.drawable.toned_arms1));
            add(new DataAllWorkouts("NECK & BACK\nbeginner", "7", R.drawable.neck_and_back1));
            add(new DataAllWorkouts("BOOTY\nbeginner", "7", R.drawable.booty1));

            add(new DataAllWorkouts("FULL BODY\nintermediate", "10", R.drawable.full_body2));
            add(new DataAllWorkouts("FLAT BELLY\nintermediate", "10", R.drawable.flat_belly2));
            add(new DataAllWorkouts("SLIM LEGS\nintermediate", "10", R.drawable.slim_legs2));
            add(new DataAllWorkouts("TONED ARMS\nintermediate", "10", R.drawable.toned_arms2));
            add(new DataAllWorkouts("NECK & BACK\nintermediate", "10", R.drawable.neck_and_back2));
            add(new DataAllWorkouts("BOOTY\nintermediate", "10", R.drawable.booty2));

            add(new DataAllWorkouts("FULL BODY\nadvanced", "15", R.drawable.full_body3));
            add(new DataAllWorkouts("FLAT BELLY\nadvanced", "15", R.drawable.flat_belly3));
            add(new DataAllWorkouts("SLIM LEGS\nadvanced", "15", R.drawable.slim_legs3));
            add(new DataAllWorkouts("TONED ARMS\nadvanced", "15", R.drawable.toned_arms3));
            add(new DataAllWorkouts("NECK & BACK\nadvanced", "15", R.drawable.neck_and_back3));
            add(new DataAllWorkouts("BOOTY\nadvanced", "15", R.drawable.booty3));
        }};
        mAdapter = new AllWorkoutsAdapter(dataAllWorkouts,getActivity());
        rvWorkout.setAdapter(mAdapter);

        return v;
    }

    private void filterList(String newText)
    {
        tvInformation.setText("Workouts");
        ArrayList<DataAllWorkouts> filteredList = new ArrayList<>();
        for(DataAllWorkouts item : dataAllWorkouts)
        {
            if(item.getWorkoutName().toLowerCase().contains(newText.toLowerCase()))
            {
                filteredList.add(item);
            }
        }
        if(filteredList.isEmpty())
        {
            tvInformation.setText("No data found");
        }
        mAdapter.setFilterList(filteredList);
    }
}
