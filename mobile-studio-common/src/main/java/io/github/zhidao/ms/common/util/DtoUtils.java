package io.github.zhidao.ms.common.util;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;

/**
 * -  Dto 工具类
 *
 * @author zhanls 2023/3/12 15:18
 **/
@Slf4j
public class DtoUtils {

    /**
     *  将DTO中的空字符串属性置为NULL
     */
    public static <T> T setNullValue(T source) {
        try {
//            Field[] fields = source.getClass().getDeclaredFields(); // 不包含继承来的字段
            Field[] fields = FieldUtils.getAllFields(source.getClass());
            for (Field field : fields) {
                if ("class java.lang.String".equals(field.getGenericType().toString())) {
                    field.setAccessible(true);
                    Object obj = field.get(source);
                    if ("".equals(obj)) {
                        field.set(source, null);
                    }
                }
            }
        } catch (Exception e) {
            log.error("DtoUtil.setNullValue exception{}", e);
        }
        return source;
    }
}
