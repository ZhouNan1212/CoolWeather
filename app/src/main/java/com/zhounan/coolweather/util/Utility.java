package com.zhounan.coolweather.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.zhounan.coolweather.db.*;
import com.zhounan.coolweather.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ZhouNan on 2017/12/3.
 */

public class Utility {
    /*
     * 解析和处理服务器返回的province数据, 先使用JSONArray和JSONObject将数据解析出来，然后组装成实体类对象，再
     * 调用save将数据存入数据库中，以下两个方法类似。
     */
    public static boolean handleProvinceResponse(String reponse) {
        if (!TextUtils.isEmpty(reponse)) {
            try {
                JSONArray allProvinces = new JSONArray(reponse);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /*
     * 解析和处理服务器返回的city数据
     */
    public static boolean handleCityResponse(String reponse, int provinceId) {
        if (!TextUtils.isEmpty(reponse)) {
            try {
                JSONArray allCities = new JSONArray(reponse);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /*
     * 解析和处理服务器返回的county数据
     */
    public static boolean handleCountyResponse(String reponse, int cityId) {
        if (!TextUtils.isEmpty(reponse)) {
            try {
                JSONArray allCounties = new JSONArray(reponse);
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public static Weather handleWeatherResponse(String reponse) {
        try {
            JSONObject jsonObject = new JSONObject(reponse);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent, Weather.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}








