package com.example.freewaresys.smartsalesman;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class ShowSalesManager extends AppCompatActivity {

    ListView listSales;
    ArrayList<String> list1,list2;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_sales_manager);
        startConf();

        obj=new myclass(this);

        Cursor c=obj.showSales();
        int emailid=c.getColumnIndex("Email");
        int sid=c.getColumnIndex("uid");
        while (c.moveToNext())
        {
            list1.add(c.getString(emailid));
            list2.add(c.getString(sid));
        }

        ArrayAdapter arrayAdapter=new ArrayAdapter(ShowSalesManager.this,android.R.layout.simple_list_item_1,list1);
        listSales.setAdapter(arrayAdapter);

        listSales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final String m=list2.get(i).toString();
                Intent intent=new Intent(ShowSalesManager.this,ShowManager.class);
                intent.putExtra("damini",m);
                Toast.makeText(getApplicationContext(),m,Toast.LENGTH_LONG).show();
                startActivity(intent);

            }
        });



    }



    public  void startConf()
    {
        listSales=(ListView)findViewById(R.id.listSales);
        list1=new ArrayList<String>();
        list2=new ArrayList<String>();
    }
}
