package io.github.zhidao.ms.common.util;

import cn.hutool.core.util.ObjectUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * - HttpRequestUtils工具类
 *
 * @author zhanls 2023/2/27 21:41
 **/
public class HttpRequestUtils {

    /**
     * 获取当前线程HttpServletRequest
     * zhanls 2023/2/27 21:42
     */
    public static HttpServletRequest getHttpServletRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (ObjectUtil.isNotNull(requestAttributes)) {
            return requestAttributes.getRequest();
        } else {
            return null;
        }
    }

}
