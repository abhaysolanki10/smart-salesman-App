package com.example.freewaresys.smartsalesman;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class SalesProfile extends AppCompatActivity {

    TextView s1,s2,s3;
    Button sbtn;

    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_profile);
        startConf();
        obj=new myclass(this);
        String name=obj.getdummysname();
        s1.setText("Welcome: " + name);
       // show(name);
        final String email=obj.getdummysemail();
        s2.setText("Email: " + email);
        //show(email);
        String mno=obj.getmob(email);
        s3.setText("Conatct No: " + mno);
        //show(mno);




        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(SalesProfile.this,EditProfile.class);
                intent.putExtra("spro",email);
                startActivity(intent);
                finish();
            }
        });

    }
    public  void startConf()
    {
        s1=(TextView)findViewById(R.id.s1);
        s2=(TextView)findViewById(R.id.s2);
        s3=(TextView)findViewById(R.id.s3);

        sbtn=(Button)findViewById(R.id.sbtn);

    }

    public  void show(String msg)
    {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }

}
