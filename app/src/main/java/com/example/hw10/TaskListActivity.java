package com.example.hw10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class TaskListActivity extends AppCompatActivity {

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, TaskListActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
    }
}