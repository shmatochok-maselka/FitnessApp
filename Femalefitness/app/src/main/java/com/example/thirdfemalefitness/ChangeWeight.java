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

public class ChangeWeight extends AppCompatActivity {

    SeekBar seekbarForHeight, seekbarForAge;
    TextView currentHeight, currentAge, currentWeight, currentNewWeight, calcChangeWeight;
    ImageView incrementNewWeight, decrementNewWeight, incrementWeight, decrementWeight;

    int currentProgressHeight, currentProgressAge;
    String intProgressHeight = "170", intProgressAge = "20";
    int intWeight = 75, intNewWeight = 60;

    Dialog dialog;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_weight);

        seekbarForHeight = findViewById(R.id.seekbarForHeight);
        seekbarForAge = findViewById(R.id.seekbarForAge);

        incrementNewWeight = findViewById(R.id.incrementNewWeight);
        incrementWeight = findViewById(R.id.incrementWeight);
        decrementNewWeight = findViewById(R.id.decrementNewWeight);
        decrementWeight = findViewById(R.id.decrementWeight);

        currentAge = findViewById(R.id.currentAge);
        currentHeight = findViewById(R.id.currentHeight);
        currentWeight = findViewById(R.id.currentWeight);
        currentNewWeight = findViewById(R.id.currentNewWeight);

        calcChangeWeight = findViewById(R.id.calcChangeWeight);

        seekbarForHeight.setMax(250);
        seekbarForHeight.setMin(50);
        seekbarForHeight.setProgress(160);
        seekbarForHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                currentProgressHeight = progress;
                intProgressHeight = String.valueOf(currentProgressHeight);
                currentHeight.setText(intProgressHeight);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        seekbarForAge.setMax(110);
        seekbarForAge.setMin(10);
        seekbarForAge.setProgress(20);
        seekbarForAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                currentProgressAge = progress;
                intProgressAge = String.valueOf(currentProgressAge);
                currentAge.setText(intProgressAge);

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
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.card_background_cw));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        TextView tvDailyCal = dialog.findViewById(R.id.tvCongrats);
        tvDailyCal.setText("CHANGE WEIGHT");
        TextView tvDailyCalRes = dialog.findViewById(R.id.tvCongFinish);
        GifImageView gfDailyCal = dialog.findViewById(R.id.gfCongrats);
        gfDailyCal.setImageResource(R.drawable.change_weight_gf);

        Button Okay = dialog.findViewById(R.id.btCongrats);


        Okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeWeight.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); finish();
                Toast.makeText(ChangeWeight.this, "Okay", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        calcChangeWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double resultNewWeight = intNewWeight * 10 + 6.25 * Integer.parseInt(intProgressHeight) - 5 * Integer.parseInt(intProgressAge) - 161;
                double resultWeight = intWeight * 10 + 6.25 * Integer.parseInt(intProgressHeight) - 5 * Integer.parseInt(intProgressAge) - 161;
                //int countOfCalories = (int)result;
                //TextView tvDailyCalRes = dialog.findViewById(R.id.tvCongFinish);
                String resultStr;
                if (resultNewWeight > resultWeight)
                {
                    resultStr = "You should eat " + String.valueOf((int)resultNewWeight) + " calories.";
                    resultStr += "\nIt is " + String.valueOf((int)resultNewWeight - (int)resultWeight) +
                            " more than you eat";
                }
                else
                {
                    resultStr = "You should eat " + String.valueOf((int)resultNewWeight) + " calories.";
                    resultStr += "\nIt is " + String.valueOf((int)resultWeight - (int)resultNewWeight) +
                            " less than you eat";
                }
                tvDailyCalRes.setText(resultStr);
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

        incrementNewWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intNewWeight = intNewWeight + 1;
                currentNewWeight.setText(String.valueOf(intNewWeight));
            }
        });


        decrementNewWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intNewWeight = intNewWeight - 1;
                currentNewWeight.setText(String.valueOf(intNewWeight));
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