package com.example.freewaresys.smartsalesman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class City extends AppCompatActivity {

    EditText cityEt1;
    Button cityBtn1,cityBtn2;
    myclass obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        obj=new myclass(this);
        startConf();

        cityBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cname = cityEt1.getText().toString();

                if (obj.addCity(cname)&&cname.equals("")) {
                    show("Data Inserted");
                } else {

                    show("Not Inserted");
                }
            }
        });

        cityBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),ShowCity.class));
                finish();
            }
        });

    }

    public  void show(String msg)
    {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }

    public  void startConf(){

        cityEt1=(EditText)findViewById(R.id.cityet1);
        cityBtn1=(Button)findViewById(R.id.cityBtn1);
        cityBtn2=(Button)findViewById(R.id.cityBtn2);
    }
}
