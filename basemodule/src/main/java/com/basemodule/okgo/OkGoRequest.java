package com.basemodule.okgo;

import android.content.Context;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
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
    public static PostRequest getPostJsonRequest(Context context, String url, HashMap<String, Object> map) {
        return OkGo.post(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                //	.params("param1", "paramValue1")//  这里不要使用params，upJson 与 params 是互斥的，只有 upJson 的数据会被上传
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
    public static PostRequest getPostStringRequest(Context context, String url, String upString) {
        return OkGo.post(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                //	.params("param1", "paramValue1")//  这里不要使用params，upJson 与 params 是互斥的，只有 upJson 的数据会被上传
                .upString(upString); //上传的文本
    }

    /**
     * 图片上传
     *
     * @param context
     * @param url
     * @param files   文件的路径
     * @return
     */
    public static PostRequest formUploadRequest(Context context, String url, ArrayList<File> files) {
        return OkGo.post(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                .addFileParams("file", files);
    }

    /**
     * 文件下载
     *
     * @param context
     * @param url
     * @return
     */
    public static PostRequest fileDownloadRequest(Context context, String url) {
        return OkGo.post(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                ;
    }


}
