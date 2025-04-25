package io.github.zhidao.ms.common.util;

import cn.hutool.http.HttpUtil;
import io.github.zhidao.ms.common.webapi.ApiResult;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Map;


/**
 * - 网络工具类
 *
 * https://blog.csdn.net/moyefeng198436/article/details/113837992
 * https://hutool.cn/docs/#/http/Http%E5%AE%A2%E6%88%B7%E7%AB%AF%E5%B7%A5%E5%85%B7%E7%B1%BB-HttpUtil
 *
 * @author zhanls 2022/11/30 22:02
 **/
@Slf4j
public class NetUtil {

    /**
     * GET - 基本请求
     * zhanls 2023/1/24 16:48
     */
    public static ApiResult get(String url){
        String result = HttpUtil.get(url);
        return ApiResult.ok(result);
    }

    /**
     * GET - 带请求体参数
     * zhanls 2023/1/24 16:48
     */
    public static ApiResult get(String url, Map<String, Object> paramMap){
        String result = HttpUtil.get(url, paramMap);
        return ApiResult.ok(result);
    }

    /**
     * FORM - 表单提交
     * zhanls 2023/1/24 17:35
     */
    public static ApiResult form(String url, Map<String, Object> form){
        String result = HttpUtil.urlWithForm(url, form, Charset.defaultCharset(), false);
        return ApiResult.ok(result);
    }


//    /**
//     * GET - 带请求头/请求体参数
//     * zhanls 2023/1/24 16:48
//     */
//    public static ApiResult get(String url, Map<String, Object> header ,Map<String, Object> body){
//
//        return null;
//    }

    /**
     * POST - 带请求体参数
     * zhanls 2023/1/24 16:59
     */
    public static ApiResult post(String url, Map<String, Object> paramMap){
        String result = HttpUtil.post(url, paramMap);
        return ApiResult.ok(result);
    }

    /**
     * POST - 带请求体参数
     * zhanls 2023/1/24 16:59
     */
    public static ApiResult post(String url, String paramStr){
        String result = HttpUtil.post(url, paramStr);
        return ApiResult.ok(result);
    }

    /**
     * 下载 - 文件
     * zhanls 2023/1/24 16:59
     */
    public static ApiResult download(String url, String dest){
        File file = HttpUtil.downloadFileFromUrl(url,dest);
        return ApiResult.ok(file.getAbsolutePath());
    }


}
