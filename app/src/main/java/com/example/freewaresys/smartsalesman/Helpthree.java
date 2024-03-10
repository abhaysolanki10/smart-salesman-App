package com.example.freewaresys.smartsalesman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Helpthree extends AppCompatActivity {
    Button bhg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpthree);
        bhg=(Button)findViewById(R.id.bhg);
        bhg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Helpthree.this,Helpfour.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
