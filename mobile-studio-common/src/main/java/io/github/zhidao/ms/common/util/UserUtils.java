package io.github.zhidao.ms.common.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import io.github.zhidao.ms.common.constant.Constant;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * - 用户工具
 *
 * @author zhanls 2023/2/27 21:35
 **/
@Slf4j
public class UserUtils {

    /**
     * 用户id
     */
    public static final String LOGIN_USER_ID = "userId";
    public static final String NO_LOGIN_USER = "noLoginUser";

    /**
     * TOKEN 标识
     */
    public static final String TOKEN = "token";

    /**
     * Bearer 占位符
     */

    protected static final String BEARER_TOKEN_PREFIX = "Bearer ";
    /**
     * Authorization权限
     */
    protected static final String HEAD_TOKEN = "Authorization";

    /**
     * 获取当前登录用户信息
     * TODO String对象优化成实体DTO对象
     * zhanls 2023/2/27 21:39
     */
    public static String getUserInfo(){
        HttpServletRequest httpServletRequest = HttpRequestUtils.getHttpServletRequest();
        String token = getTokenByRequest(httpServletRequest);
        // TODO 根据token获取用户信息
        return NO_LOGIN_USER;
    }

    /**
     * 根据request 获取token信息
     * zhanls 2023/2/27 21:45
     */
    private static String getTokenByRequest(HttpServletRequest httpServletRequest) {
        if(ObjectUtil.isNotNull(httpServletRequest)){
            String authorization = httpServletRequest.getHeader(HEAD_TOKEN);
            String token = StrUtil.subSuf(authorization, BEARER_TOKEN_PREFIX.length());
            if(StrUtil.isBlankOrUndefined(token)){
                return Constant.EMPTY;
            }
            return token;
        }else{
            return Constant.EMPTY;
        }
    }

}
