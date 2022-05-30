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

import java.text.DecimalFormat;

import pl.droidsonroids.gif.GifImageView;

public class BodyFat extends AppCompatActivity {

    SeekBar seekbarForHeight;
    TextView currentHeight, currentHip, currentNeck, currentWaist, calcBodyFat, currentWeight;
    ImageView incrementNeck, decrementNeck, incrementWaist, decrementWaist, incrementWeight;
    ImageView decrementWeight, incrementHip, decrementHip;

    int currentProgressHeight;
    String intProgressHeight = "160", intProgressHip = "85";
    int intNeck = 35, intWaist = 70, intHip = 80, intWeight = 60;

    Dialog dialog;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_fat);

        seekbarForHeight = findViewById(R.id.seekbarForHeight);

        currentHeight = findViewById(R.id.currentHeight);
        currentHip = findViewById(R.id.currentHip);
        currentNeck = findViewById(R.id.currentNeck);
        currentWaist = findViewById(R.id.currentWaist);
        currentWeight = findViewById(R.id.currentWeight);

        incrementNeck = findViewById(R.id.incrementNeck);
        decrementNeck = findViewById(R.id.decrementNeck);
        incrementWaist = findViewById(R.id.incrementWaist);
        decrementWaist = findViewById(R.id.decrementWaist);
        incrementHip = findViewById(R.id.incrementHip);
        decrementHip = findViewById(R.id.decrementHip);
        incrementWeight = findViewById(R.id.incrementWeight);
        decrementWeight = findViewById(R.id.decrementWeight);

        calcBodyFat = findViewById(R.id.calcBodyFat);

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

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_congratulation);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.card_background_bf));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        TextView tvDailyCal = dialog.findViewById(R.id.tvCongrats);
        tvDailyCal.setText("BODY FAT");
        TextView tvDailyCalRes = dialog.findViewById(R.id.tvCongFinish);
        GifImageView gfDailyCal = dialog.findViewById(R.id.gfCongrats);
        gfDailyCal.setImageResource(R.drawable.body_fat_gf);

        Button Okay = dialog.findViewById(R.id.btCongrats);


        Okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BodyFat.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); finish();
                Toast.makeText(BodyFat.this, "Okay", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        calcBodyFat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = 495 / (1.29579 - 0.35004 * Math.log10(Integer.parseInt(intProgressHip)
                        + intWaist - intNeck) + 0.22100 * Math.log10(Integer.parseInt(intProgressHeight)))
                        - 450;
                DecimalFormat df = new DecimalFormat("#.#");
                String resultStr = "Your BFP is " + df.format(result) + "\n";
                if (result < 14) {
                    resultStr += "Your weight category is underweight";
                } else if (result < 20) {
                    resultStr += "Your weight category is athletes";
                } else if(result < 24)
                {
                    resultStr += "Your weight category is fitness";
                }else if(result < 31)
                {
                    resultStr += "Your weight category is average";
                }else
                {
                    resultStr += "Your weight category is obese";
                }
                double idealFatWeight = ((double) intWeight / 100) * 17.7;
                double thisFatWeight = ((double) intWeight / 100) * result;
                if(thisFatWeight < idealFatWeight)
                {
                    resultStr += "\nFor ideal weight you should to gain " + df.format(idealFatWeight - thisFatWeight);
                }
                else if(thisFatWeight == idealFatWeight)
                {
                    resultStr += "\nYour weight is ideal!";
                }
                else
                {
                    resultStr += "\nFor ideal weight you should to lose " + df.format(thisFatWeight - idealFatWeight);
                }
                tvDailyCalRes.setText(resultStr);
                dialog.show();
            }
        });

        incrementNeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intNeck = intNeck + 1;
                currentNeck.setText(String.valueOf(intNeck));
            }
        });

        incrementWaist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWaist = intWaist + 1;
                currentWaist.setText(String.valueOf(intWaist));
            }
        });


        decrementWaist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWaist = intWaist - 1;
                currentWaist.setText(String.valueOf(intWaist));
            }
        });


        decrementNeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intNeck = intNeck - 1;
                currentNeck.setText(String.valueOf(intNeck));
            }
        });

        incrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight = intWeight + 1;
                currentWeight.setText(String.valueOf(intWeight));
            }
        });

        decrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight = intWeight - 1;
                currentWeight.setText(String.valueOf(intWeight));
            }
        });


        incrementHip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intHip = intHip + 1;
                currentHip.setText(String.valueOf(intHip));
            }
        });


        decrementHip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intHip = intHip - 1;
                currentHip.setText(String.valueOf(intHip));
            }
        });
    }
}