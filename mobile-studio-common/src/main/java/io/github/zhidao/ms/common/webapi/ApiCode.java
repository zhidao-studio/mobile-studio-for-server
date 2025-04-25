package io.github.zhidao.ms.common.webapi;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiCode {

    SUCCESS("000", "成功"),

    BAD_REQUEST("400", "请求参数错误"),

    UNAUTHORIZED("401", "未授权"),

    FORBIDDEN("403", "拒绝访问"),

    NOT_FOUND("404", "404 Not Found"),

    SERVER_ERROR("500", "当前服务不可用，请稍后重试"),

    //=============== 校验 ================//
    VALID_REQUEST_NOT_EMPTY("40001","请求参数存在空值"),

    VALID_REQUEST_FORBIDDEN("40002","请求参数存在不允许的值"),

    //=============== DATA ===============//
    DATA_QUERY_NOT_FOUND("50001","数据不存在"),


    ;

    private String code;

    private String msg;


}
