package com.example.freewaresys.smartsalesman;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    Button b1,b2,b3;
    EditText t1,t2;
    myclass obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        obj=new myclass(this);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);

        t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Home.this,Help.class);
                startActivity(intent);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = t1.getText().toString();
                String Password = t2.getText().toString();
                Cursor c = obj.loginsales(Email, Password);
             //   int id=c.getColumnIndex("Email");
                Cursor c1 = obj.loginadmin(Email,Password);
                Cursor c2=obj.logincust(Email,Password);
                if(c2.getCount()>0)
                {
                    showmsg("Customer Login Successfully");
                    startActivity(new Intent(getApplicationContext(),CustomerInner.class));

                }


               else if (c.getCount() > 0) {
                    showmsg("Sales Login successfully");
                    String name=obj.getsaleslogin(Email);
                    obj.updatesaleslogin(name, Email);
                    startActivity(new Intent(Home.this,SDrawer.class));


                }

                else if(c1.getCount()>0)
                {
                    showmsg("Admin Login Successfully");
                    startActivity(new Intent(Home.this,ADrawer.class));

                }
                else  {

                    showmsg("Invalid Username or Password");



                }


            }

        });



    }

    public void showmsg(String msg)
    {
        Toast.makeText(Home.this,msg, Toast.LENGTH_LONG).show();
    }
}
