package com.example.freewaresys.smartsalesman;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class ShowCategory extends AppCompatActivity {

    ListView listCat;
    ArrayList<String> list1,list2;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_category);
        startConf();

        obj=new myclass(this);

        Cursor c=obj.showCategory();
        int catnameIndex=c.getColumnIndex("catname");
      // int catidIndex=c.getColumnIndex("cid");
        while (c.moveToNext())
        {
            list1.add(c.getString(catnameIndex));
         // list2.add(c.getString(catidIndex));
        }

        ArrayAdapter arrayAdapter=new ArrayAdapter(ShowCategory.this,android.R.layout.simple_list_item_1,list1);
        listCat.setAdapter(arrayAdapter);





    }

    public  void startConf()
    {
        listCat=(ListView)findViewById(R.id.listCat);
        list1=new ArrayList<String>();
        list2=new ArrayList<String>();
    }
}
