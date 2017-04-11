package com.basemodule.okgo;

import com.orhanobut.logger.Logger;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HttpDNSInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originRequest = chain.request();
        HttpUrl httpUrl = originRequest.url();

        String url = httpUrl.toString();
        String host = httpUrl.host();
        Logger.d("originalUrl:" + url);

        // 通过HTTPDNS获取IP成功，进行URL替换和HOST头设置
        String newUrl = url;
        try {
            // String ip = IBaseApplication.getHttpdns().getIpByHostAsync(host);
            String ip = null;
            if (ip != null) {
                newUrl = url.replaceFirst(host, ip);
                Logger.d("Get IP: " + ip + " for host: " + host + " from HTTPDNS successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            newUrl = url;
        }

        Request.Builder builder = originRequest.newBuilder();
        builder.url(newUrl);
        builder.header("Host", host);

        Request newRequest = builder.build();
        Logger.d("newUrl:" + newRequest.url());
        Response newResponse = chain.proceed(newRequest);
        return newResponse;
    }
}