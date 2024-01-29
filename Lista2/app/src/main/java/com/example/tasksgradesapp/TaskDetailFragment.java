package com.example.tasksgradesapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasksgradesapp.model.ExerciseList;
import com.example.tasksgradesapp.controller.TaskDetailAdapter;

public class TaskDetailFragment extends Fragment {

    private RecyclerView recyclerView;
    private TaskDetailAdapter adapter;
    private TextView tvDetailSubjectName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_detail_fragment, container, false);

        tvDetailSubjectName = view.findViewById(R.id.tvDetailSubjectName);
        recyclerView = view.findViewById(R.id.rvTaskDetail);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if (getArguments() != null) {
            ExerciseList exerciseList = (ExerciseList) getArguments().getSerializable("exerciseList");
            int position = getArguments().getInt("position");

            tvDetailSubjectName.setText(exerciseList.getSubject().getName() + "\n List " + (position + 1));
            adapter = new TaskDetailAdapter(exerciseList.getExercises());
            recyclerView.setAdapter(adapter);
        }

        return view;
    }



}

