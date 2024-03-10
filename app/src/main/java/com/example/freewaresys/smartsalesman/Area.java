package com.example.freewaresys.smartsalesman;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class Area extends AppCompatActivity {

    String m="";
    Spinner csp1;
    EditText aet1;
    Button abtn1,abtn2;
    ArrayList<String> list1,list2;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        obj=new myclass(this);
        startConf();
        Cursor c=obj.showCity();
        int cname=c.getColumnIndex("cityname");
        int cityid=c.getColumnIndex("cityid");

        while (c.moveToNext())
        {
            list1.add(c.getString(cname));
            list2.add(c.getString(cityid));
        }

        ArrayAdapter arrayAdapter=new ArrayAdapter(Area.this,android.R.layout.simple_list_item_1,list1);
        csp1.setAdapter(arrayAdapter);


        csp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                m = list2.get(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        abtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int cid = Integer.parseInt(m);
                String aname = aet1.getText().toString();

                if (obj.addArea(cid, aname)&&!aname.equals("")) {
                    show("Data Added");
                } else {
                    show("Not Added");

                }

            }
        });

        abtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Area.this,ShowArea.class));
                finish();
            }
        });
    }

    public  void startConf()
    {
        csp1=(Spinner)findViewById(R.id.csp1);
        aet1=(EditText)findViewById(R.id.aet1);
        abtn1=(Button)findViewById(R.id.abtn1);
        abtn2=(Button)findViewById(R.id.abtn2);
        list1=new ArrayList<String>();
        list2=new ArrayList<String>();
    }

    public  void show(String msg)
    {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
}
