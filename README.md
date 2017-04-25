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
	
### 项目结构
![Alt text](https://github.com/yuanzaiyuanfang/AndroidBaseModule/raw/master/images/xiangmujiegou.png)

	
### 相关工具类
 
 - CollectionUtils : 集合操作工具类
   - isNullOrEmpty : 是否为空
 - DialogPermissionUtil : 权限对话框管理
   - PermissionDialog : 弹出需要权限的提示对话框
   - startSettingIntent : 启动授权界面
 - DisplayUtil : 屏幕相关的辅助类
   - px2dip : 将px值转换为dip或dp值，保证尺寸大小不变
   - dip2px : 将dip或dp值转换为px值，保证尺寸大小不变
   - px2sp : 将px值转换为sp值，保证文字大小不变
   - sp2px : 将sp值转换为px值，保证文字大小不变
   - getWidgetWH : 直接获取控件的宽、高
   - getViewHeight : 直接获取控件的高
   - getViewWidth : 直接获取控件的宽
   - getScreenWidth : 获得屏幕宽度
   - getScreenHeight : 获得屏幕高度
   - getStatusBarHeight : 获得状态栏的高度
   - getWidgetWidth : 获取控件的宽
   - getWidgetHeight : 获取控件的高
   - setWidgetWidth : 设置控件宽  
   - setWidgetHeight : 设置控件高  
   - snapShotWithStatusBar : 获取当前屏幕截图，包含状态栏 
   - snapShotWithoutStatusBar : 获取当前屏幕截图，不包含状态栏  
 - FormatUtil : 字符串校验
   - isMobileNO :  验证手机格式
   - isEmail :  判断email格式是否正确
   - isNumeric :  判断是否全是数字
   - isIdCardNo :  判断身份证格式
   - isChinese :  判定输入汉字
   - checkNameChese :  检测String是否全是中文
   - checkBankCard :  判断是否是银行卡号
   - IDCardValidate : 身份证的有效验证
   - GetAreaCode : 设置地区编码
   - isDataFormat : 验证日期字符串是否是YYYY-MM-DD格式
   - checkValue : 空值null返回"",防止脏数据奔溃
 - ImageLoaderUtils : 图片加载工具类 使用glide框架封装
   - display : 显示图片 默认设置
   - display : 显示图片 有占位图和错误显示图
   - displaySmallPhoto : 显示缩略小图
   - displayBigPhoto : 显示高清大图
   - displayBigPhotoWithoutPlaceHolder : 显示大图 没有占位图
   - displayRound : 显示圆图
 - IpUtils : ip管理
   - GetHostIp : 获取ip
 - JsonUtils : JSON解析二次封装
   - toJson : 将对象转为JSON串，此方法能够满足大部分需求
   - fromJson : 将JSON串转为对象
   - getValue : 获取json中的某个string值
   - getListValue : 获取json中的list值
   - getDoubleValue : 获取json中的某个double值
   - getIntValue : 获取json中的某个int值
 - KeyBordUtil : 输入框弹出管理
   - popSoftKeyboard : 显示和隐藏软键盘
   - showSoftKeyboard : 显示软键盘
   - hideSoftKeyboard : 隐藏软键盘
 - ListUtils : 集合操作
   - getSize : 获取集合大小
   - isEmpty : 是否为空
   - join : 加入集合
   - addDistinctEntry : 加入对象
   - addDistinctList : 加入集合
   - distinctList : 去除重复个数
   - addListNotNullValue : 集合不为空时,加入制指定值
   - invertList : 逆序
 - MeasureUtils : 尺寸转换
   - dp2px : dp转px
   - sp2px : sp转px
   - getMeasuredWidthWithMargins : 测量带边距的宽度
   - getDisplayMetrics : 获取频幕参数
   - getViewLocation : 获取控件位置
 - NativeUtil : app相关信息,下载安装等
   - getPackageInfo : 获取App安装包信息 
   - isEmpty : 判断给定字符串是否空白串
 - NetWorkUtils : 网络管理工具
   - isNetConnected : 检查网络是否可用
   - isWifiConnected : 检测wifi是否连接
   - is3gConnected : 检测3G是否连接
   - isLinkAvailable : 判断网址是否有效
 - SDCardUtils : SD卡工具箱
   - getState : 获取SD卡的状态
   - isAvailable : SD卡是否可用
   - getRootDirectory : 获取SD卡的根目录
   - getRootPath : 获取SD卡的根路径
   - getSDPath : 获取sd卡路径
   - getFreeSpaceBytes : 获取空闲的空间大小
 - TimeUtil : 日期处理类
   - formatData : 时间戳转特定格式时间
   - getDateByFormat :String类型的日期时间转化为Date类型
   - getDateByOffset : 获取偏移之后的Date
   - 。。。
 - TUtil : 类转换初始化
   - getT : 获取泛型类型
   - forName : 初始化类
 - ViewHolderUtil : 获取view
   - get : 获取控件
 - ACache : 本地文件缓存工具类
 - AdViewpagerUtil : 广告轮播viewpager管理
 - GlideCircleTransfromUtil : glide转圆形图片
 - GlideRoundTransformUtil : glide转圆角图片
	       
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