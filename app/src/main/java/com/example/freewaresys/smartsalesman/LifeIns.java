package com.example.freewaresys.smartsalesman;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class LifeIns extends AppCompatActivity {

    TextView let1,let2;
    EditText let3,let4,let5,let6;
    Button lifBtn;
    RadioGroup rg1;
    RadioButton rb1,rb2;
    String m="";
    myclass obj;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_ins);
        startConf();
        obj=new myclass(this);

        m=getIntent().getStringExtra("home").toString();
        //Toast.makeText(getApplicationContext(),m,Toast.LENGTH_LONG).show();

        final int idIndex=Integer.parseInt(m);
        Cursor c=obj.getCust(idIndex);
        int cnameIndex=c.getColumnIndex("cname");
        int emailIndex=c.getColumnIndex("cemail");
        while (c.moveToNext())
        {
            let1.setText("Name is: "+c.getString(cnameIndex));
            let2.setText("Email is: "+c.getString(emailIndex));
        }

        int selected_id=rg1.getCheckedRadioButtonId();
        if(rb1.isChecked())
        {
            gender="Male";

        }
        else
        {
            gender="Female";
        }

        lifBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int uid=idIndex;
                String nat=let3.getText().toString();
                String ob=let4.getText().toString();
                String m=gender;
                String sex=m;
                String dob=let5.getText().toString();
                String nom=let6.getText().toString();

                if(obj.addLifeIns(uid,nat,ob,sex,dob,nom))
                {

                    show("Data Added");
                    Intent intent=new Intent();

                    // To send Email

                    String t,sub,body;

                    t=let2.getText().toString();

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


                }

                else {

                    show("Not Added");
                }

            }
        });

    }

    public void startConf()
    {
        let1=(TextView)findViewById(R.id.vet1);
        let2=(TextView)findViewById(R.id.vet2);
        let3=(EditText)findViewById(R.id.vet3);
        let4=(EditText)findViewById(R.id.vet4);
        let5=(EditText)findViewById(R.id.vet5);
        let6=(EditText)findViewById(R.id.let6);
        lifBtn=(Button)findViewById(R.id.lifeBtn);
        rg1=(RadioGroup)findViewById(R.id.rg1);
        rb1=(RadioButton)findViewById(R.id.rb1);
        rb2=(RadioButton)findViewById(R.id.rb2);

    }

    public  void show(String msg)
    {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
}
