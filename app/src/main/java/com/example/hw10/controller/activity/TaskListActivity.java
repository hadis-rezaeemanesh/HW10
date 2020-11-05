package com.example.hw10.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.hw10.R;
import com.example.hw10.controller.fragment.TaskListFragment;
import com.example.hw10.repository.TaskRepository;

import java.util.UUID;

public class TaskListActivity extends SingleFragmentActivity {
    public static final String EXTRA_ID_INFORMATION = "com.example.hw10.idInformation";

    public static Intent newIntent(Context context, UUID mId){
        Intent intent = new Intent(context, TaskListActivity.class);
        intent.putExtra(EXTRA_ID_INFORMATION, mId );

        return intent;
    }

    @Override
    public Fragment createFragment() {
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_ID_INFORMATION);

        TaskListFragment taskListFragment = TaskListFragment.newInstance(crimeId);
        return taskListFragment;
    }
}