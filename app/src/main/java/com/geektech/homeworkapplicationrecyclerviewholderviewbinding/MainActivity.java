package com.geektech.homeworkapplicationrecyclerviewholderviewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.geektech.homeworkapplicationrecyclerviewholderviewbinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);





        getSupportFragmentManager().beginTransaction().replace(R.id.flMainFL, new FirstFragment()).commit();
    }
}