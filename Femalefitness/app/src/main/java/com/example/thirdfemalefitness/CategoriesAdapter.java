package com.example.thirdfemalefitness;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
    List<DataWCategories> workoutsList;
    Context context;

    public CategoriesAdapter(List<DataWCategories> workoutsList, Context context) {
        this.workoutsList = workoutsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_workouts,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.workoutsname.setText(workoutsList.get(i).getWorkoutName());
        viewHolder.time.setText(workoutsList.get(i).getWorkoutTime() + " min");
        viewHolder.level.setText(workoutsList.get(i).getWorkoutLevel());
        viewHolder.workoutsImage.setImageResource(workoutsList.get(i).getImg());
    }

    @Override
    public int getItemCount() {
        return workoutsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        public TextView workoutsname, time, level;
        ImageView workoutsImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            workoutsname = itemView.findViewById(R.id.tvNameOfWorkout);
            time = itemView.findViewById(R.id.tvTime);
            level = itemView.findViewById(R.id.tvLevel);
            workoutsImage = itemView.findViewById(R.id.img);
            itemView.setOnClickListener(this);
        }
        public void onClick(View v) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context , ExercisesList.class);
            intent.putExtra("name" , workoutsList.get(position).getWorkoutName() + " " +
                    workoutsList.get(position).getWorkoutLevel());
            context.startActivity(intent);
        }
    }
}
