package com.example.thirdfemalefitness;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

public class WorkoutFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_workout, container, false);

        tabLayout = v.findViewById(R.id.tabMenu);
        viewPager = v.findViewById(R.id.viewPager);

        tabLayout.setupWithViewPager(viewPager);
        WorkoutsAdapter workoutsAdapter = new WorkoutsAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        workoutsAdapter.addFragments(new AllWorkoutsFragment(), "All trainings");
        workoutsAdapter.addFragments(new CategoriesFragment(), "Categories");
        viewPager.setAdapter(workoutsAdapter);
        return v;
    }
}