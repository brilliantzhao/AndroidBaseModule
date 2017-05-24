package com.basemodule.utils.log;

import java.util.List;
import java.util.Map;

public interface Printer {

    void init(boolean isDebug, String tag, boolean isShowThreadInfo);

    String getFormatLog();

    void d(String message, Object... args);

    void e(String message, Object... args);

    void e(Throwable throwable, String message, Object... args);

    void w(String message, Object... args);

    void i(String message, Object... args);

    void v(String message, Object... args);

    void wtf(String message, Object... args);

    void json(String json);

    void xml(String xml);

    void map(Map map);

    void list(List list);
}