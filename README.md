# AndroidBaseModule
android base module project
基础的Android开发依赖包，独立出来主要是为了持续更新，方便多个项目同时使用，同步更新；同时使工程结构更加简洁。

### 使用方式

1)  新工程建议直接下载AndroidBaseModule，修改包名后在此基础上开发；
    
    工程地址为：https://github.com/BrillantZhao/AndroidBaseModule

2) Add Library module as a dependency in your build.gradle file.

or

##### Step 1. Add the JitPack repository to your build file 

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
			// hotfix
            maven {
               url "http://repo.baichuan-android.taobao.com/content/groups/BaichuanRepositories"
            }
            // ali httpdns
            maven {
               url 'http://maven.aliyun.com/nexus/content/repositories/releases/'
            }
			
		}
	}

##### Step 2. Add the dependency

    dependencies {
	        compile 'com.github.BrillantZhao:AndroidMouldProject:1.0.1'
	    }
	    
### 详细介绍

参见 AndroidBaseModule，工程地址为：https://github.com/BrillantZhao/AndroidBaseModule


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