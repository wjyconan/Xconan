package com.conan.xconan.event;

import com.conan.xconan.event.inner.EventThread;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 接收事件注解，必须在接收事件地方定制该注解
 * @author: Conan
 * @date: 2016-12-29 19:03
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface EventSubscribe {
    EventThread thread() default EventThread.MAIN_THREAD;
}
