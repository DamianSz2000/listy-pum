package com.example.tasksgradesapp.controller;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasksgradesapp.R;
import com.example.tasksgradesapp.model.ExerciseList;

import java.util.List;

public class ExerciseListAdapter extends RecyclerView.Adapter<ExerciseListAdapter.ExerciseListViewHolder> {

    private List<ExerciseList> exerciseList;
    private OnItemClickListener listener;
    public ExerciseListAdapter(List<ExerciseList> exerciseList) {
        this.exerciseList = exerciseList;

    }
    public interface OnItemClickListener {
        void onItemClick(int position, ExerciseList exerciseList);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ExerciseListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task_list, parent, false);
        return new ExerciseListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseListViewHolder holder, int position) {
        ExerciseList currentList = exerciseList.get(position);
        holder.tvSubjectName.setText(currentList.getSubject().getName());
        holder.tvTaskListName.setText("List " + (position + 1));
        holder.tvPoints.setText("Task count: " + currentList.getExercises().size());
        holder.tvGrade.setText(String.format("Grade: %.1f", currentList.getGrade()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(position, exerciseList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }
    static class ExerciseListViewHolder extends RecyclerView.ViewHolder {
        TextView tvSubjectName, tvTaskListName, tvPoints, tvGrade;

        public ExerciseListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSubjectName = itemView.findViewById(R.id.tvSubjectName);
            tvTaskListName = itemView.findViewById(R.id.tvTaskListName);
            tvPoints = itemView.findViewById(R.id.tvPoints);
            tvGrade = itemView.findViewById(R.id.tvGrade);
        }
    }
}

