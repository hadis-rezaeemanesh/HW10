package com.example.hw10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
        FrontPageFragment frontPageFragment = new FrontPageFragment();
        if (fragment == null) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, frontPageFragment)
                    .commit();
        }
    }
}