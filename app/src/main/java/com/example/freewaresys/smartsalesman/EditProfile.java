package com.example.freewaresys.smartsalesman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class EditProfile extends AppCompatActivity {

    EditText suet1,suet3;
    Button suBtn;
    myclass obj;
    String name1,mno1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        startConf();
        obj=new myclass(this);

        final String name=obj. ();
        suet1.setText(name);
        // show(name);
        final String email=obj.getdummysemail();
       // suet2.setText(email);
        //show(email);
        String mno=obj.getmob(email);
        suet3.setText(mno);
        //show(mno);

        suBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            name1=suet1.getText().toString();

                 mno1=suet3.getText().toString();
                if(validate()) {
                    obj.upProfie(email, name1, mno1);
                    show("Updated");

                    obj.getsaleslogin(email);
                    obj.updatesaleslogin(name1, email);
                    startActivity(new Intent(getApplicationContext(), SalesProfile.class));
                    finish();
                }
                else
                {
                    show("not updated");
                }


            }
        });
    }

    public  void startConf()
    {
        suet1=(EditText)findViewById(R.id.suet1);

        suet3=(EditText)findViewById(R.id.suet3);

        suBtn=(Button)findViewById(R.id.suBtn);

    }
    public boolean validate()
    {
        String mobilepattern = "[0-9]{10}";
        boolean valid = true;
        if(name1.isEmpty())
        {
            suet1.setError("Invalid name");
            valid = false;
        }
        if(!mno1.matches(mobilepattern))
        {
            suet3.setError("mobile number invalid");
            valid = false;
        }
        return valid;
    }


    public  void show(String msg)
    {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
}
