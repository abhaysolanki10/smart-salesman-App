package com.example.freewaresys.smartsalesman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Category extends AppCompatActivity {

    EditText catet1;
    Button catBtn;
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        obj=new myclass(this);
        startConf();

        catBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String cname = catet1.getText().toString();

                if (obj.addCategory(cname)&&!cname.equals("")) {
                    show("Data Insertd");
                } else {

                    show("Not Inserted");
                }
            }
        });





    }

    public  void startConf()
    {
        catet1=(EditText)findViewById(R.id.catet1);
        catBtn=(Button)findViewById(R.id.catBtn);

    }
    public  void show(String msg)
    {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
    public void showCat(View view)
    {
       // Toast.makeText(getApplicationContext(),"Damini Clicked",Toast.LENGTH_LONG).show();
        startActivity(new Intent(getApplicationContext(),ShowCategory.class));
        finish();
    }
}
