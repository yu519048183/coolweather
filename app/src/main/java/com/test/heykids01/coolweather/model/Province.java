package com.test.heykids01.coolweather.model;

/**
 * Created by Hey kids£¡£¡ÄãºÃÑ½ on 2016/2/21.
 */
public class Province {
    private int id;
    private String provinceName;
    private String provinceCode;

    private int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
}
