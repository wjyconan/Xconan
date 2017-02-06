package com.conan.xconan.net.interceptor;

import android.text.TextUtils;

import com.conan.xconan.log.XCoLog;
import com.conan.xconan.common.XCoConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @Description: 在线缓存拦截
 * @author: Conan
 * @date: 16/12/31 22:23.
 */
public class OnlineCacheInterceptor implements Interceptor {
    private String cacheControlValue;

    public OnlineCacheInterceptor() {
        this(XCoConfig.MAX_AGE_ONLINE);
    }

    public OnlineCacheInterceptor(int cacheControlValue) {
        this.cacheControlValue = String.format("max-age=%d", cacheControlValue);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        okhttp3.Response originalResponse = chain.proceed(chain.request());
        String cacheControl = originalResponse.header("Cache-Control");
        if (TextUtils.isEmpty(cacheControl) || cacheControl.contains("no-store") || cacheControl.contains("no-cache") || cacheControl
                .contains("must-revalidate") || cacheControl.contains("max-age") || cacheControl.contains("max-stale")) {
            XCoLog.d(originalResponse.headers());
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, " + cacheControlValue)
                    .removeHeader("Pragma")
                    .build();

        } else {
            return originalResponse;
        }
    }
}
