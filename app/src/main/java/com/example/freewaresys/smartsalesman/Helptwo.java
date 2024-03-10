package com.example.freewaresys.smartsalesman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Helptwo extends AppCompatActivity {
    Button bhr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helptwo);
        bhr=(Button)findViewById(R.id.bhr);
        bhr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Helptwo.this,Helpthree.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
