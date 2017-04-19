# AndroidBaseModule
android base module project
基础的Android开发依赖包，独立出来主要是为了持续更新，方便多个项目同时使用，同步更新；同时使工程结构更加简洁。

### 使用方式

1)  新工程建议直接下载AndroidBaseModule，修改包名后在此基础上开发；
    
    工程地址为：https://github.com/BrillantZhao/AndroidMouldProject

2) Add Library module as a dependency in your build.gradle file.

or

##### Step 1. Add the JitPack repository to your build file 

Add it in your root build.gradle at the end of repositories:
```xml
allprojects {
    repositories {
		...
		maven { url 'https://jitpack.io' }
		// hotfix(项目中使用了阿里的hotfix热修复技术，此处需要引入)
        maven {
        url "http://repo.baichuan-android.taobao.com/content/groups/BaichuanRepositories"
        }
        // ali httpdns(项目中使用了阿里的dns域名解析，此处需要引入)
        maven {
        url 'http://maven.aliyun.com/nexus/content/repositories/releases/'
        }
			
	    }
	}
```
##### Step 2. Add the dependency

    dependencies {
	        compile 'com.github.BrillantZhao:AndroidBaseModule:1.1.2.23'
	    }
	
### 相关工具类
 - ACache : 本地文件缓存工具类
 - AdViewpagerUtil : 广告轮播viewpager管理
 - CollectionUtils : 集合操作工具类
 - DialogPermissionUtil : 权限对话框管理
 - DisplayUtil : 屏幕相关的辅助类
 - FormatUtil : 字符串校验
 - GlideCircleTransfromUtil : glide转圆形图片
 - GlideRoundTransformUtil : glide转换圆角图片
 - ImageLoaderUtils : 图片加载工具类 使用glide框架封装
 - IpUtils : ip管理
 - JsonUtils : JSON解析二次封装
 - KeyBordUtil : 输入框弹出管理
 - ListUtils : 集合操作
 - MeasureUtils : 尺寸转换
 - NativeUtil : app相关信息,下载安装等
 - NetWorkUtils : 网络管理工具
 - SDCardUtils : SD卡工具箱
 - TimeUtil : 日期处理类
 - ToastUitl : Toast统一管理类
 - TUtil : 类转换初始化
 - ViewHolderUtil : 获取view
	       
### 详细介绍

参见 AndroidBaseModule，工程地址为：https://github.com/BrillantZhao/AndroidMouldProject


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