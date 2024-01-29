package com.example.tasksgradesapp.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasksgradesapp.R;
import com.example.tasksgradesapp.model.ExerciseList;
import com.example.tasksgradesapp.model.SubjectData;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Map;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Map;

public class GradesAdapter extends RecyclerView.Adapter<GradesAdapter.GradesViewHolder> {

    private List<SubjectData> subjectDataList;

    public GradesAdapter(List<SubjectData> subjectDataList) {
        this.subjectDataList = subjectDataList;
    }

    @NonNull
    @Override
    public GradesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grade, parent, false);
        return new GradesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GradesViewHolder holder, int position) {
        SubjectData subjectData = subjectDataList.get(position);
        holder.subjectName.setText(subjectData.getSubjectName());
        holder.count.setText("List count: " + subjectData.getCount());
        holder.averageGrade.setText(String.format("Average: %.1f", subjectData.getAverageGrade()));
    }

    @Override
    public int getItemCount() {
        return subjectDataList.size();
    }

    static class GradesViewHolder extends RecyclerView.ViewHolder {
        TextView subjectName, averageGrade, count;

        public GradesViewHolder(View itemView) {
            super(itemView);
            subjectName = itemView.findViewById(R.id.subjectName);
            averageGrade = itemView.findViewById(R.id.averageGrade);
            count = itemView.findViewById(R.id.count);
        }
    }
}




