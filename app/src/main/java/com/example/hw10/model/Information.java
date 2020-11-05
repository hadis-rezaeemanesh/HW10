package com.example.hw10.model;

import java.util.UUID;

public class Information {

    private UUID mId;
    private String mName;
    private int mNumber;


    public Information() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getNumber() {
        return mNumber;
    }

    public void setNumber(int number) {
        mNumber = number;
    }
}
