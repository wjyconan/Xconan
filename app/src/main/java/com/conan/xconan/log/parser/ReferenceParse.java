package com.conan.xconan.log.parser;

import com.conan.xconan.log.common.LogConvert;

import java.lang.ref.Reference;

/**
 * @Description: Reference解析器
 * @author: Conan
 * @date: 16/12/11 11:04.
 */
public class ReferenceParse implements Parser<Reference> {
    @Override
    public Class<Reference> parseClassType() {
        return Reference.class;
    }

    @Override
    public String parseString(Reference reference) {
        Object actual = reference.get();
        StringBuilder builder = new StringBuilder(reference.getClass().getSimpleName() + "<"
                + actual.getClass().getSimpleName() + "> {");
        builder.append("→" + LogConvert.objectToString(actual));
        return builder.toString() + "}";
    }
}
