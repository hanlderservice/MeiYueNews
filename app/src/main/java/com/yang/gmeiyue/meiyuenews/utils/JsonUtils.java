package com.yang.gmeiyue.meiyuenews.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

/**
 * Description:Json 转换工具类
 * Created by Administrator on 2017/5/8.
 */

public class JsonUtils {
    private static Gson gson = new Gson();

    /**
     * 将对象转换为json字符串
     *
     * @param object
     * @param <T>
     * @return
     */
    public static <T> String serialize(T object) {
        return gson.toJson(object);
    }

    /**
     * 将json字符串转换为对象
     *
     * @param json
     * @param aClass
     * @param <T>
     * @return
     * @throws JsonSyntaxException
     */
    public static <T> T deserialize(String json, Class<T> aClass) throws JsonSyntaxException {
        return gson.fromJson(json, aClass);
    }

    /**
     * 将json对象转换为实体对象
     *
     * @param jsonObject
     * @param clz
     * @param <T>
     * @return
     * @throws JsonSyntaxException
     */
    public static <T> T deserialize(JsonObject jsonObject, Class<T> clz) throws JsonSyntaxException {

        return gson.fromJson(jsonObject, clz);
    }

    /**
     * 将json字符串转换为对象
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     * @throws JsonSyntaxException
     */
    public static <T> T deserialize(String json, Type type) throws JsonSyntaxException {
        return gson.fromJson(json, type);
    }

}
