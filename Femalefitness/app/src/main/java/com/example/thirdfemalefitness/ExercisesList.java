package com.example.thirdfemalefitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class ExercisesList extends AppCompatActivity implements ExerciseInst {

    ListView lvExercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_list);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name").toLowerCase();
        Button btStart = findViewById(R.id.startExercises);

        ImageView toolbar = findViewById(R.id.imageExercises);;
        lvExercises = findViewById(R.id.lvExercises);

        lvExercises = findViewById(R.id.lvExercises);
        btStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(ExercisesList.this, DoExercises.class);
                startActivity(intent1);
            }
        });

        if (name.contains("full")) {
            toolbar.setImageResource(R.drawable.splash_exercises_full);
            if (name.contains("beginner")) {
                exercisesInstances.setExercisesImages(R.drawable.ex_cobra, R.drawable.ex_swimming, R.drawable.ex_squat_thrust,
                        R.drawable.ex_biceps_stretch, R.drawable.ex_v_plank);

                exercisesInstances.setExerciseName("Cobra plank", "Swimming", "Squat thrust", "Biceps stretch", "V plank");
            } else if (name.contains("intermediate")) {
                exercisesInstances.setExercisesImages(R.drawable.ex_rolling, R.drawable.ex_jump_start, R.drawable.ex_cobra, R.drawable.ex_swimming, R.drawable.ex_squat_thrust,
                        R.drawable.ex_biceps_stretch, R.drawable.ex_v_plank);

                exercisesInstances.setExerciseName("Rolling  ", "Jump start", "Cobra plank", "Swimming", "Squat thrust", "Biceps stretch", "V plank");
            } else {
                exercisesInstances.setExercisesImages(R.drawable.ex_side_crunch, R.drawable.ex_bicycle_crunches, R.drawable.ex_cross_jacks, R.drawable.ex_rolling, R.drawable.ex_jump_start, R.drawable.ex_cobra, R.drawable.ex_swimming, R.drawable.ex_squat_thrust,
                        R.drawable.ex_biceps_stretch, R.drawable.ex_v_plank);
                exercisesInstances.setExerciseName("Rolling  ", "Jump start", "Cobra plank", "Swimming", "Squat thrust", "Biceps stretch", "V plank");
            }
        }

        else if (name.contains("flat")) {
            toolbar.setImageResource(R.drawable.splash_exercises_belly);
            if (name.contains("beginner")) {
                exercisesInstances.setExerciseName("Bicycle crunches", "Biceps stretch", "Heisman ", "Oblique crunch",
                        "Reverse twist");
                exercisesInstances.setExercisesImages(R.drawable.ex_bicycle_crunches, R.drawable.ex_biceps_stretch,
                        R.drawable.ex_heisman, R.drawable.ex_oblique_crunch, R.drawable.ex_reverse_twist);
            } else if (name.contains("intermediate")) {
                exercisesInstances.setExerciseName("Rope climb", "Shoulder plank", "Bicycle crunches", "Biceps stretch", "Heisman ", "Oblique crunch",
                        "Reverse twist");
                exercisesInstances.setExercisesImages(R.drawable.ex_rope_climb, R.drawable.ex_shoulder_plank, R.drawable.ex_bicycle_crunches, R.drawable.ex_biceps_stretch,
                        R.drawable.ex_heisman, R.drawable.ex_oblique_crunch, R.drawable.ex_reverse_twist);
            } else {
                exercisesInstances.setExerciseName("Rolling  ", "V plank", "Side crunch", "Rope climb", "Shoulder plank", "Bicycle crunches", "Biceps stretch", "Heisman ", "Oblique crunch",
                        "Reverse twist");
                exercisesInstances.setExercisesImages(R.drawable.ex_rolling, R.drawable.ex_v_plank, R.drawable.ex_side_crunch, R.drawable.ex_rope_climb, R.drawable.ex_shoulder_plank, R.drawable.ex_bicycle_crunches, R.drawable.ex_biceps_stretch,
                        R.drawable.ex_heisman, R.drawable.ex_oblique_crunch, R.drawable.ex_reverse_twist);
            }

        } else if (name.contains("slim")) {
            toolbar.setImageResource(R.drawable.splash_exercises_legs);
            if (name.contains("beginner")) {
                exercisesInstances.setExerciseName("Back kick", "Calf raises", "Heal beats", "Knee tucks",
                        "Leg squat");
                exercisesInstances.setExercisesImages(R.drawable.ex_back_kick, R.drawable.ex_calf_raises,
                        R.drawable.ex_heal_beats, R.drawable.ex_knee_tucks, R.drawable.ex_leg_squat);
            } else if (name.contains("intermediate")) {
                exercisesInstances.setExerciseName("Lying curls", "Plank leg", "Back kick", "Calf raises", "Heal beats", "Knee tucks",
                        "Leg squat");
                exercisesInstances.setExercisesImages(R.drawable.lying_curls, R.drawable.ex_plank_leg, R.drawable.ex_back_kick, R.drawable.ex_calf_raises,
                        R.drawable.ex_heal_beats, R.drawable.ex_knee_tucks, R.drawable.ex_leg_squat);
            } else {
                exercisesInstances.setExerciseName("Side kick", "Scissor  ", "Pulse jump", "Lying curls", "Plank leg", "Back kick", "Calf raises", "Heal beats", "Knee tucks",
                        "Leg squat");
                exercisesInstances.setExercisesImages(R.drawable.ex_side_kick, R.drawable.ex_scissor, R.drawable.ex_pulse_jump, R.drawable.lying_curls, R.drawable.ex_plank_leg, R.drawable.ex_back_kick, R.drawable.ex_calf_raises,
                        R.drawable.ex_heal_beats, R.drawable.ex_knee_tucks, R.drawable.ex_leg_squat);
            }
        } else if (name.contains("arms")) {
            toolbar.setImageResource(R.drawable.splash_exercises_arms);
            if (name.contains("beginner")) {
                exercisesInstances.setExerciseName("Arm circles", "Arm swings", "Asymmetric push up", "Cross jacks",
                        "Jab cross");
                exercisesInstances.setExercisesImages(R.drawable.ex_arm_circles, R.drawable.ex_arm_swings,
                        R.drawable.ex_asymmetric_push_up, R.drawable.ex_cross_jacks, R.drawable.ex_jab_cross);
            } else if (name.contains("intermediate")) {
                exercisesInstances.setExerciseName("Pilates hundreds", "Skating windmill", "Arm circles", "Arm swings", "Asymmetric push up", "Cross jacks",
                        "Jab cross");
                exercisesInstances.setExercisesImages(R.drawable.ex_pilates_hundres, R.drawable.ex_skating_windmill, R.drawable.ex_arm_circles, R.drawable.ex_arm_swings,
                        R.drawable.ex_asymmetric_push_up, R.drawable.ex_cross_jacks, R.drawable.ex_jab_cross);
            } else {
                exercisesInstances.setExerciseName("Swimming", "V plank  ", "Bicycle crunches", "Pilates hundreds", "Skating windmill", "Arm circles", "Arm swings", "Asymmetric push up", "Cross jacks",
                        "Jab cross");
                exercisesInstances.setExercisesImages(R.drawable.ex_swimming, R.drawable.ex_v_plank, R.drawable.ex_bicycle_crunches, R.drawable.ex_pilates_hundres, R.drawable.ex_skating_windmill, R.drawable.ex_arm_circles, R.drawable.ex_arm_swings,
                        R.drawable.ex_asymmetric_push_up, R.drawable.ex_cross_jacks, R.drawable.ex_jab_cross);
            }
        }

        else if (name.contains("neck")) {
            toolbar.setImageResource(R.drawable.splash_exercises_neck);
            if (name.contains("beginner")) {
                exercisesInstances.setExerciseName("Bear squat", "Bird dogs", "Donkey kick twist", "Plank hip dips",
                        "Prone back");
                exercisesInstances.setExercisesImages(R.drawable.ex_bear_squat, R.drawable.ex_bird_dogs,
                        R.drawable.ex_donkey_kick_twist, R.drawable.ex_plank_hip_dips, R.drawable.ex_prone_back);
            } else if (name.contains("intermediate")) {
                exercisesInstances.setExerciseName("Side crunch", "Side bends", "Bear squat", "Bird dogs", "Donkey kick twist", "Plank hip dips",
                        "Prone back");
                exercisesInstances.setExercisesImages(R.drawable.ex_side_crunch, R.drawable.ex_side_bends, R.drawable.ex_bear_squat, R.drawable.ex_bird_dogs,
                        R.drawable.ex_donkey_kick_twist, R.drawable.ex_plank_hip_dips, R.drawable.ex_prone_back);
            } else {
                exercisesInstances.setExerciseName("Triceps push up", "Arm circles", "Arm swings", "Side crunch", "Side bends", "Bear squat", "Bird dogs", "Donkey kick twist", "Plank hip dips",
                        "Prone back");
                exercisesInstances.setExercisesImages(R.drawable.ex_tricep_push_up, R.drawable.ex_arm_circles, R.drawable.ex_arm_swings, R.drawable.ex_side_crunch, R.drawable.ex_side_bends, R.drawable.ex_bear_squat, R.drawable.ex_bird_dogs,
                        R.drawable.ex_donkey_kick_twist, R.drawable.ex_plank_hip_dips, R.drawable.ex_prone_back);
            }
        } else if (name.contains("booty")) {
            toolbar.setImageResource(R.drawable.splash_exercises_booty);
            if (name.contains("beginner")) {
                exercisesInstances.setExerciseName("Booty squeeze", "Bridge   ", "Dog crunch", "Back kick",
                        "Calf raises");
                exercisesInstances.setExercisesImages(R.drawable.ex_booty_squeeze, R.drawable.ex_bridge,
                        R.drawable.ex_dog_crunch, R.drawable.ex_back_kick, R.drawable.ex_calf_raises);
            } else if (name.contains("intermediate")) {
                exercisesInstances.setExerciseName("Frog bridge", "Lying curls", "Booty squeeze", "Bridge   ", "Dog crunch", "Back kick",
                        "Calf raises");
                exercisesInstances.setExercisesImages(R.drawable.ex_frog_bridge, R.drawable.lying_curls, R.drawable.ex_booty_squeeze, R.drawable.ex_bridge,
                        R.drawable.ex_dog_crunch, R.drawable.ex_back_kick, R.drawable.ex_calf_raises);
            } else {
                exercisesInstances.setExerciseName("Sumo squat", "Pulse jump", "Grasshopper ", "Frog bridge", "Lying curls", "Booty squeeze", "Bridge   ", "Dog crunch", "Back kick",
                        "Calf raises");
                exercisesInstances.setExercisesImages(R.drawable.ex_sumo_squart, R.drawable.ex_pulse_jump, R.drawable.ex_grasshopper, R.drawable.ex_frog_bridge, R.drawable.lying_curls, R.drawable.ex_booty_squeeze, R.drawable.ex_bridge,
                        R.drawable.ex_dog_crunch, R.drawable.ex_back_kick, R.drawable.ex_calf_raises);
            }
        }
        ExercisesListAdapter exercisesListAdapter = new ExercisesListAdapter(this,
                exercisesInstances.getExercisesName(), exercisesInstances.getExercisesImages());
        lvExercises.setAdapter(exercisesListAdapter);
    }
}