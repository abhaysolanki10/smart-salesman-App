package com.example.freewaresys.smartsalesman;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
public class Showcustomer extends AppCompatActivity {

    myclass obj;
    ListView clv;
    CustomerAdapter customerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showcustomer);
        obj=new myclass(this);
        startconf();
        customerAdapter=new CustomerAdapter(this,R.layout.activity_row_customer);

        try {
            Cursor c=obj.getcustomer("select * from customer");
            while (c.moveToNext()) {
                int id = c.getInt(0);
                String pname=c.getString(1);
                byte[] pimage=c.getBlob(7);
                String id1=Integer.toString(id);
                Customerclass pclass=new Customerclass(id1,pname,pimage);
                customerAdapter.add(pclass);
            }
            clv.setAdapter(customerAdapter);
        }
        catch (Exception ex) {

        }


    }
    public void show(String msg)
    {
        Toast.makeText(Showcustomer.this,msg,Toast.LENGTH_LONG).show();
    }
    public void startconf()
    {
        clv=(ListView)findViewById(R.id.clv);

    }
}
