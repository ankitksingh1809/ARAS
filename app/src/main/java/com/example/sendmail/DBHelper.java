package com.example.sendmail;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ARAS.db";
    private static final String USERS_TABLE_NAME = "users";
    private static final String USERS_COLUMN_ID = "id";
    private static final String USERS_COLUMN_ROLLNO = "roll_no";
    private static final String USERS_COLUMN_EMAIL = "email";
    private static final String USERS_COLUMN_DAYFLAG1 = "day_flag1";
    private static final String USERS_COLUMN_DAYFLAG2 = "day_flag2";
    private static final String USERS_COLUMN_DAYFLAG3 = "day_flag3";
    private static final String USERS_COLUMN_DAYFLAG4 = "day_flag4";
    private static final String USERS_COLUMN_DAYFLAG5 = "day_flag5";
    private static final String USERS_COLUMN_DAYFLAG6 = "day_flag6";
    private static final String USERS_COLUMN_DAYFLAG7 = "day_flag7";
    private static final String USERS_COLUMN_TIMEFLAG1 = "time_flag1";
    private static final String USERS_COLUMN_TIMEFLAG2 = "time_flag2";
    private static final String USERS_COLUMN_TIMEFLAG3 = "time_flag3";
    private static final String USERS_COLUMN_TIMEFLAG4 = "time_flag4";
    private static final String USERS_COLUMN_TIMEFLAG5 = "time_flag5";
    private static final String USERS_COLUMN_TIMEFLAG6 = "time_flag6";
    private static final String USERS_COLUMN_TIMEFLAG7 = "time_flag7";
    private static final String USERS_COLUMN_TIMEFLAG8 = "time_flag8";
    private static final String USERS_COLUMN_TIMEFLAG9 = "time_flag9";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table users " +
                        "(id integer primary key AUTOINCREMENT, roll_no text UNIQUE, email text UNIQUE, day_flag1 boolean, day_flag2 boolean, day_flag3 boolean, day_flag4 boolean, day_flag5 boolean, day_flag6 boolean, day_flag7 boolean, time_flag1 boolean, time_flag2 boolean, time_flag3 boolean, time_flag4 boolean, time_flag5 boolean, time_flag6 boolean, time_flag7 boolean, time_flag8 boolean, time_flag9 boolean)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users");
        onCreate(sqLiteDatabase);
    }

    public Boolean insertUser (String RollNo, String Email, Boolean DayFlag1, Boolean DayFlag2, Boolean DayFlag3, Boolean DayFlag4, Boolean DayFlag5, Boolean DayFlag6, Boolean DayFlag7, Boolean TimeFlag1, Boolean TimeFlag2, Boolean TimeFlag3, Boolean TimeFlag4, Boolean TimeFlag5, Boolean TimeFlag6, Boolean TimeFlag7, Boolean TimeFlag8, Boolean TimeFlag9){
        SQLiteDatabase usersDb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_COLUMN_ROLLNO, RollNo);
        contentValues.put(USERS_COLUMN_EMAIL, Email);
        contentValues.put(USERS_COLUMN_DAYFLAG1, DayFlag1);
        contentValues.put(USERS_COLUMN_DAYFLAG2, DayFlag2);
        contentValues.put(USERS_COLUMN_DAYFLAG3, DayFlag3);
        contentValues.put(USERS_COLUMN_DAYFLAG4, DayFlag4);
        contentValues.put(USERS_COLUMN_DAYFLAG5, DayFlag5);
        contentValues.put(USERS_COLUMN_DAYFLAG6, DayFlag6);
        contentValues.put(USERS_COLUMN_DAYFLAG7, DayFlag7);
        contentValues.put(USERS_COLUMN_TIMEFLAG1, TimeFlag1);
        contentValues.put(USERS_COLUMN_TIMEFLAG2, TimeFlag2);
        contentValues.put(USERS_COLUMN_TIMEFLAG3, TimeFlag3);
        contentValues.put(USERS_COLUMN_TIMEFLAG4, TimeFlag4);
        contentValues.put(USERS_COLUMN_TIMEFLAG5, TimeFlag5);
        contentValues.put(USERS_COLUMN_TIMEFLAG6, TimeFlag6);
        contentValues.put(USERS_COLUMN_TIMEFLAG7, TimeFlag7);
        contentValues.put(USERS_COLUMN_TIMEFLAG8, TimeFlag8);
        contentValues.put(USERS_COLUMN_TIMEFLAG9, TimeFlag9);

        try {
            usersDb.insert(USERS_TABLE_NAME, null, contentValues);
        }
        catch (Exception e) {

        }
        return true;
    }

    public int updateUser (String RollNo, String Email, Boolean DayFlag1, Boolean DayFlag2, Boolean DayFlag3, Boolean DayFlag4, Boolean DayFlag5, Boolean DayFlag6, Boolean DayFlag7, Boolean TimeFlag1, Boolean TimeFlag2, Boolean TimeFlag3, Boolean TimeFlag4, Boolean TimeFlag5, Boolean TimeFlag6, Boolean TimeFlag7, Boolean TimeFlag8, Boolean TimeFlag9){
        SQLiteDatabase usersDb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERS_COLUMN_ROLLNO, RollNo);
        contentValues.put(USERS_COLUMN_EMAIL, Email);
        contentValues.put(USERS_COLUMN_DAYFLAG1, DayFlag1);
        contentValues.put(USERS_COLUMN_DAYFLAG2, DayFlag2);
        contentValues.put(USERS_COLUMN_DAYFLAG3, DayFlag3);
        contentValues.put(USERS_COLUMN_DAYFLAG4, DayFlag4);
        contentValues.put(USERS_COLUMN_DAYFLAG5, DayFlag5);
        contentValues.put(USERS_COLUMN_DAYFLAG6, DayFlag6);
        contentValues.put(USERS_COLUMN_DAYFLAG7, DayFlag7);
        contentValues.put(USERS_COLUMN_TIMEFLAG1, TimeFlag1);
        contentValues.put(USERS_COLUMN_TIMEFLAG2, TimeFlag2);
        contentValues.put(USERS_COLUMN_TIMEFLAG3, TimeFlag3);
        contentValues.put(USERS_COLUMN_TIMEFLAG4, TimeFlag4);
        contentValues.put(USERS_COLUMN_TIMEFLAG5, TimeFlag5);
        contentValues.put(USERS_COLUMN_TIMEFLAG6, TimeFlag6);
        contentValues.put(USERS_COLUMN_TIMEFLAG7, TimeFlag7);
        contentValues.put(USERS_COLUMN_TIMEFLAG8, TimeFlag8);
        contentValues.put(USERS_COLUMN_TIMEFLAG9, TimeFlag9);

        try {
            Boolean ans = DayFlag1;
            Log.d("Update", String.valueOf(DayFlag1));
            return usersDb.update(USERS_TABLE_NAME, contentValues, "roll_no = ? AND email = ?", new String[] {RollNo, Email});

        }
        catch (Exception e) {
            return 0;
        }
    }

    public ArrayList<UserData> getUsers(){
        ArrayList<UserData> users = new ArrayList<>();

        SQLiteDatabase usersDb = this.getReadableDatabase();
        Cursor res = usersDb.rawQuery("SELECT roll_no, email, day_flag1 FROM users", null);

        res.moveToFirst();

        while (res.isAfterLast() == false){
            users.add(new UserData(res.getString(0), res.getString(1)));
            Log.d("Day Flag0", String.valueOf(res.getInt(2)));
            res.moveToNext();
        }

        return users;
    }

    public ArrayList<Integer> getUserDetail(String RollNo, String Email) {
        ArrayList<Integer> dayTimeFlag = new ArrayList<>();

        SQLiteDatabase usersDb = this.getReadableDatabase();
        Cursor res = usersDb.rawQuery("SELECT roll_no, email, " + USERS_COLUMN_DAYFLAG1 + ", " + USERS_COLUMN_DAYFLAG2 + ", " + USERS_COLUMN_DAYFLAG3 + ", " + USERS_COLUMN_DAYFLAG4 + ", " + USERS_COLUMN_DAYFLAG5 + ", " + USERS_COLUMN_DAYFLAG6 + ", " + USERS_COLUMN_DAYFLAG7 + ", " + USERS_COLUMN_TIMEFLAG1 + ", " + USERS_COLUMN_TIMEFLAG2 + ", " + USERS_COLUMN_TIMEFLAG3 + ", " + USERS_COLUMN_TIMEFLAG4 + ", " + USERS_COLUMN_TIMEFLAG5 + ", " + USERS_COLUMN_TIMEFLAG6 + ", " + USERS_COLUMN_TIMEFLAG7 + ", " + USERS_COLUMN_TIMEFLAG8 + " FROM users WHERE roll_no = ? AND email = ?", new String[]{RollNo, Email} );

        res.moveToFirst();

        Log.d("Roll No", String.valueOf(res.getInt(2)));

        for(int i=0;i < 15;i++){
            dayTimeFlag.add(res.getInt(i+2));
        }

        return dayTimeFlag;
    }

    public Integer deleteUser(String RollNo, String Email){
        SQLiteDatabase usersDb = this.getWritableDatabase();
        return usersDb.delete(USERS_TABLE_NAME, "roll_no = ? AND email = ?", new String[]{RollNo, Email});
    }

    public Boolean deleteAllUsers(){
        SQLiteDatabase usersDb = this.getWritableDatabase();
        usersDb.execSQL("DELETE FROM users");
        return true;
    }
}
