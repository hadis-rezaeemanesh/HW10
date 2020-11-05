package com.example.hw10.model;

import java.util.Random;
import java.util.UUID;

public class Task {
    private UUID mId;

    public UUID getId() {
        return mId;
    }

    private String mUserName;
    private State mState;
    private Boolean mColor;

    public Boolean getColor() {
        return mColor;
    }

    public void setColor(Boolean color) {
        mColor = color;
    }

    public Task(){
        mId = UUID.randomUUID();
    }

    public Task(String userName, State state) {
        mUserName = userName;
        mState = state;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public State getState() {
        return mState;
    }

    public void setState(State state) {
        int pick = new Random().nextInt(State.values().length);
        mState = state.values()[pick];
    }
}
