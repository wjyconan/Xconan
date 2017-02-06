package com.conan.xconan;

import android.app.Application;

import com.conan.xconan.common.XCoContext;

/**
 * @Description: Application基类
 * @author: Conan
 * @date: 2016-12-19 14:49
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        XCoContext.INSTANCE.init(this);
    }
}
