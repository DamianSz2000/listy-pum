package com.example.tasksgradesapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasksgradesapp.controller.SharedViewModel;
import com.example.tasksgradesapp.model.DataGenerator;
import com.example.tasksgradesapp.model.ExerciseList;
import com.example.tasksgradesapp.controller.ExerciseListAdapter;
import java.util.List;

public class TaskListsFragment extends Fragment {

    private RecyclerView rvExerciseLists;
    private ExerciseListAdapter adapter;
    private SharedViewModel sharedViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_lists_fragment, container, false);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        rvExerciseLists = view.findViewById(R.id.rvExerciseLists);
        rvExerciseLists.setLayoutManager(new LinearLayoutManager(getContext()));

        List<ExerciseList> data = DataGenerator.generateData();

        adapter = new ExerciseListAdapter(data);
        adapter.setOnItemClickListener((position, exerciseList) -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("exerciseList", exerciseList);
            bundle.putInt("position", position);
            Navigation.findNavController(view).navigate(R.id.action_taskListsFragment_to_taskDetailFragment, bundle);
        });

        rvExerciseLists.setAdapter(adapter);
        sharedViewModel.setExerciseLists(data);
        return view;
    }
}

