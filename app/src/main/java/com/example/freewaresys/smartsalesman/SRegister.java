package com.example.freewaresys.smartsalesman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.name;
import static android.R.attr.password;

public class SRegister extends AppCompatActivity {
    EditText t3,t4,t5,t7,t8;
    Button b4,sbtn;
    myclass obj;
    String Name,Email,Contact,Password,ConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sregister);
        t3=(EditText)findViewById(R.id.t3);
        t4=(EditText) findViewById(R.id.t4);
        t5=(EditText)findViewById(R.id.t5);
        t7=(EditText)findViewById(R.id.t7);
        t8=(EditText)findViewById(R.id.t8);
        b4=(Button)findViewById(R.id.b4);
        sbtn=(Button)findViewById(R.id.sbtn);

        obj=new myclass(this);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name = t3.getText().toString();
                Email = t4.getText().toString();
                Contact = t5.getText().toString();
                ConfirmPassword = t8.getText().toString();
                Password = t7.getText().toString();
                if (validate()) {

                    if (obj.adduser(Name, Email, Contact, Password)) {
                        Toast.makeText(SRegister.this, "Salesman Added", Toast.LENGTH_LONG).show();
                        ClearText();
                    }
                    else {
                        Toast.makeText(SRegister.this, "Salesman Not Added", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(SRegister.this, "Not Added", Toast.LENGTH_LONG).show();
                }
            }
        });

        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),ShowSalesManager.class));

            }
        });
    }

    public  void ClearText()
    {
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t8.setText("");
        t7.setText("");

    }
    public boolean validate(){
        String mobilepattern = "[0-9]{10}";
        boolean valid = true;
        if (Name.isEmpty()||Name.length()>32){
            t3.setError("Please Enter Name");
            valid=false;
        }
        if (Email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            t4.setError("Please Enter Email");
            valid=false;
        }
        if(ConfirmPassword != null&& Password!= null){
            if(!Password.equals(ConfirmPassword))
            {
                t8.setError("Invalid password");
                valid = false;
            }
        }
        if(ConfirmPassword.equals(null)&& Password.equals(null))
        {
            t7.setError("Invalid password");
            valid = false;
        }
        if(!Contact.matches(mobilepattern))
        {
            t5.setError("mobile number invalid");
            valid = false;
        }
        return valid;
    }

}
