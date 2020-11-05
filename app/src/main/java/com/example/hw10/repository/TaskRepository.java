package com.example.hw10.repository;

import com.example.hw10.controller.fragment.FrontPageFragment;
import com.example.hw10.model.Information;
import com.example.hw10.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskRepository {
    private static TaskRepository sInstance;

    public static TaskRepository getInstance() {
        if (sInstance == null)
            sInstance = new TaskRepository();
        return sInstance;
    }

    private List<Task> mTasks;
    private Information mInformation;

    private TaskRepository(){
        Information information = new Information();
        mTasks = new ArrayList<>();
        for (int i=0; i<information.getNumber(); i++){
            Task task = new Task();
            task.setUserName(information.getName());
            task.setState(task.getState());
            task.setColor(i % 2 == 0);

            mTasks.add(task);
        }
    }

    public List<Task> getTasks() {
        return mTasks;
    }

    public void setTasks(List<Task> tasks) {
        mTasks = tasks;
    }

    public Information getInfo(UUID mId){
        if (mInformation.getId().equals(mId)){
            return mInformation;
        }
        return null;
    }
}
