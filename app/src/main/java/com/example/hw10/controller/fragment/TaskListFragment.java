package com.example.hw10.controller.fragment;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hw10.R;
import com.example.hw10.model.Information;
import com.example.hw10.model.Task;
import com.example.hw10.repository.TaskRepository;

import java.util.List;
import java.util.UUID;

public class TaskListFragment extends Fragment {


    public static final String ARGS_ID_INFORMATION = "idInformation";
    private RecyclerView mRecyclerView;
    private TaskRepository mRepository;
    private Information mInformation;



    public static TaskListFragment newInstance(UUID mId) {
        
        Bundle args = new Bundle();
        args.putSerializable(ARGS_ID_INFORMATION, mId);
        
        TaskListFragment fragment = new TaskListFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public TaskListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mRepository = TaskRepository.getInstance();

        UUID informationId = (UUID) getArguments().getSerializable(ARGS_ID_INFORMATION);
        mInformation = mRepository.getInfo(informationId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);
        findViews(view);
        initViews();
        return view;
    }

    private void findViews(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_view_task_list);
    }

    private void initViews() {
        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        }else {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }

        List<Task> tasks = mRepository.getTasks();
        TaskAdapter taskAdapter = new TaskAdapter(tasks);

        mRecyclerView.setAdapter(taskAdapter);
    }

    private class TaskHolder extends RecyclerView.ViewHolder{

        private TextView mTextViewName;
        private TextView mTextViewState;
        private Task mTask;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            mTextViewName = itemView.findViewById(R.id.view_item_task_name);
            mTextViewState = itemView.findViewById(R.id.view_item_task_state);
        }

        private void bindTasks(Task task){
            mTask = task;
            mTextViewName.setText(task.getUserName());
            mTextViewState.setText(task.getState().toString());
            itemView.setBackgroundColor(Color.RED);
        }
    }

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder>{
        private List<Task> mTasks;

        public List<Task> getTasks() {
            return mTasks;
        }

        public void setTasks(List<Task> tasks) {
            mTasks = tasks;
        }

        public TaskAdapter(List<Task> tasks) {
            mTasks = tasks;
        }

        @Override
        public int getItemCount() {
            return mTasks.size();
        }

        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.task_row_list, parent, false);
            TaskHolder taskHolder = new TaskHolder(view);
            return taskHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
            Task task = mTasks.get(position);

            holder.bindTasks(task);
        }
    }
}
