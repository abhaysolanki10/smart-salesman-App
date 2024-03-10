package com.example.freewaresys.smartsalesman;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Damini on 13-03-2017.
 */
public class CustomerAdapter extends ArrayAdapter {
    public CustomerAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        row=convertView;

        ContactHolder contactHolder;
        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.activity_row_customer,parent,false);
            contactHolder=new ContactHolder();
            contactHolder.tx_pname=(TextView)row.findViewById(R.id.rc1);
            contactHolder.tx_pimage=(ImageView)row.findViewById(R.id.rimage2);
            android.view.ViewGroup.LayoutParams layoutParams=contactHolder.tx_pimage.getLayoutParams();
            layoutParams.width=200;
            layoutParams.height=200;
            contactHolder.tx_pimage.setLayoutParams(layoutParams);
            row.setTag(contactHolder);

        }
        else
        {
            contactHolder=(ContactHolder)row.getTag();
        }
        Customerclass pclass=(Customerclass) this.getItem(position);
        contactHolder.tx_pname.setText(pclass.getCname());
        byte[]pimage=pclass.getCimage();
        Bitmap bitmap= BitmapFactory.decodeByteArray(pimage, 0, pimage.length);
        contactHolder.tx_pimage.setImageBitmap(bitmap);
        return row;
    }
    static class ContactHolder
    {
        TextView tx_pname;
        ImageView tx_pimage;
    }
}
