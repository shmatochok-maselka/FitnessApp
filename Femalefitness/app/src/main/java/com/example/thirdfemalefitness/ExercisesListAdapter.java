package com.example.thirdfemalefitness;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

public class ExercisesListAdapter extends ArrayAdapter<String> {
    Context context;
    int[] images;
    String[] exerciseName;

    public ExercisesListAdapter(Context context, String[] exerciseName, int[] images) {
        super(context, R.layout.exercises_list_item, exerciseName);
        this.context = context;
        this.images = images;
        this.exerciseName = exerciseName;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View singleItem = convertView;

        ViewHolder holder = null;
        if(singleItem == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(R.layout.exercises_list_item, parent, false);

            holder = new ViewHolder(singleItem);
            singleItem.setTag(holder);
        }
        else{
            holder = (ViewHolder) singleItem.getTag();
        }

        holder.itemImage.setImageResource(images[position]);
        holder.exerciseTitle.setText(exerciseName[position]);
        holder.exerciseTime.setText("60 sec");
        singleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), exerciseName[position], Toast.LENGTH_SHORT).show();
            }
        });
        return singleItem;
    }
}

class ViewHolder {
    GifImageView itemImage;
    TextView exerciseTitle;
    TextView exerciseTime;

    ViewHolder(View v)
    {
        itemImage = v.findViewById(R.id.gifItemWorkout);
        exerciseTitle = v.findViewById(R.id.tvNameOfExercise);
        exerciseTime = v.findViewById(R.id.tvTimeOfExercise);
    }

}
