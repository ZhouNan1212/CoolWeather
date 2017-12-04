package com.zhounan.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 创建时间：2017/12/4 21:35.
 * 作者：周楠
 */

public class Basic {

    @SerializedName("city")  //使用@SerializedName注解的方式让JSON字段和Java字段之间建立映射联系。
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update {
        @SerializedName("loc")
        public String updateTime;
    }
}