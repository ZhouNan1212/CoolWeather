package com.zhounan.coolweather.gson;

/**
 * 创建时间：2017/12/4 22:13.
 * 作者：周楠
 */

public class AQI {
    public AQICity city;

    public class AQICity {

        public String aqi;

        public String pm25;

    }
}