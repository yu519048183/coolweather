package com.test.heykids01.coolweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hey kids�������ѽ on 2016/2/21.
 */
public class CoolWeatherOpenHelper extends SQLiteOpenHelper {
    /*
    * Province�������
    */
    public static final String CREATE_PROVINCE = "create table Province ("
            + "id integer primary autoincrement, "
            + "province_name text, "
            + "province_code text)";
    /*
    * City�������
    */
    public static final String CREATE_CITY = "create table City ("
            + "id integer primary key autoincrement, "
            + "city_name text, "
            + "city_code text, "
            + "province_id integer)";
    /*
    * County�������
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
    * ��3��������䶨��ɳ�������onCreate��ִ�д���*/

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PROVINCE);  //����Province��
        db.execSQL(CREATE_CITY);    //����City��
        db.execSQL(CREATE_COUNTY);   //����County��
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //ÿ�ű��ڴ������������һ����Ӧ��ʵ���࣬������ǳ����������Ǻ����Ŀ�������
    //ʵ��������ݶ��ǳ��򵥣����������������ݿ���Ӧ�ֶε� get �� set �����Ϳ�����


}
