# AndroidBaseModule
android base module project
基础的Android开发依赖包，独立出来主要是为了持续更新，方便多个项目同时使用，同步更新；同时使工程结构更加简洁。

### 使用方式

1) 新工程建议直接下载[AndroidMouldProject](https://github.com/BrillantZhao/AndroidMouldProject)，修改包名后在此基础上开发；
    
or

2) Add Library module as a dependency in your build.gradle file.

##### Add the dependency

    dependencies {
	        compile 'com.github.BrillantZhao:AndroidBaseModule:1.1.2.32'
	    }
	
### 项目结构
![Alt text](https://github.com/yuanzaiyuanfang/AndroidBaseModule/raw/master/images/工程结构.png)

### 用到的第三方库

```xml
        //=== butterKnife (https://github.com/JakeWharton/butterknife)
        "butterknife"           : "com.jakewharton:butterknife:${butterKnifeVersion}",
        "butterknife-compiler"  : "com.jakewharton:butterknife-compiler:${butterKnifeVersion}",

        //=== rxjava(https://github.com/ReactiveX/RxJava)
        "rxjava"                : "io.reactivex:rxjava:${rxjavaVersion}",

        //=== rxandroid(https://github.com/ReactiveX/RxAndroid)
        "rxandroid"             : "io.reactivex:rxandroid:${rxandroidVersion}",

        //=== AndroidUtilCode  (https://github.com/Blankj/AndroidUtilCode)
        "utilcode"              : "com.blankj:utilcode:${utilcodeVersion}",

        //=== RxLifecycle  (https://github.com/trello/RxLifecycle)
        "rxlifecycle"           : "com.trello:rxlifecycle:${rxlifecycleVersion}",
        "rxlifecycle-android"   : "com.trello:rxlifecycle-android:${rxlifecycleVersion}",
        "rxlifecycle-components": "com.trello:rxlifecycle-components:${rxlifecycleVersion}",
        "rxlifecycle-navi"      : "com.trello:rxlifecycle-navi:${rxlifecycleVersion}",
        "rxlifecycle-kotlin"    : "com.trello:rxlifecycle-kotlin:${rxlifecycleVersion}",

        //=== logger (https://github.com/orhanobut/logger)
        "logger"                : "com.orhanobut:logger:${loggerVersion}",

        //=== SystemBarTint(https://github.com/jgilfelt/SystemBarTint)
        "systembartint"         : "com.readystatesoftware.systembartint:systembartint:${systembartintVersion}",

        //=== glide (https://github.com/bumptech/glide)
        "glide"                 : "com.github.bumptech.glide:glide:${glideVersion}",

        //=== hawk (https://github.com/orhanobut/hawk)
        "hawk"                  : "com.orhanobut:hawk:${hawkVersion}",

        //=== fastjson (https://github.com/alibaba/fastjson)
        "fastjson"              : "com.alibaba:fastjson:${fastjsonVersion}"
            
```

## API

* ### base相关→最底层的继承
```
        IBaseActivity            : "",
        IBaseApplication         : "",
        IBaseFragment            : "",
        IBaseFragmentAdapter     : "",
        IBaseFragmentStateAdapter: "",
        IBaseModel               : "",
        IBasePresenter           : "",
        IBaseView                : "",
```

* ### baseapp相关→应用的一些基本工具类
```
        AppException: "异常记录与处理",
        AppManager  : "activity管理工具",
        BaseRespose : "网络请求基础返回",
```

* ### baserx相关→rx底层处理
```
        RxBus          : "",
        RxCache        : "",
        RxHelper       : "",
        RxManager      : "",
        RxSchedulers   : "",
        RxSubscriber   : "",
        ServerException: "",
```

* ### local相关→数据存储
```
        SharedPrefUtils: "sharedPreference数据存储",
```

* ### notes相关→说明文档
```
        Android 代码混淆在AS的实践
        Android 使用gradle打包的各种配置
        Android 自动化打包实践 gradle打包并推送到git远程库
        Android开发之版本统一规范
        GitSubmodule
        神注释大全
```

* ### utils相关→自定义的工具类
```
        ACache                  : "",
        CollectionUtils         : "",
        DialogPermissionUtil    : "",
        DisplayUtil             : "",
        FormatUtil              : "",
        GlideCircleTransfromUtil: "",
        GlideRoundTransformUtil : "",
        ImageLoaderUtils        : "",
        IpUtils                 : "",
        JsonConvertHelper       : "",
        MeasureUtils            : "",
        NetWorkUtils            : "",
        RxCountDown             : "",
        SDCardUtils             : "",
        TimeUtil                : "",
        TUtil                   : "",
```
	       
* ### widget相关→自定义的控件
```
        NoScrollGridView       : "",
        NoScrollListview       : "",
        OnDoubleClickListener  : "",
        OnNoDoubleClickListener: "",
```
	       
### 详细介绍
参见 AndroidBaseModule，工程地址为：https://github.com/BrillantZhao/AndroidBaseModule

参见 AndroidMouldProject，工程地址为：https://github.com/BrillantZhao/AndroidMouldProject

###License
>The MIT License (MIT)

>Copyright (c) 2015 Dee

>Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

>The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.