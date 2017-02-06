package com.conan.xconan.download.core;

import android.support.annotation.NonNull;

import com.conan.xconan.download.mode.DownEvent;
import com.conan.xconan.download.mode.DownProgress;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 下载事件工厂
 * @author: Conan
 * @date: 17/1/16 21:56.
 */
public class DownEventFactory {
    private volatile static DownEventFactory singleton;
    private Map<String, DownEvent> map = new HashMap<>();

    private DownEventFactory() {
    }

    public static DownEventFactory getSingleton() {
        if (singleton == null) {
            synchronized (DownEventFactory.class) {
                if (singleton == null) {
                    singleton = new DownEventFactory();
                }
            }
        }
        return singleton;
    }

    public DownEvent factory(String url, int status, DownProgress progress) {
        DownEvent event = createEvent(url, status, progress);
        event.setError(null);
        return event;
    }

    public DownEvent factory(String url, int status, DownProgress progress, Throwable throwable) {
        DownEvent event = createEvent(url, status, progress);
        event.setError(throwable);
        return event;
    }

    @NonNull
    private DownEvent createEvent(String url, int status, DownProgress progress) {
        DownEvent event = map.get(url);
        if (event == null) {
            event = new DownEvent();
            map.put(url, event);
        }
        event.setDownProgress(progress == null ? new DownProgress() : progress);
        event.setStatus(status);
        return event;
    }
}
