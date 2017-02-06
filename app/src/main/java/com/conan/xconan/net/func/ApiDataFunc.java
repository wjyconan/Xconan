package com.conan.xconan.net.func;

import com.conan.xconan.net.exception.ApiException;
import com.conan.xconan.net.mode.ApiResult;

import rx.functions.Func1;

/**
 * @Description: ApiResult<T>转T
 * @author: Conan
 * @date: 2016-12-30 17:55
 */
public class ApiDataFunc<T> implements Func1<ApiResult<T>, T> {
    public ApiDataFunc() {
    }

    @Override
    public T call(ApiResult<T> response) {
        if (ApiException.isSuccess(response)) {
            return response.getData();
        } else {
            return (T) new ApiException(new Throwable(response.getMsg()), response.getCode());
        }
    }
}
