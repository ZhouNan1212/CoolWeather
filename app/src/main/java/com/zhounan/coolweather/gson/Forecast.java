package com.zhounan.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 创建时间：2017/12/4 22:22.
 * 作者：周楠
 */

public class Forecast {

    public String date;

    @SerializedName("tmp")
    public Temperature temperature;

    @SerializedName("cond")
    public More more;

    public class Temperature {
        public String max;
        public String min;
    }

    public class More {
        @SerializedName("txt_d")
        public String info;
    }
}
