package com.example.freewaresys.smartsalesman;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class ShowManager extends AppCompatActivity {

    TextView sname,semail,smno;
    myclass obj;
    String m="";
    Button delSales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_manager);
        startConf();
        obj=new myclass(this);
        m=getIntent().getStringExtra("damini").toString();
       final int sid=Integer.parseInt(m);

        Cursor c=obj.getSales(sid);
        int snameIndex=c.getColumnIndex("Name");
        int eIndex=c.getColumnIndex("Email");
        int mIndex=c.getColumnIndex("Contact");


        while (c.moveToNext())
        {
            sname.setText("Name:"+" "+c.getString(snameIndex));
            semail.setText("Email Address:"+" "+c.getString(eIndex));
            smno.setText("Contact No:"+" "+c.getString(mIndex));

        }


        delSales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder ab = new AlertDialog.Builder(ShowManager.this);
                ab.setTitle("Do You Want To Delete Customer?");
                ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        obj.delSales(sid);
                        show("Salesman Deleted");
                        startActivity(new Intent(ShowManager.this,ADrawer.class));


                    }
                });

                ab.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        show("Not Deleted");
                    }
                });

                AlertDialog ad = ab.create();
                ad.show();
            }
        });

       // Toast.makeText(getApplicationContext(),m,Toast.LENGTH_LONG).show();


    }

    public  void startConf()
    {
        sname=(TextView)findViewById(R.id.sname);
        semail=(TextView)findViewById(R.id.semail);
        smno=(TextView)findViewById(R.id.smno);

        delSales=(Button)findViewById(R.id.delSales);
    }
    public  void show(String msg)
    {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
    public  void sok(View view)
    {
        startActivity(new Intent(getApplicationContext(),SRegister.class));
    }
}
