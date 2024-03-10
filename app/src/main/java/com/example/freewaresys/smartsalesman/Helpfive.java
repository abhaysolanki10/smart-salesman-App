package com.example.freewaresys.smartsalesman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Helpfive extends AppCompatActivity {
    Button bhj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpfive);
        bhj=(Button)findViewById(R.id.bhj);
        bhj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Helpfive.this,Home.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
