package com.basemodule.utils;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

import java.io.Reader;
import java.lang.reflect.Type;

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧）Github地址：https://github.com/jeasonlzy
 * 版    本：1.0
 * 创建日期：16/9/28
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class JsonConvertHelper {

    /**
     *
     * @return
     */
    private static Gson create() {
        return JsonConvertHelper.GsonHolder.gson;
    }

    /**
     *
     */
    private static class GsonHolder {
        private static Gson gson = new Gson();
    }

    /**
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    public static <T> T fromJson(String json, Class<T> type) throws JsonIOException, JsonSyntaxException {
        return create().fromJson(json, type);
    }

    /**
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, Type type) {
        return create().fromJson(json, type);
    }

    /**
     *
     * @param reader
     * @param typeOfT
     * @param <T>
     * @return
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    public static <T> T fromJson(JsonReader reader, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        return create().fromJson(reader, typeOfT);
    }

    /**
     *
     * @param json
     * @param classOfT
     * @param <T>
     * @return
     * @throws JsonSyntaxException
     * @throws JsonIOException
     */
    public static <T> T fromJson(Reader json, Class<T> classOfT) throws JsonSyntaxException, JsonIOException {
        return create().fromJson(json, classOfT);
    }

    /**
     *
     * @param json
     * @param typeOfT
     * @param <T>
     * @return
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    public static <T> T fromJson(Reader json, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        return create().fromJson(json, typeOfT);
    }

    /**
     *
     * @param src
     * @return
     */
    public static String toJson(Object src) {
        return create().toJson(src);
    }

    /**
     *
     * @param src
     * @param typeOfSrc
     * @return
     */
    public static String toJson(Object src, Type typeOfSrc) {
        return create().toJson(src, typeOfSrc);
    }
}