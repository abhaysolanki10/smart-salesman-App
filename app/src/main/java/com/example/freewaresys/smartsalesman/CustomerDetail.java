package com.example.freewaresys.smartsalesman;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class CustomerDetail extends AppCompatActivity {

    ListView listDetail;
    ArrayList<String> list1,list2;
    myclass obj;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail);
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

        ArrayAdapter arrayAdapter=new ArrayAdapter(CustomerDetail.this,android.R.layout.simple_list_item_1,list1);
        listDetail.setAdapter(arrayAdapter);

        listDetail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final String m=list2.get(position).toString();
                final int id1=Integer.parseInt(m);

                AlertDialog.Builder ab=new AlertDialog.Builder(CustomerDetail.this);
                ab.setTitle("Do You Want To Delete Customer?");
                ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        obj.delCust(id1);
                        show("Customer Deleted");
                        obj.delCust(id1);


                    }
                });

                ab.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        show("Not Deleted");
                    }
                });

                AlertDialog ad=ab.create();
                ad.show();
            }
        });

    }
    public  void startConf()
    {
        listDetail=(ListView)findViewById(R.id.listDetail);
        list1=new ArrayList<String>();
        list2=new ArrayList<String>();
    }

    public  void show(String msg)
    {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
}
