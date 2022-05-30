package com.example.thirdfemalefitness;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

public class DailyCalories extends AppCompatActivity {

    SeekBar seekbarForHeight;
    TextView currentHeight, currentAge, currentWeight;
    ImageView incrementAge, decrementAge, incrementWeight, decrementWeight;
    TextView calcDailyCalories;

    int currentProgress;
    String intProgress = "170";
    int intWeight = 60, intAge = 20;

    Dialog dialog;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_calories);

        seekbarForHeight = findViewById(R.id.seekbarForHeight);
        currentHeight = findViewById(R.id.currentHeight);

        incrementAge = findViewById(R.id.incrementAge);
        decrementAge = findViewById(R.id.decrementAge);
        incrementWeight = findViewById(R.id.incrementWeight);
        decrementWeight = findViewById(R.id.decrementWeight);

        currentAge = findViewById(R.id.currentAge);
        currentWeight = findViewById(R.id.currentWeight);

        calcDailyCalories = findViewById(R.id.calcDailyCalories);

        seekbarForHeight.setMax(250);
        seekbarForHeight.setMin(50);
        seekbarForHeight.setProgress(160);
        seekbarForHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                currentProgress = progress;
                intProgress = String.valueOf(currentProgress);
                currentHeight.setText(intProgress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_congratulation);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.card_background));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        TextView tvDailyCal = dialog.findViewById(R.id.tvCongrats);
        tvDailyCal.setText("DAILY CALORIES");
        TextView tvDailyCalRes = dialog.findViewById(R.id.tvCongFinish);
        GifImageView gfDailyCal = dialog.findViewById(R.id.gfCongrats);
        gfDailyCal.setImageResource(R.drawable.daily);


        Button Okay = dialog.findViewById(R.id.btCongrats);


        Okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DailyCalories.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); finish();
                Toast.makeText(DailyCalories.this, "Okay", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        calcDailyCalories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = intWeight * 10 + 6.25 * Integer.parseInt(intProgress) - 5 * intAge - 161;
                int countOfCalories = (int)result;
                tvDailyCalRes.setText("Your calories norm is " + String.valueOf(countOfCalories));
                dialog.show();
            }
        });


        incrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight = intWeight + 1;
                currentWeight.setText(String.valueOf(intWeight));
            }
        });

        incrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge = intAge + 1;
                currentAge.setText(String.valueOf(intAge));
            }
        });


        decrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge = intAge - 1;
                currentAge.setText(String.valueOf(intAge));
            }
        });


        decrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intWeight = intWeight - 1;
                currentWeight.setText(String.valueOf(intWeight));
            }
        });
    }
}