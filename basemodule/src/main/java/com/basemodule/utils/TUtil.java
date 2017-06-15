package com.basemodule.utils;

import java.lang.reflect.ParameterizedType;

/**
 * 泛型实例化工具类 (MVP模式)，通过这个类我们可以传入一个对象通过这个对象与泛型所在位置实例化出一个泛型的对象。
 * Created by baixiaokang on 16/4/30.
 */
public class TUtil {

    /**
     * @param o
     * @param i
     * @param <T>
     * @return
     */
    public static <T> T getT(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            // 由于IBaseActivity和IBaseFragment都是MVP模式，所有的activity和fragmetn都是继承自这两个，但是
            // 并不是所有的activity和fragment都是MVP模式，所以就会出现ClassCastException，此时不要慌张
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param className
     * @return
     */
    public static Class<?> forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
