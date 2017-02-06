package com.conan.xconan.net.strategy;

import com.conan.xconan.log.XCoLog;
import com.conan.xconan.common.GSONUtil;
import com.conan.xconan.net.core.ApiCache;
import com.conan.xconan.net.mode.CacheResult;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @Description: 缓存策略
 * @author: Conan
 * @date: 16/12/31 14:28.
 */
public abstract class CacheStrategy<T> implements ICacheStrategy<T> {
    <T> Observable<CacheResult<T>> loadCache(final ApiCache apiCache, final String key, final Class<T>
            clazz) {
        return apiCache.<T>get(key).filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s != null;
            }
        }).map(new Func1<String, CacheResult<T>>() {
            @Override
            public CacheResult<T> call(String s) {
                T t = GSONUtil.gson().fromJson(s, clazz);
                XCoLog.i("loadCache result=" + t);
                return new CacheResult<T>(true, t);
            }
        });
    }

    <T> Observable<CacheResult<T>> loadRemote(final ApiCache apiCache, final String key, Observable<T> source) {
        return source.map(new Func1<T, CacheResult<T>>() {
            @Override
            public CacheResult<T> call(T t) {
                XCoLog.i("loadRemote result=" + t);
                apiCache.put(key, t).subscribeOn(Schedulers.io()).subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean status) {
                        XCoLog.i("save status => " + status);
                    }
                });
                return new CacheResult<T>(false, t);
            }
        });
    }
}
