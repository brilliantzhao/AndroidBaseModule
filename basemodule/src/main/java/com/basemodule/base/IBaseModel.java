package com.basemodule.base;

import android.content.Context;

import java.lang.reflect.ParameterizedType;

/**
 * des:baseModel
 * Created by xsf
 * on 2016.08.14:50
 */
public interface IBaseModel extends ParameterizedType {

    /**
     *
     * @param context
     */
    void setTag(Context context);
}
