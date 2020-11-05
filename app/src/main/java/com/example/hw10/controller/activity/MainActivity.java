package com.example.hw10.controller.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.hw10.controller.fragment.FrontPageFragment;
import com.example.hw10.R;

public class MainActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }


    @Override
    public Fragment createFragment() {
        return new FrontPageFragment();
    }
}