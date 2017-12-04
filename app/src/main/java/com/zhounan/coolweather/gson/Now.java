package com.zhounan.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 创建时间：2017/12/4 22:14.
 * 作者：周楠
 */

public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More {

        @SerializedName("txt")
        public String info;

    }
}