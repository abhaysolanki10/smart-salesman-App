package com.example.freewaresys.smartsalesman;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class CustomerList extends AppCompatActivity {

    ListView listCust;
    ArrayList<String> list1,list2;
    myclass obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);

        startConf();

        obj=new myclass(this);

        Cursor c=obj.showCustomer();
        int catnameIndex=c.getColumnIndex("cemail");
        int catidIndex=c.getColumnIndex("cid");
        while (c.moveToNext())
        {
            list1.add(c.getString(catnameIndex));
            list2.add(c.getString(catidIndex));
        }

        ArrayAdapter arrayAdapter=new ArrayAdapter(CustomerList.this,android.R.layout.simple_list_item_1,list1);
        listCust.setAdapter(arrayAdapter);

        listCust.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String m = list2.get(position).toString();


                AlertDialog.Builder ab=new AlertDialog.Builder(CustomerList.this);
                ab.setTitle("Do You Want To Take Any Policy?");
                ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(getApplicationContext(), m, Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getApplicationContext(),SelectCategory.class);
                        intent.putExtra("cs",m);
                        startActivity(intent);
                    }
                });

                ab.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Back To Salesman Home", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), SDrawer.class));

                    }
                });

                AlertDialog ad=ab.create();
                ad.show();


              }
        });

    }


    public  void startConf()
    {
        listCust=(ListView)findViewById(R.id.listCust);
        list1=new ArrayList<String>();
        list2=new ArrayList<String>();
    }
}
