package com.test.heykids01.coolweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hey kids！！你好呀 on 2016/2/21.
 */
public class CoolWeatherOpenHelper extends SQLiteOpenHelper {
    /*
    * Province表建表语句
    */
    public static final String CREATE_PROVINCE = "create table Province ("
            + "id integer primary autoincrement, "
            + "province_name text, "
            + "province_code text)";
    /*
    * City表建表语句
    */
    public static final String CREATE_CITY = "create table City ("
            + "id integer primary key autoincrement, "
            + "city_name text, "
            + "city_code text, "
            + "province_id integer)";
    /*
    * County表建表语句
    */
    public static final String CREATE_COUNTY = "create table County ("
            + "id integer primary key autoincrement, "
            + "county_name text, "
            + "county_code text, "
            + "city_id integer)";


    public CoolWeatherOpenHelper(Context context, String dbName, Object o, int version) {
        super(context, name, factory, version);
    }

    /*
    * 将3条建表语句定义成常量，在onCreate中执行创建*/

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PROVINCE);  //创建Province表
        db.execSQL(CREATE_CITY);    //创建City表
        db.execSQL(CREATE_COUNTY);   //创建County表
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //每张表在代码中最好能有一个对应的实体类，这样会非常方便于我们后续的开发工作
    //实体类的内容都非常简单，基本就是生成数据库表对应字段的 get 和 set 方法就可以了


}
