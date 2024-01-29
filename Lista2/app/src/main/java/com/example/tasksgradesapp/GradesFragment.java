package com.example.tasksgradesapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasksgradesapp.controller.GradesAdapter;
import com.example.tasksgradesapp.controller.SharedViewModel;
import com.example.tasksgradesapp.model.ExerciseList;
import com.example.tasksgradesapp.model.SubjectData;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

public class GradesFragment extends Fragment {

    private RecyclerView recyclerView;
    private GradesAdapter adapter;
    private SharedViewModel sharedViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grades_fragment, container, false);
        recyclerView = view.findViewById(R.id.rvGrades);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        List<ExerciseList> data = sharedViewModel.getExerciseLists();
        List<SubjectData> subjectData = calculateSubjectData(data);
        adapter = new GradesAdapter(subjectData);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private List<SubjectData> calculateSubjectData(List<ExerciseList> data) {
        Map<String, Double> averages = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();

        for (ExerciseList list : data) {
            String subjectName = list.getSubject().getName();
            averages.put(subjectName, averages.getOrDefault(subjectName, 0.0) + list.getGrade());
            counts.put(subjectName, counts.getOrDefault(subjectName, 0) + 1);
        }

        List<SubjectData> subjectDataList = new ArrayList<>();
        for (String subject : averages.keySet()) {
            double average = averages.get(subject) / counts.get(subject);
            int count = counts.get(subject);
            subjectDataList.add(new SubjectData(subject, average, count));
        }

        return subjectDataList;
    }
}

