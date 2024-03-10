package com.example.freewaresys.smartsalesman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Help extends AppCompatActivity {
    Button bhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        bhe=(Button)findViewById(R.id.bhe);
        bhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Help.this,Helptwo.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
