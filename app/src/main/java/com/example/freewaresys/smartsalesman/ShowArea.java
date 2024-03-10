package com.example.freewaresys.smartsalesman;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import java.util.ArrayList;

public class ShowArea extends AppCompatActivity {

    myclass obj;
    ArrayList<String> list1,list2;
    ListView listArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_area);

        obj=new myclass(this);
        startConf();

        Cursor c=obj.showArea();
        int aname=c.getColumnIndex("areaname");
        int aid=c.getColumnIndex("areaid");

        while (c.moveToNext())
        {
            list1.add(c.getString(aname));

        }
        ArrayAdapter arrayAdapter=new ArrayAdapter(ShowArea.this,android.R.layout.simple_list_item_1,list1);
        listArea.setAdapter(arrayAdapter);


    }

    public  void startConf()
    {
        listArea=(ListView)findViewById(R.id.listArea);
        list1=new ArrayList<String>();
        list2=new ArrayList<String>();

    }
}
