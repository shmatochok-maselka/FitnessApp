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

public class AllWorkoutsAdapter extends RecyclerView.Adapter<AllWorkoutsAdapter.ViewHolder> {
    List<DataAllWorkouts> allWorkoutsList;
    Context context;

    public void setFilterList(List<DataAllWorkouts> filterList)
    {
        this.allWorkoutsList = filterList;
        notifyDataSetChanged();
    }
    public AllWorkoutsAdapter(List<DataAllWorkouts> allWorkoutsList, Context context) {
        this.allWorkoutsList = allWorkoutsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_all_workouts, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.workoutName.setText(allWorkoutsList.get(i).getWorkoutName());
        viewHolder.time.setText(allWorkoutsList.get(i).getTime());
        viewHolder.img.setImageResource(allWorkoutsList.get(i).getImg());
    }

    @Override
    public int getItemCount() {
        return allWorkoutsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        public TextView workoutName, time;
        public ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            workoutName = itemView.findViewById(R.id.tvNameOfWorkout);
            time = itemView.findViewById(R.id.tvTime);
            img = itemView.findViewById(R.id.img);
            itemView.setOnClickListener(this);
        }

        public void onClick(View v) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context , ExercisesList.class);
            intent.putExtra("name" , allWorkoutsList.get(position).getWorkoutName());
            context.startActivity(intent);
        }
    }
}
