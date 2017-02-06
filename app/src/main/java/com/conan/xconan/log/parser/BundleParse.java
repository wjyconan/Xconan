package com.conan.xconan.log.parser;

import android.os.Bundle;

import com.conan.xconan.log.common.LogConvert;

/**
 * @Description: Bundle解析器
 * @author: Conan
 * @date: 16/12/11 11:01.
 */
public class BundleParse implements Parser<Bundle> {
    @Override
    public Class<Bundle> parseClassType() {
        return Bundle.class;
    }

    @Override
    public String parseString(Bundle bundle) {
        if (bundle != null) {
            StringBuilder builder = new StringBuilder(bundle.getClass().getName() + " [" +
                    LINE_SEPARATOR);
            for (String key : bundle.keySet()) {
                builder.append(String.format("'%s' => %s " + LINE_SEPARATOR,
                        key, LogConvert.objectToString(bundle.get(key))));
            }
            builder.append("]");
            return builder.toString();
        }
        return null;
    }
}
