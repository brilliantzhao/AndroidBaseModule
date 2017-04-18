package com.basemodule.okgo;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cookie.store.CookieStore;
import com.orhanobut.logger.Logger;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.HttpUrl;

/**
 * description:
 * Date: 2017/4/18 11:23
 * User: Administrator
 */
public class CookUtils {

    /**
     * 获取指定url对应的cookie
     *
     * @param url
     */
    public void getCookie(String url) {
        //一般手动取出cookie的目的只是交给 webview 等等，非必要情况不要自己操作
        CookieStore cookieStore = OkGo.getInstance().getCookieJar().getCookieStore();
        HttpUrl httpUrl = HttpUrl.parse(url);
        List<Cookie> cookies = cookieStore.getCookie(httpUrl);
        Logger.i(httpUrl.host() + "对应的cookie如下：" + cookies.toString());
    }

    /**
     * 获取所有的cookie
     */
    public void getAllCookie() {
        //一般手动取出cookie的目的只是交给 webview 等等，非必要情况不要自己操作
        CookieStore cookieStore = OkGo.getInstance().getCookieJar().getCookieStore();
        List<Cookie> allCookie = cookieStore.getAllCookie();
        Logger.i("所有cookie如下：" + allCookie.toString());
    }

    /**
     * 添加自定义cookie
     * eg:
     * Cookie.Builder builder = new Cookie.Builder();
     * Cookie cookie = builder.name("myCookieKey1").value("myCookieValue1").domain(httpUrl.host()).build();
     *
     * @param url
     * @param cookie
     */
    public void addCookie(String url, Cookie cookie) {
        HttpUrl httpUrl = HttpUrl.parse(url);
        CookieStore cookieStore = OkGo.getInstance().getCookieJar().getCookieStore();
        cookieStore.saveCookie(httpUrl, cookie);
        Logger.i("详细添加cookie的代码，请看demo的代码");
    }

    /**
     * 手动移除cookie
     * eg:
     * CookieStore cookieStore = OkGo.getInstance().getCookieJar().getCookieStore();
     *
     * @param url
     * @param cookieStore
     */
    public void removeCookie(String url, CookieStore cookieStore) {
        HttpUrl httpUrl = HttpUrl.parse(url);
        cookieStore.removeCookie(httpUrl);
        Logger.i("详细移除cookie的代码，请看demo的代码");
    }
}
