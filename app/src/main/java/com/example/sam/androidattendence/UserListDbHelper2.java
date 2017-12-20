package com.example.sam.androidattendence;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by sam on 18/7/16.
 */
public class UserListDbHelper2 extends SQLiteOpenHelper {


    public static final String TABLE = "My_Subjects_Data";
    public static final int VERSION = 3;
    // public static final String ID = "ID";Subject
    public static final String Subject1 = "Subject1";
    public static final String Subject2 = "Subject2";
    public static final String Subject3 = "Subject3";
    public static final String Subject4 = "Subject4";
    public static final String Subject5 = "Subject5";
    public static final String Subject6 = "Subject6";

    public static final String Subject1_Att = "Subject1_Att";
    public static final String Subject2_Att = "Subject2_Att";
    public static final String Subject3_Att = "Subject3_Att";
    public static final String Subject4_Att = "Subject4_Att";
    public static final String Subject5_Att = "Subject5_Att";
    public static final String Subject6_Att = "Subject6_Att";

    public UserListDbHelper2(Context context, String name,CursorFactory factory, int version) {
        super(context, TABLE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        if(sqLiteDatabase==null||!sqLiteDatabase.isOpen())
            createTable();
        else
            Log.i("Database Already","Present");

    }

    void createTable() {

        SQLiteDatabase sdb = this.getWritableDatabase();
        sdb.execSQL("DROP TABLE IF EXISTS " +   TABLE);

        String sql = "CREATE TABLE IF NOT EXISTS My_Subjects_Data(SUBJECT1 VARCHAR,SUBJECT2 VARCHAR,SUBJECT3 VARCHAR,SUBJECT4 VARCHAR,SUBJECT5 VARCHAR,SUBJECT6 VARCHAR,Subject1_ATT VARCHAR,Subject2_ATT VARCHAR,Subject3_ATT VARCHAR,Subject4_ATT VARCHAR,Subject5_ATT VARCHAR,Subject6_ATT VARCHAR);";

        System.out.println(sql);
        sdb.execSQL(sql);
        sdb.close();
    }

    public boolean isTableExists() {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '"+TABLE+"'", null);
        if(cursor!=null) {
            if(cursor.getCount()>0) {
                cursor.close();
                return true;
            }
            cursor.close();
        }
        return false;
    }

    public void insertData(String subject1,String subject2,String subject3, String subject4,String subject5,String subject6,String subject1_Att,String subject2_Att,String subject3_Att,String subject4_Att,String subject5_Att,String subject6_Att)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Subject1,subject1);
        values.put(Subject2,subject2);
        values.put(Subject3,subject3);
        values.put(Subject4,subject4);
        values.put(Subject5,subject5);
        values.put(Subject6,subject6);
        values.put(Subject1_Att,subject1_Att);
        values.put(Subject2_Att,subject2_Att);
        values.put(Subject3_Att,subject3_Att);
        values.put(Subject4_Att,subject4_Att);
        values.put(Subject5_Att,subject5_Att);
        values.put(Subject6_Att,subject6_Att);

        db.insert(TABLE, null, values);
        System.out.println("Submitted...");
        Log.i("Submitted ::", " insert data executed");
        db.execSQL("INSERT INTO "+TABLE+" VALUES('"+subject1+"','"+subject2+"','"+subject3+"','"+subject4+"','"+subject5+"','"+subject6+"','"+subject1_Att+"','"+subject2_Att+"','"+subject3_Att+"','"+subject4_Att+"','"+subject5_Att+"','"+subject6_Att+"');");
    }

//    public void insertData_Subject1_Att(String subject1_Att){
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(Subject1_Att , subject1_Att);
//        db.insert(TABLE, null, values);
//        Log.i("Submitted 1 ::", " insert data executed "+subject1_Att);
//        db.execSQL("UPDATE "+TABLE+" SET Subject1_ATT = '" + subject1_Att + "';");
//    }

    public Cursor Checkdata()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        System.out.println("SubjectDatabase");
        return query(db, "SELECT * From "+TABLE);

    }

    private Cursor query(SQLiteDatabase db, String query) {
        Cursor cursor = db.rawQuery(query, null);
        System.out.println("Executing Query: " + query);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}