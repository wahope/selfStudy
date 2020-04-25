package com.selfStudy.common;

import net.sf.json.JSONObject;

public class ObjectToJson {
    /***
     * 将对象转换为JSON对象
     * @param object
     * @return
     */
    public static JSONObject toJSONObject(Object object) {
        return JSONObject.fromObject(object);
    }

    public ObjectToJson() {
    }
}
