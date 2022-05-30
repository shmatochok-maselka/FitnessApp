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
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import pl.droidsonroids.gif.GifImageView;

public class WaterNorm extends AppCompatActivity {

    SeekBar seekbarForHeight, seekbarForWeight;
    TextView currentHeight, currentWeight, calcWaterNorm;

    String intProgressHeight = "160", intProgressWeight = "60";

    int currentProgressHeight, currentProgressWeight;

    Dialog dialog;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_norm);

        seekbarForHeight = findViewById(R.id.seekbarForHeight);
        seekbarForWeight = findViewById(R.id.seekbarForWeight);

        currentHeight = findViewById(R.id.currentHeight);
        currentWeight = findViewById(R.id.currentWeight);

        calcWaterNorm = findViewById(R.id.calcWaterNorm);

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

        seekbarForWeight.setMax(250);
        seekbarForWeight.setMin(30);
        seekbarForWeight.setProgress(60);
        seekbarForWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                currentProgressWeight = progress;
                intProgressWeight = String.valueOf(currentProgressWeight);
                currentWeight.setText(intProgressWeight);

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
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.card_background_wn));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        TextView tvDailyCal = dialog.findViewById(R.id.tvCongrats);
        tvDailyCal.setText("WATER NORM");
        TextView tvDailyCalRes = dialog.findViewById(R.id.tvCongFinish);
        GifImageView gfDailyCal = dialog.findViewById(R.id.gfCongrats);
        gfDailyCal.setImageResource(R.drawable.water_norm_gf);


        Button Okay = dialog.findViewById(R.id.btCongrats);


        Okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WaterNorm.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); finish();
                Toast.makeText(WaterNorm.this, "Okay", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        calcWaterNorm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double resultTop = 30 * Integer.parseInt(intProgressWeight) +
                        20 * Integer.parseInt(intProgressHeight) / 50;
                double resultBottom = 40 * Integer.parseInt(intProgressWeight) +
                        20 * Integer.parseInt(intProgressHeight) / 50;
                DecimalFormat df = new DecimalFormat("#");
                String resultStr = "You should drink " + df.format(resultTop) + " - " +
                        df.format(resultBottom) + " ml of water";
                tvDailyCalRes.setText(resultStr);
                dialog.show();
            }
        });
    }
}