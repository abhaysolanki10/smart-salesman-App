package com.example.freewaresys.smartsalesman;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class VehicleIns extends AppCompatActivity {

    TextView vet1,vet2;
    EditText vet3,vet4,vet5,vet6;
    Button vehBtn;
    String m="";
    myclass obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_ins);
        startConf();
        obj=new myclass(this);

        m=getIntent().getStringExtra("veh").toString();
        Toast.makeText(getApplicationContext(),m,Toast.LENGTH_LONG).show();

        final int idIndex=Integer.parseInt(m);
        Cursor c=obj.getCust(idIndex);
        int cnameIndex=c.getColumnIndex("cname");
        int emailIndex=c.getColumnIndex("cemail");
        while (c.moveToNext())
        {
            vet1.setText("Name is: "+c.getString(cnameIndex));
            vet2.setText("Email is: "+c.getString(emailIndex));
        }

        vehBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String vnm=vet3.getText().toString();
                String vno=vet4.getText().toString();
                String vty=vet5.getText().toString();
                String ob=vet6.getText().toString();
                int id=idIndex;
                if(obj.addVeh(id,vnm,vno,vty,ob))
                {
                    Intent intent=new Intent();
                    String t,sub,body;

                    t=vet2.getText().toString();

                    sub="Your Detail of Policy";

                    body="Your Policy Name:'"+ob+"'";

                    intent=new Intent(Intent.ACTION_SEND);

                    intent.setData(Uri.parse("mcail to:"));

                    String []to={t,"barvegargeya84@gmail.com"};

                    intent.putExtra(Intent.EXTRA_EMAIL,to);

                    intent.putExtra(Intent.EXTRA_SUBJECT,sub);

                    intent.putExtra(Intent.EXTRA_TEXT, body);


                    intent.setType("text/plain");

                    Intent chooser=Intent.createChooser(intent,"Send Email");

                    startActivity(chooser);

                    finish();


                    show("Data Added");
                }
                else {

                    show("Not Added");
                }

            }
        });


    }

    public void startConf()
    {
        vet1=(TextView)findViewById(R.id.vet1);
        vet2=(TextView)findViewById(R.id.vet2);
        vet3=(EditText)findViewById(R.id.vet3);
        vet4=(EditText)findViewById(R.id.vet4);
        vet5=(EditText)findViewById(R.id.vet5);
        vet6=(EditText)findViewById(R.id.vet6);
        vehBtn=(Button)findViewById(R.id.vehBtn);

    }

    public  void show(String msg)
    {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}
