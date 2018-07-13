package com.example.hp.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


public class listview extends AppCompatActivity {
    TextView titView;
    TextView desView;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        titView=(TextView)findViewById(R.id.title);
        desView=(TextView)findViewById(R.id.sample_text);
        titView.setText(getTitle());
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }
}

