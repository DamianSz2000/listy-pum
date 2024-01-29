package com.example.tasksgradesapp.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasksgradesapp.R;
import com.example.tasksgradesapp.model.Exercise;

import java.util.List;

public class TaskDetailAdapter extends RecyclerView.Adapter<TaskDetailAdapter.TaskDetailViewHolder> {

    private final List<Exercise> exercises;

    public TaskDetailAdapter(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public TaskDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task_detail, parent, false);
        return new TaskDetailViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskDetailViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
        holder.tvTaskNumber.setText(String.format("Task %d", position + 1));
        holder.tvTaskContent.setText(exercise.getContent());
        holder.tvTaskPoints.setText(String.format("pts: %d", exercise.getPoints()));
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    static class TaskDetailViewHolder extends RecyclerView.ViewHolder {
        TextView tvTaskNumber, tvTaskContent, tvTaskPoints;

        public TaskDetailViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTaskNumber = itemView.findViewById(R.id.tvTaskNumber);
            tvTaskContent = itemView.findViewById(R.id.tvTaskContent);
            tvTaskPoints = itemView.findViewById(R.id.tvTaskPoints);
        }
    }
}
