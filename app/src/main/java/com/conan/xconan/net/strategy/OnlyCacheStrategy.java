package com.conan.xconan.net.strategy;

import com.conan.xconan.net.core.ApiCache;
import com.conan.xconan.net.mode.CacheResult;

import rx.Observable;

/**
 * @Description: 缓存策略--只取缓存
 * @author: Conan
 * @date: 16/12/31 14:29.
 */
public class OnlyCacheStrategy<T> extends CacheStrategy<T> {
    @Override
    public <T> Observable<CacheResult<T>> execute(ApiCache apiCache, String cacheKey, Observable<T> source, Class<T> clazz) {
        return loadCache(apiCache, cacheKey, clazz);
    }
}
