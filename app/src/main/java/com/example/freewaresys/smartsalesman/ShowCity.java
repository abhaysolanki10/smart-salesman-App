package com.example.freewaresys.smartsalesman;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import java.util.ArrayList;

public class ShowCity extends AppCompatActivity {

    ListView listCity;
    myclass obj;
    ArrayList<String> list1,list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_city);
        obj=new myclass(this);
        startConf();

        Cursor c=obj.showCity();
        int cnindex=c.getColumnIndex("cityname");
        int cid=c.getColumnIndex("cityid");

        while (c.moveToNext())
        {
            list1.add(c.getString(cnindex));
            list2.add(c.getString(cid));
        }
        ArrayAdapter arrayAdapter=new ArrayAdapter(ShowCity.this,android.R.layout.simple_list_item_1,list1);
        listCity.setAdapter(arrayAdapter);


    }

    public  void startConf()
    {
        listCity=(ListView)findViewById(R.id.listCity);
        list1=new ArrayList<String>();
        list2=new ArrayList<String>();
    }
}
