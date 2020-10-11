package com.example.hw10.model;

public class Task {
    private String mUserName;
    private Enum mState;

    public Task(String userName, Enum state) {
        mUserName = userName;
        mState = state;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public Enum getState() {
        return mState;
    }

    public void setState(Enum state) {
        mState = state;
    }
}
