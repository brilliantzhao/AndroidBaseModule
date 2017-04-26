package com.basemodule.okgo;

import android.content.Context;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okgo.request.PostRequest;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * description:
 * Date: 2017/4/7 11:13
 * User: Administrator
 */
public class OkGoRequest {

    /**
     * 普通Post，直接上传Json类型的文本
     * <p>
     * 该方法与postString没有本质区别，只是数据格式是json,一般来说，需要自己创建一个实体bean或者一个map，
     * 把需要的参数设置进去，然后通过三方的Gson或者fastjson转换成json字符串，最后直接使用该方法提交到服务器。
     * 默认会携带以下请求头，请不要手动修改，okgo也不支持自己修改
     * Content-Type: application/json;charset=utf-8
     *
     * @param context
     * @param url
     * @return
     */
    public static PostRequest postJsonRequest(Context context, String url, HashMap<String, Object> map) {
        return OkGo.post(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                //.params("param1", "paramValue1")//  这里不要使用params，upJson 与 params 是互斥的，只有 upJson 的数据会被上传
                .isMultipart(true)         //强制使用 multipart/form-data 表单上传（只是演示，不需要的话不要设置。默认就是false）
                .upJson(new Gson().toJson(map));
    }

    /**
     * 普通Post，直接上传文本
     *
     * @param context
     * @param url
     * @param upString
     * @return
     */
    public static PostRequest postStringRequest(Context context, String url, String upString) {
        return OkGo.post(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                //.params("param1", "paramValue1")//  这里不要使用params，upJson 与 params 是互斥的，只有 upJson 的数据会被上传
                .isMultipart(true)         //强制使用 multipart/form-data 表单上传（只是演示，不需要的话不要设置。默认就是false）
                .upString(upString); //上传的文本
    }

    /**
     * 普通post, 上传字节数据
     *
     * @param context
     * @param url
     * @param bytes
     * @return
     */
    public static PostRequest postByteRequest(Context context, String url, byte[] bytes) {
        return OkGo.post(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                //.params("param1", "paramValue1")// 这里不要使用params，upBytes 与 params 是互斥的，只有 upBytes 的数据会被上传
                .isMultipart(true)         //强制使用 multipart/form-data 表单上传（只是演示，不需要的话不要设置。默认就是false）
                .upBytes(bytes); //字节数据
    }

    /**
     * 文件上传
     *
     * @param context
     * @param url
     * @param files   文件的路径集合
     * @return
     */
    public static PostRequest formUploadRequest(Context context, String url, HashMap<String, String> map, ArrayList<File> files) {
        return OkGo.post(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                .params(map)
                .isMultipart(true)         //强制使用 multipart/form-data 表单上传（只是演示，不需要的话不要设置。默认就是false）
                .addFileParams("file", files);
    }

    /**
     * 文件下载
     *
     * @param context
     * @param url
     * @return
     */
    public static PostRequest fileDownloadRequest(Context context, String url, HashMap<String, String> map) {
        return OkGo.post(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                .isMultipart(true)         //强制使用 multipart/form-data 表单上传（只是演示，不需要的话不要设置。默认就是false）
                .params(map);
    }

    /**
     * 请求图片 post方式
     *
     * @param context
     * @param url
     * @return
     */
    public static PostRequest bitmapRequestWithPost(Context context, String url, HashMap<String, String> map) {
        return OkGo.post(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                .isMultipart(true)         //强制使用 multipart/form-data 表单上传（只是演示，不需要的话不要设置。默认就是false）
                .params(map);
    }

    /**
     * 请求图片 get方式
     *
     * @param context
     * @param url
     * @param map
     * @return
     */
    public static GetRequest bitmapRequestWithGet(Context context, String url, HashMap<String, String> map) {
        return OkGo.get(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                .params(map);
    }

    /**
     * 普通Get请求
     *
     * @param context
     * @param url
     * @param map
     * @return
     */
    public static GetRequest getStringRequest(Context context, String url, HashMap<String, String> map) {
        return OkGo.get(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                .params(map);
    }

    /**
     * 普通get请求，不使用缓存
     *
     * @param context
     * @param url
     * @param map
     * @return
     */
    public static GetRequest getRequestWithNoCache(Context context, String url, HashMap<String, String> map) {
        return OkGo.get(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                .cacheMode(CacheMode.NO_CACHE)//
                .cacheKey("no_cache")   //对于无缓存模式,该参数无效
                .cacheTime(5000)        //对于无缓存模式,该时间无效
                .params(map);
    }

    /**
     * 普通get请求，Http标准的缓存协议(304缓存头)
     *
     * @param context
     * @param url
     * @param map
     * @return
     */
    public static GetRequest getRequestWithDefaultCache(Context context, String url, HashMap<String, String> map) {
        return OkGo.get(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                .cacheMode(CacheMode.DEFAULT)//
                .cacheKey("cache_default")//
                .cacheTime(5000)//对于默认的缓存模式,该时间无效,依靠的是服务端对304缓存的控制
                .params(map);
    }

    /**
     * 普通get请求，先请求网络，如果失败，则返回上次的缓存
     *
     * @param context
     * @param url
     * @param map
     * @return
     */
    public static GetRequest getRequestWithFailedReadCache(Context context, String url, HashMap<String, String> map) {
        return OkGo.get(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                .cacheMode(CacheMode.REQUEST_FAILED_READ_CACHE)//
                .cacheKey("request_failed_read_cache")//
                .cacheTime(5000)            // 单位毫秒.5秒后过期
                .params(map);
    }

    /**
     * 普通get请求，先读取缓存，如果缓存不存在，才请求网络，\n如果网络请求也失败，则请求失败
     *
     * @param context
     * @param url
     * @param map
     * @return
     */
    public static GetRequest getRequestWithIfNoCache(Context context, String url, HashMap<String, String> map) {
        return OkGo.get(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                .cacheMode(CacheMode.IF_NONE_CACHE_REQUEST)//
                .cacheKey("if_none_cache_request")//
                .cacheTime(5000)            // 单位毫秒.5秒后过期
                .params(map);
    }

    /**
     * 普通get请求，先读取缓存，无论缓存是否存在，都请求网络，\n如果网络请求失败，则仍然使用缓存
     *
     * @param context
     * @param url
     * @param map
     * @return
     */
    public static GetRequest getRequestWithFirstCacheThen(Context context, String url, HashMap<String, String> map) {
        return OkGo.get(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)//
                .cacheKey("only_read_cache")//
                .cacheTime(5000)            // 单位毫秒.5秒后过期
                .params(map);
    }

}
