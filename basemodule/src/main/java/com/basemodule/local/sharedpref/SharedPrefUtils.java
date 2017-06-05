package com.basemodule.local.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.basemodule.utils.NativeUtil;
import com.orhanobut.hawk.Hawk;

/**
 * 对SharedPreference文件中的各种类型的数据进行存取操作
 */
public class SharedPrefUtils {

    private static SharedPreferences sp;

    private static SharedPrefUtils instance;

    private SharedPrefUtils() {
    }

    /**
     * 单例
     *
     * @return
     */
    public static SharedPrefUtils getInstance() {
        if (instance == null) {
            synchronized (SharedPrefUtils.class) {
                if (instance == null) {
                    instance = new SharedPrefUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化
     *
     * @param context
     */
    public static void init(Context context) {
        if (sp == null) {
            sp = PreferenceManager.getDefaultSharedPreferences(context);
        }
    }

    /**
     * @param key
     * @param value
     */
    public void setSharedIntData(String key, int value) {
        if (sp != null)
            sp.edit().putInt(key, value).commit();
    }

    /**
     * @param key
     * @param defValue
     * @return
     */
    public int getSharedIntData(String key, int defValue) {
        if (sp != null)
            return sp.getInt(key, defValue);
        else
            return defValue;
    }

    /**
     * @param key
     * @param value
     */
    public void setSharedlongData(String key, long value) {
        if (sp != null)
            sp.edit().putLong(key, value).commit();
    }

    /**
     * @param key
     * @param defValue
     * @return
     */
    public long getSharedlongData(String key, long defValue) {
        if (sp != null)
            return sp.getLong(key, defValue);
        else
            return defValue;
    }

    /**
     * @param key
     * @param value
     */
    public void setSharedFloatData(String key, float value) {
        if (sp != null)
            sp.edit().putFloat(key, value).commit();
    }

    /**
     * @param key
     * @param defValue
     * @return
     */
    public Float getSharedFloatData(String key, Float defValue) {
        if (sp != null)
            return sp.getFloat(key, defValue);
        else
            return defValue;
    }

    /**
     * @param key
     * @param value
     */
    public void setSharedBooleanData(String key, boolean value) {
        if (sp != null)
            sp.edit().putBoolean(key, value).commit();
    }

    /**
     * @param key
     * @param defValue
     * @return
     */
    public Boolean getSharedBooleanData(String key, boolean defValue) {
        if (sp != null)
            return sp.getBoolean(key, defValue);
        else
            return defValue;
    }

    /**
     * @param key
     * @param value
     */
    public void setSharedStringData(String key, String value) {
        if (sp != null)
            sp.edit().putString(key, value).commit();
    }

    /**
     * @param key
     * @param defValue
     * @return
     */
    public String getSharedStringData(String key, String defValue) {
        if (sp != null)
            return sp.getString(key, defValue);
        else
            return defValue;
    }

    /**
     * 删除某一项的值
     *
     * @param key
     */
    public void sharedPrefRemove(String key) {
        sp.edit().remove(key).commit();
    }

    /**
     * 清空所有的sharedPref的值
     */
    public void sharedPrefClear() {
        sp.edit().clear().commit();
    }

    /**
     * 使用hawk存储对象
     *
     * @param key
     * @param value
     */
    public void setHawkObject(String key, Object value) {
        Hawk.put(key, value);
    }

    /**
     * 获取Hawk数据
     *
     * @param key
     * @param defaultValue
     * @param <T>
     * @return
     */
    public <T> T getHawkObject(String key, T defaultValue) {
        if (!NativeUtil.isEmpty(key) && Hawk.contains(key)) {
            return Hawk.get(key, defaultValue);
        } else {
            return defaultValue;
        }
    }

    /**
     * 判断是否包含某一条Hawk数据
     *
     * @param key
     * @return
     */
    public boolean containsHawkObject(String key) {
        return Hawk.contains(key);
    }

    /**
     * 获取Hawk存储条数
     *
     * @return
     */
    public long getHawkCount() {
        return Hawk.count();
    }

    /**
     * 删除某一条Hawk数据
     *
     * @param key
     */
    public void deleteHawkObject(String key) {
        if (!NativeUtil.isEmpty(key) && Hawk.contains(key)) {
            Hawk.delete(key);
        }
    }

    /**
     * 清空Hawk所有数据
     */
    public void clearHawkObject() {
        Hawk.deleteAll();
    }
}