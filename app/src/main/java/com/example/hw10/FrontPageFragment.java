package com.example.hw10;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class FrontPageFragment extends Fragment {

    private TextInputLayout mUsernameForm;
    private TextInputLayout mNumberTasksForm;
    private TextInputEditText mUsername;
    private TextInputEditText mNumberTasks;
    private Button mCreateListTasks;

    public FrontPageFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_front_page, container, false);

        findViews(view);
        setListeners();
        return view;
    }

    private void findViews(View view) {
        mUsername = view.findViewById(R.id.username);
        mNumberTasks = view.findViewById(R.id.number_task);
        mNumberTasksForm = view.findViewById(R.id.number_task_txtfield);
        mUsernameForm = view.findViewById(R.id.username_txtfield);
        mCreateListTasks = view.findViewById(R.id.btn_create);
    }

    private void setListeners(){
        mCreateListTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()){
                    Intent intent = TaskListActivity .newIntent(getActivity());
                    intent.putExtra("UserName", mUsername.getText().toString());
                    intent.putExtra("NumberOfTasks", mNumberTasks.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validateInput(){
        if (mUsername.getText().toString().trim().isEmpty()){
            mUsernameForm.setErrorEnabled(true);
            mUsernameForm.setError("Field cannot be empty");
            return false;
        }
        mUsernameForm.setErrorEnabled(false);
        return true;
    }
}