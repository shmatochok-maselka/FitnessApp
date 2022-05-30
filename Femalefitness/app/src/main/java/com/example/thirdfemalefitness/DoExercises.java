package com.example.thirdfemalefitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.Locale;

import pl.droidsonroids.gif.GifImageView;

public class DoExercises extends AppCompatActivity implements ExerciseInst{
    Dialog dialog;

    private String[] exerciseName;
    private int[] exercisesImages;

    private static int counter = 0;

    private TextView minutesTv, secondsTv;
    private Button mButtonReset;
    GifImageView gifExercise, gfCongrats;
    CardView cvExercise;

    private TextView tvNextExercise;
    Toolbar tbSport;

    private CountDownTimer mCountDownTimer;

    private long mTimeLeftInMillis = REST_TIME_IN_MILLIS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_exercises);
        
        dialog = new Dialog(DoExercises.this);
        dialog.setContentView(R.layout.dialog_congratulation);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.congrats_background));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        TextView tvCongrats = dialog.findViewById(R.id.tvCongrats);
        tvCongrats.setText("CONGRATULATIONS!");
        TextView tvCongratsMessage = dialog.findViewById(R.id.tvCongFinish);
        tvCongratsMessage.setText("You finished this workout!");
        GifImageView gfCongrats = dialog.findViewById(R.id.gfCongrats);
        gfCongrats.setImageResource(R.drawable.gf_congrats);

        Button Okay = dialog.findViewById(R.id.btCongrats);

        Okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DoExercises.this, MainActivity.class);
                startActivity(intent1);
                Toast.makeText(DoExercises.this, "Okay", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        counter = 0;
        gifExercise = findViewById(R.id.gifExercise);
        tbSport = findViewById(R.id.tbSport);
        cvExercise = findViewById(R.id.cvExercise);

        exerciseName = exercisesInstances.getExercisesName();
        exercisesImages = exercisesInstances.getExercisesImages();

        gifExercise.setBackgroundResource(exercisesImages[0]);

        int numberOfItems = exerciseName.length * 2;
        tvNextExercise = findViewById(R.id.tvNextExs);
        tvNextExercise.setText("First exercise");

        minutesTv = findViewById(R.id.tvMin);
        secondsTv = findViewById(R.id.tvSec);

        mButtonReset = findViewById(R.id.btSkip);
        mButtonReset.setText("Skip tutorial");
        startTimer(numberOfItems);
        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeView(numberOfItems);
            }
        });
    }
    private void changeView(int numberOfItems) {
        if (counter < numberOfItems - 1) {
            mCountDownTimer.cancel();
            mTimeLeftInMillis = counter % 2 == 0 ? EXERCISE_TIME_IN_MILLIS : REST_TIME_IN_MILLIS;
            updateCountDownText();
            startTimer(numberOfItems);
            counter++;
            if (counter % 2 == 0) {
                tvNextExercise.setText("Next Exercises");
                int index = counter / 2;
                gifExercise.setBackgroundResource(exercisesImages[index]);
                mButtonReset.setText("Skip rest");
                tbSport.setBackgroundResource(R.drawable.rest_toolbar);
                cvExercise.setCardBackgroundColor(getResources().getColor(R.color.colorWhite));
            } else {
                int index = (counter - 1) / 2;
                tvNextExercise.setText(exerciseName[index]);
                mButtonReset.setText("Skip exercise");
                if (counter == numberOfItems - 1) {
                    mButtonReset.setText("Finish");
                }
                tbSport.setBackgroundResource(R.drawable.exercising_toolbar);
                cvExercise.setCardBackgroundColor(getResources().getColor(R.color.colorLightGreen2));
            }
            //if(counter == numberOfItems - 1)
        } else{
            if(mButtonReset.getText().toString() != "Finish")
            {
                int index = (counter - 1) / 2;
                tvNextExercise.setText(exerciseName[index]);
                mButtonReset.setText("Skip exercise");
                mButtonReset.setText("Finish");
                tbSport.setBackgroundResource(R.drawable.exercising_toolbar);
                cvExercise.setCardBackgroundColor(getResources().getColor(R.color.colorLightGreen2));
                counter++;
            }
            else dialog.show();
        }
    }

    private void startTimer(int numberOfItems) {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                changeView(numberOfItems);
            }
        }.start();

    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        String[] minSec = timeLeftFormatted.split(":");

        minutesTv.setText(minSec[0]);
        secondsTv.setText(minSec[1]);
    }
}