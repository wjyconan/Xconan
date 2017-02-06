package com.conan.xconan.cache;

/**
 * @Description: 缓存接口
 * @author: Conan
 * @date: 2016-12-19 15:03
 */
public interface ICache {
    void put(String key, Object value);

    Object get(String key);

    boolean contains(String key);

    void remove(String key);

    void clear();
}
