package com.conan.xconan.event;

/**
 * @Description: 事件总线接口
 * @author: Conan
 * @date: 2016-12-19 15:06
 */
public interface IBus {
    void register(Object object);

    void unregister(Object object);

    void post(IEvent event);

    void postSticky(IEvent event);
}
