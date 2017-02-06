package com.conan.xconan.net.mode;

import com.conan.xconan.common.XCoConfig;

/**
 * @Description: 主机信息
 * @author: Conan
 * @date: 2017-01-06 10:37
 */
public class ApiHost {

    private static String host = XCoConfig.API_HOST;

    public static String getHost() {
        return host;
    }

    public static void setHost(String url) {
        setHostHttps(url);
    }

    public static void setHostHttp(String url) {
        if (url.startsWith("https://") || url.startsWith("http://")) {
            host = url;
            host = host.replaceAll("https://", "http://");
        } else {
            host = "http://" + url;
        }
    }

    public static void setHostHttps(String url) {
        if (url.startsWith("https://") || url.startsWith("http://")) {
            host = url;
            host = host.replaceAll("http://", "https://");
        } else {
            host = "https://" + url;
        }
    }

    public static String getHttp() {
        if (host.startsWith("https://") || host.startsWith("http://")) {
            host = host.replaceAll("https://", "http://");
        } else {
            host = "http://" + host;
        }
        return host;
    }

    public static String getHttps() {
        if (host.startsWith("https://") || host.startsWith("http://")) {
            host = host.replaceAll("http://", "https://");
        } else {
            host = "https://" + host;
        }
        return host;
    }

}
