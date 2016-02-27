package com.test.heykids01.coolweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.test.heykids01.coolweather.model.City;
import com.test.heykids01.coolweather.model.County;
import com.test.heykids01.coolweather.model.Province;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hey kids�������ѽ on 2016/2/21.
 */
public class CoolWeatherDB {      //�Ǹ�������
    /*
    * ���ݿ���
    */
    public static final String DB_NAME = "cool_weather";

    /*
    * ���ݿ�汾
    */
    public static final int VERSION = 1;
    private static CoolWeatherDB coolWeatherDB;
    private SQLiteDatabase db;

    /*
    * �����췽��˽�л�
    */
    private CoolWeatherDB(Context context) {           //���췽��˽�л�
        CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context, DB_NAME, null, VERSION);
        db = dbHelper.getWritableDatabase();
    }


    /*
    * ��ȡCoolWeatherDB��ʵ��
    */
    public synchronized static CoolWeatherDB getInstance (Context context) {
    //��ȡCoolWeatherDBʵ�������Ϳ��Ա�֤ȫ�ַ�Χ��ֻ����һ��CoolWeatherDB ��ʵ��

        if(coolWeatherDB == null) {
            coolWeatherDB = new CoolWeatherDB(context);
        }
        return coolWeatherDB;
    }

    /*
    * ��Provinceʵ���洢�����ݿ�*/
    public void saveProvince(Province province) {
        if (province != null) {
            ContentValues values = new ContentValues();
            values.put("province_name", province.getProvinceName());
            values.put("province_code", province.getProvinceCode());
            db.insert("Province", null, values);
        }
    }

    /*
    * �����ݿ��ȡȫ�����е�ʡ����Ϣ
    */
    public List<Province> loadProvinces() {
        List<Province> list = new ArrayList<Province>();
        Cursor cursor = db.query("Province", null, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Province province = new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
                list.add(province);
            } while (cursor.moveToNext());
        }
        return list;
    }

    /*
    * ��Cityʵ���洢�����ݿ�
    */
    public void saveCity(City city) {
        if(city != null) {
            ContentValues values = new ContentValues();
            values.put("city_name", city.getCityName());
            values.put("city_code", city.getCityCode());
            values.put("province_id", city.getProvinceId());
            db.insert("City", null, values);
        }
    }

    /*
    * �����ݿ��ȡĳʡ�µ����г�����Ϣ
    */
    public List<City> loadCities(int provinceId) {
        List<City> list = new ArrayList<City>();
        Cursor cursor = db.query("City", null, "province_id = ?", new String[] {String.valueOf(provinceId) }, null. null, null);
        if(cursor.moveToFirst()) {
            do {
                City city = new City();
                city.setId(cursor.getInt(cursor.getColumnIndex("id")));
                city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
                city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
                city.setProvinceId((provinceId));
                list.add(city);
            } while (cursor.moveToNext());
        }
        return list;
    }

    /*
    * ��Countyʵ���洢�����ݿ�
    */
    public void saveCounty(County county) {
        if(county != null) {
            ContentValues values = new ContentValues();
            values.put("county_name", county.getCountyName());
            values.put("county_code", county.getCountyCode());
            values.put("city_id", county.getCityId());
            db.insert("County", null, values);
        }
    }

    /*
    * �����ݿ��ȡĳ���������е�����Ϣ
    */
    public List<County> loadCounties(int cityId) {
        List<County> list = new ArrayList<County>();
        Cursor cursor = db.query("County", null, "city_id = ?", new String[] { String.valueOf(cityId) }, null, null, null);
        if(cursor.moveToFirst()) {
            do{
                County county = new County();
                county.setId(cursor.getInt(cursor.getColumnIndex("id")));
                county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
                county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
                county.setCityId(cityId);
                list.add(county);
            } while (cursor.moveToNext());
        }
        return list;
    }



}



/*
* CoolWeatherDB ��һ�������࣬���ǽ����Ĺ��췽��˽�л������ṩ��һ��
getInstance()��������ȡ CoolWeatherDB ��ʵ���������Ϳ��Ա�֤ȫ�ַ�Χ��ֻ����һ��
CoolWeatherDB ��ʵ���������������� CoolWeatherDB ���ṩ�����鷽����saveProvince()��
loadProvinces()��saveCity()��loadCities()��saveCounty()��loadCounties()���ֱ����ڴ洢ʡ��
���ݡ���ȡ����ʡ�����ݡ��洢�������ݡ���ȡĳʡ�����г������ݡ��洢�����ݡ���ȡĳ
���������ص����ݡ�
*/