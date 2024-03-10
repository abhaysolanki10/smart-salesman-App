package com.example.freewaresys.smartsalesman;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class Customer extends AppCompatActivity {

    EditText cet1,cet2,cet3,cet4;
    Button cbtn1,cbtn2,cbtn3;
    ImageView cimage1;
    Spinner cs1,cs2;
    ArrayList<String> list,list1,list2,list3;
    myclass obj;
    final int REQUEST_CODE_GALLERY=999;
    String m="",m1="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        startconf();
        obj=new myclass(this);
        list=new ArrayList<String>();
        list1=new ArrayList<String>();
        list2=new ArrayList<String>();
        list3=new ArrayList<String>();

        Cursor c=obj.showCity();
        final int id=c.getColumnIndex("cityid");
        int name=c.getColumnIndex("cityname");
        while (c.moveToNext())
        {
            list.add(c.getString(name));
            list1.add(c.getString(id));
        }
        ArrayAdapter arrayAdapter=new ArrayAdapter(Customer.this,android.R.layout.simple_list_item_1,list);
        cs1.setAdapter(arrayAdapter);

        cs1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                m=list1.get(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Cursor c1 = obj.showArea();
        int areaid = c1.getColumnIndex("areaid");
        int areaname = c1.getColumnIndex("areaname");
        while (c1.moveToNext()) {
            list2.add(c1.getString(areaid));
            list3.add(c1.getString(areaname));
        }


        ArrayAdapter arrayAdapter1 = new ArrayAdapter(Customer.this, android.R.layout.simple_list_item_1,list3);
        cs2.setAdapter(arrayAdapter1);

        cs2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                m1=list2.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        cbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_GALLERY);
            }
        });
        cbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id1=Integer.parseInt(m);
                int id2=Integer.parseInt(m1);
                String cname=cet1.getText().toString();
                String cemail=cet2.getText().toString();
                String cmno=cet3.getText().toString();
                String cpwd=cet4.getText().toString();
                obj.addcustomer(cname, cemail, id1, id2, cmno, cpwd, imageviewtobyte(cimage1));
                showmsg("Data Added");
                Intent intent=new Intent();

                   // To send Email

                String t,sub,body;

                t=cet2.getText().toString();

                sub="Your Email or Password";

                body="Your Email:'"+cemail+"' and password='"+cpwd+"'";

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
        });

        cbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Customer.this,Showcustomer.class));
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==REQUEST_CODE_GALLERY&&resultCode==RESULT_OK&&data!=null)
        {
            Uri uri=data.getData();
            try
            {
                InputStream inputStream=getContentResolver().openInputStream(uri);
                Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                cimage1.setImageBitmap(bitmap);
                showmsg("Image Display");
            }
            catch (Exception ex)
            {
                showmsg(ex.getMessage());
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public byte[] imageviewtobyte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    public void showmsg(String msg)
    {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
    public void startconf()
    {
        cet1=(EditText)findViewById(R.id.cet1);
        cet2=(EditText)findViewById(R.id.cet2);
        cet3=(EditText)findViewById(R.id.cet3);
        cet4=(EditText)findViewById(R.id.cet4);
        cimage1=(ImageView)findViewById(R.id.cimage1);
        cs1=(Spinner)findViewById(R.id.cs1);
        cs2=(Spinner)findViewById(R.id.cs2);
        cbtn1=(Button)findViewById(R.id.cbtn1);
        cbtn2=(Button)findViewById(R.id.cbtn2);
        cbtn3=(Button)findViewById(R.id.cbtn3);
    }

}
