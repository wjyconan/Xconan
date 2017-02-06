package com.conan.xconan.log.parser;

import com.conan.xconan.log.common.LogConstant;

/**
 * @Description: 解析器接口
 * @author: Conan
 * @date: 16/12/11 10:59.
 */
public interface Parser<T> {
    String LINE_SEPARATOR = LogConstant.BR;

    Class<T> parseClassType();

    String parseString(T t);
}
