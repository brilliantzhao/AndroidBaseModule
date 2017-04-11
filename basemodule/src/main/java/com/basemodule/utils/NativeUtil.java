package com.basemodule.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.IBinder;

import com.basemodule.service.DownloadService;
import com.basemodule.service.ICallbackResult;

import java.io.File;

/**
 * description:
 * Date: 2017/3/22 17:12
 * User: Administrator
 */
public class NativeUtil {

    /**
     * 获取App安装包信息
     *
     * @return
     */
    public static PackageInfo getPackageInfo(Context context) {
        PackageInfo info = null;
        try {
            info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace(System.err);
        }
        if (info == null)
            info = new PackageInfo();
        return info;
    }

    /**
     * 打开应用内升级
     *
     * @param context
     * @param downurl   下载链接
     * @param tilte     标题
     * @param FILE_NAME 下载文件的路径
     * @param APP_NAME  app的名称
     * @param cls       app的主页面
     */
    public static void opeDownLoadService(Context context, String downurl, String tilte,
                                          String FILE_NAME, String APP_NAME, Class<?> cls) {
        final ICallbackResult callback = new ICallbackResult() {
            @Override
            public void OnBackResult(Object s) {
            }
        };

        ServiceConnection conn = new ServiceConnection() {
            @Override
            public void onServiceDisconnected(ComponentName name) {
            }

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                DownloadService.DownloadBinder binder = (DownloadService.DownloadBinder) service;
                binder.addCallback(callback);
                binder.start();
            }
        };
        //===
        DownloadService.getInstance().init(FILE_NAME, APP_NAME, cls);
        //===
        Intent intent = new Intent(context, DownloadService.class);
        intent.putExtra(DownloadService.BUNDLE_KEY_DOWNLOAD_URL, downurl);
        intent.putExtra(DownloadService.BUNDLE_KEY_TITLE, tilte);
        context.startService(intent);
        context.bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }

    /**
     * 安装app
     *
     * @param context
     * @param file
     */
    public static void installAPK(Context context, File file) {
        if (file == null || !file.exists())
            return;
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    /**
     * 判断给定字符串是否空白串。 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
     *
     * @param input
     * @return boolean
     */
    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input) || "null".equals(input) || "NULL".equals(input))
            return true;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }
}
