package com.basemodule.base;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.basemodule.utils.NativeUtil;
import com.blankj.utilcode.util.Utils;
import com.orhanobut.hawk.Hawk;

/**
 * description:
 * Date: 2016/11/4 09:33
 * User: Administrator
 */
public class IBaseApplication extends MultiDexApplication {

    //##########################  custom variables start ##########################################

    public final String TAG = this.getClass().getSimpleName();

    private static Context _context;

    private static IBaseApplication appInstance;

    private static PackageInfo packageInfo;

    private static Dialog progressDialog;

    //##########################   custom variables end  ##########################################

    //######################  override methods start ##############################################

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
        setContext(getApplicationContext());
        //=== init AndroidUtilCode
        Utils.init(this);
        //=== 安装包信息
        setPackageInfo(NativeUtil.getPackageInfo(getContext()));
        //=== init Hawk
        Hawk.init(this).build();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    //######################   override methods end  ##############################################

    //###################### override custom metohds start ########################################

    //######################  override custom metohds end  ########################################

    //######################      custom metohds start     ########################################

    /**
     * 分包
     *
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    //######################    custom metohds end   ##############################################

    //#################################################################### getter and setter start

    public static Context getContext() {
        return _context;
    }

    public static void setContext(Context _context) {
        IBaseApplication._context = _context;
    }

    public static PackageInfo getPackageInfo() {
        if (packageInfo == null) {
            packageInfo = NativeUtil.getPackageInfo(getContext());
        }
        return packageInfo;
    }

    public static void setPackageInfo(PackageInfo packageInfo) {
        IBaseApplication.packageInfo = packageInfo;
    }

    /**
     * @return
     */
    public static synchronized IBaseApplication getAppInstance() {
        if (appInstance == null) {
            appInstance = new IBaseApplication();
        }
        return appInstance;
    }

    public static synchronized IBaseApplication context() {
        return (IBaseApplication) _context;
    }

    public static Resources getAppResources() {
        return appInstance.getResources();
    }

    public static Dialog getProgressDialog() {
        return progressDialog;
    }

    public static void setProgressDialog(Dialog progressDialog) {
        IBaseApplication.progressDialog = progressDialog;
    }

    //#################################################################### getter and setter end

}
