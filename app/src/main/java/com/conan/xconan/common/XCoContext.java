package com.conan.xconan.common;

import android.content.Context;
import android.util.Log;

import com.conan.xconan.BuildConfig;
import com.conan.xconan.log.XCoLog;
import com.conan.xconan.log.inner.DefaultTree;

/**
 * @Description: 全局初始化配置
 * @author: Conan
 * @date: 2-12-19 14:50
 */
public enum XCoContext {
    INSTANCE;
    private Context context;

    public void init(Context context) {
        this.context = context;
        initLog();
    }

    public Context getContext() {
        return context;
    }

    private void initLog() {
        XCoLog.getLogConfig()
                .configAllowLog(BuildConfig.LOG_DEBUG)//是否输出日志
                .configShowBorders(true)//是否排版显示
                .configTagPrefix("XCoLog")//设置标签前缀
                .configFormatTag("%d{HH:mm:ss} %t %c{-3}")//个性化设置标签，默认显示包名
                .configLevel(Log.VERBOSE);//设置日志最小输出级别，默认Log.VERBOSE
        XCoLog.plant(new DefaultTree());
    }
}
