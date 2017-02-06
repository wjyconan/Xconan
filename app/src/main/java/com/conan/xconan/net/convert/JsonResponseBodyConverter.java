package com.conan.xconan.net.convert;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @Description: ResponseBody to T
 * @author: Conan
 * @date: 2017-01-04 18:04
 */
final class JsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    JsonResponseBodyConverter() {
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        return (T) value.string();
    }
}
