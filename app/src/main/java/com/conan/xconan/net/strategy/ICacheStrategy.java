package com.conan.xconan.net.strategy;

import com.conan.xconan.net.core.ApiCache;
import com.conan.xconan.net.mode.CacheResult;

import rx.Observable;

/**
 * @Description: 缓存策略接口
 * @author: Conan
 * @date: 16/12/31 14:21.
 */
public interface ICacheStrategy<T> {
    <T> Observable<CacheResult<T>> execute(ApiCache apiCache, String cacheKey, Observable<T> source, Class<T> clazz);
}
