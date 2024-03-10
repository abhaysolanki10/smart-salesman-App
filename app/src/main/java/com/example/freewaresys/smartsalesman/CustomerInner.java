package com.example.freewaresys.smartsalesman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CustomerInner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_inner);
        Toast.makeText(getApplicationContext(),"Customer Inner Called", Toast.LENGTH_LONG).show();
    }
}
