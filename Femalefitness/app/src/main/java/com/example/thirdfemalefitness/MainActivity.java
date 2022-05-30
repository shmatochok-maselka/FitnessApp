package com.example.thirdfemalefitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    WorkoutFragment workoutFragment = new WorkoutFragment();
    CalculatorsFragment calculatorsFragment = new CalculatorsFragment();
    RemindersFragment remindersFragment = new RemindersFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, workoutFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.workouts:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,workoutFragment).commit();
                        return true;
                    case R.id.calculators:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,calculatorsFragment
                        ).commit();
                        return true;
                    case R.id.reminders:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,remindersFragment
                        ).commit();
                        return true;
                }
                return false;
            }
        });
    }
}