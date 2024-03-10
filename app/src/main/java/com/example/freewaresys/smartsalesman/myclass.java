package com.example.freewaresys.smartsalesman;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by Freeware Sys on 3/11/2017.
 */
public class myclass extends SQLiteOpenHelper {

    public myclass(Context context) {
        super(context,"app.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Salesman(uid INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Email TEXT,Contact TEXT,Password TEXT)");
        db.execSQL("CREATE TABLE Admin(uid INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Email TEXT,Company TEXT,Password TEXT)");
        db.execSQL("CREATE TABLE category(catid INTEGER PRIMARY KEY AUTOINCREMENT,catname TEXT)");
        db.execSQL("CREATE TABLE admin_login(aid INTEGER PRIMARY KEY AUTOINCREMENT,email TEXT,password TEXT)");
        db.execSQL("insert into admin_login(email,password)values('admin@gmail.com','admin1234')");
        db.execSQL("CREATE TABLE customer(cid INTEGER PRIMARY KEY AUTOINCREMENT,cname TEXT,cemail TEXT,cityid INTEGER,areaid INTEGER,cmno TEXT,cpwd TEXT,cimg BLOB)");
        db.execSQL("CREATE TABLE city(cityid INTEGER PRIMARY KEY AUTOINCREMENT,cityname TEXT)");
        db.execSQL("CREATE TABLE area(areaid INTEGER PRIMARY KEY AUTOINCREMENT,cityid INTEGER,areaname TEXT)");
        db.execSQL("CREATE TABLE lifeins(lid INTEGER PRIMARY KEY AUTOINCREMENT,uid INTEGER,nat TEXT,obj TEXT,sex TEXT,dob TEXT,nom TEXT)");
        db.execSQL("CREATE TABLE vehins(vid INTEGER PRIMARY KEY AUTOINCREMENT,uid INTEGER,vname TEXT,vno TEXT,vtype TEXT,ob TEXT)");
        db.execSQL("CREATE TABLE dummysaleslogin(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,email TEXT)");
        db.execSQL("insert into dummysaleslogin(name,email)values('','')");
        db.execSQL("CREATE TABLE dummyuserlogin(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,email TEXT)");
        db.execSQL("insert into dummyuserlogin(name,email)values('','')");

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

     /*   db.execSQL("DROP TABLE Salesman IF EXISTS");
        db.execSQL("DROP TABLE Admin IF EXISTS");
        onCreate(db);*/
    }

    public boolean adduser(String f1, String f2, String f3, String f4) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", f1);
        contentValues.put("Email", f2);
        contentValues.put("Contact", f3);
        contentValues.put("Password", f4);
        long res = db.insert("Salesman", null, contentValues);
        if (res > 0) {
            return true;
        }
        return false;
    }

    public boolean addadmin(String f1, String f2, String f3, String f4) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", f1);
        contentValues.put("Email", f2);
        contentValues.put("Company", f3);
        contentValues.put("Password", f4);
        long res = db.insert("Admin", null, contentValues);
        if (res > 0) {
            return true;
        }
        return false;
    }

    public Cursor loginsales(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from Salesman where Email='" + email + "' and Password='" + password + "'", null);
    }
    public Cursor loginadmin(String email,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select * from admin_login where email='"+email+"' and password='"+password+"'",null);

    }

    //customer login
    public  Cursor logincust(String email,String pwd)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select * from customer where cemail='"+email+"' and cpwd='"+pwd+"'",null);


    }
    //show sales
    public Cursor showSales()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return  db.rawQuery("SELECT * FROM Salesman",null);
    }

    //get sales manager
    public  Cursor getSales(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return  db.rawQuery("SELECT * FROM Salesman where uid="+id,null);
    }
    //add Category
    public boolean addCategory(String c1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("catname", c1);
        long res = db.insert("category", null, contentValues);

        if(res==-1)
        {
            return  false;
        }
        return  true;


    }
    //show category
    public Cursor showCategory()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return  db.rawQuery("SELECT * FROM category",null);
    }

    //add city

    public boolean addCity(String c1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cityname", c1);
        long res = db.insert("city", null, contentValues);

        if(res==-1)
        {
            return  false;
        }
        return  true;


    }
    //show city
    public  Cursor showCity()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return  db.rawQuery("SELECT * FROM city",null);
    }

    //add area

    public boolean addArea(int cid,String aname)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("cityid",cid);
        contentValues.put("areaname",aname);
        long res=db.insert("area", null, contentValues);
        if(res>0){
            return  true;
        }
        else {
            return  false;
        }
    }

    //show area
    public Cursor showArea()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return  db.rawQuery("SELECT * FROM area",null);
    }
    public Cursor getArea(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return  db.rawQuery("SELECT * FROM area where cityid="+id,null);

    }
    public void addcustomer(String cname,String cemail,int cityid,int areaid,String cmno,String cpwd,byte[] image)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String q="insert into customer values(NULL,?,?,?,?,?,?,?)";
        SQLiteStatement statement=db.compileStatement(q);
        statement.clearBindings();
        statement.bindString(1, cname);
        statement.bindString(2, cemail);
        statement.bindLong(3, cityid);
        statement.bindLong(4, areaid);
        statement.bindString(5, cmno);
        statement.bindString(6, cpwd);
        statement.bindBlob(7,image);
        statement.executeInsert();

    }
    public Cursor getcustomer(String q)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery(q,null);

    }

    //show customer
    public  Cursor showCustomer()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return  db.rawQuery("SELECT * FROM customer",null);
    }

    //get customer from sales click
    public  Cursor getCust(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return  db.rawQuery("SELECT * FROM customer where cid="+id,null);
    }



    //get sales profile
    public  Cursor getSalesProfile(String email)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM Salesman WHERE Email="+email,null);
    }

    public String getsaleslogin(String e)
    {
        String name="";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c=db.rawQuery("select * from Salesman where Email='"+e+"'",null);
        int i=c.getColumnIndex("Name");
        while (c.moveToNext())
        {
            name=c.getString(i);
        }
        return name;
    }
    public void updatesaleslogin(String name,String email)
    {
        int id=1;
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("update dummysaleslogin set name='"+name+"',email='"+email+"' where id=1");

    }

    public String getdummysname()
    {
        String name="";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c=db.rawQuery("select * from dummysaleslogin where id=1",null);
        int i=c.getColumnIndex("name");
        while (c.moveToNext())
        {
            name=c.getString(i);
        }
        return name;
    }
    public String getdummysemail()
    {
        String name="";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c=db.rawQuery("select * from dummysaleslogin where id=1",null);
        int i=c.getColumnIndex("email");
        while (c.moveToNext())
        {
            name=c.getString(i);
        }
        return name;
    }

    public String getmob(String e)
    {
        String name="";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c=db.rawQuery("select * from Salesman where Email='"+e+"'",null);
        int i=c.getColumnIndex("Contact");
         while (c.moveToNext())
        {
            name=c.getString(i);
        }
        return name;

    }

    public  void upProfie(String email,String name,String mno)
    {
        SQLiteDatabase db=this.getWritableDatabase();


        db.execSQL("UPDATE Salesman set Name='"+name+"',Contact='"+mno+"' where Email='"+email+"'");


    }

    //add life insurance
    public  boolean addLifeIns(int uid,String nat,String ob,String sex,String dob,String nom)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("uid",uid);
        contentValues.put("nat",nat);
        contentValues.put("obj",ob);
        contentValues.put("sex",sex);
        contentValues.put("dob",dob);
        contentValues.put("nom",nom);

        long i=db.insert("lifeins",null,contentValues);
        if(i>0)
        {
            return  true;
        }
        return  false;

    }


    //add vehicle
    public  boolean addVeh(int uid,String vn,String vno,String vtyp,String ob)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("uid",uid);
        contentValues.put("vname",vn);
         contentValues.put("vno",vno);
        contentValues.put("vtype",vtyp);
        contentValues.put("ob",ob);

        long res=db.insert("vehins",null,contentValues);

        if(res>0)
        {
            return  true;
        }
        return false;
    }


    //dele
    public void delCust(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        int res=db.delete("customer", "cid" + "=?", new String[]{String.valueOf(id)});
    }


    //del sales
    public void delSales(int id1)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        int res=db.delete("Salesman", "uid" + "=?", new String[]{String.valueOf(id1)});
    }
}
