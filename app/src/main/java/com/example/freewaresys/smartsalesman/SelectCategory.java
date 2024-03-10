package com.example.freewaresys.smartsalesman;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class SelectCategory extends AppCompatActivity {

    Button getBtn;
    Spinner spinner;
    ArrayList<String> list1,list2;
    myclass obj;
    String m="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);
        obj=new myclass(this);
        startConf();
        m=getIntent().getStringExtra("cs").toString();

        Cursor c=obj.showCategory();
        int cname=c.getColumnIndex("catname");
        int cid=c.getColumnIndex("catid");

        while (c.moveToNext())
        {
            list1.add(c.getString(cname));
            list2.add(c.getString(cid));
        }

        ArrayAdapter arrayAdapter=new ArrayAdapter(SelectCategory.this,android.R.layout.simple_list_item_1,list1);
        spinner.setAdapter(arrayAdapter);

        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hm="LifeInsurance";
                if(spinner.getSelectedItem().equals(hm))
                {
                    Intent intent=new Intent(getApplicationContext(),LifeIns.class);
                    intent.putExtra("home",m);
                    show(m);
                    startActivity(intent);
                  //  startActivity(new Intent(getApplicationContext(),HomeLoan.class));
                }



                if(spinner.getSelectedItem().equals("VehicleInsurance"))
                {
                    Intent i1=new Intent(getApplicationContext(),VehicleIns.class);
                    i1.putExtra("veh",m);
                    show(m);
                    startActivity(i1);
                }
            }
        });
    }


    public  void startConf()
    {
        spinner=(Spinner)findViewById(R.id.spinner);

        getBtn=(Button)findViewById(R.id.getBtn);

        list1=new ArrayList<String>();
        list2=new ArrayList<String>();
    }

    public  void show(String msg)
    {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }

}
