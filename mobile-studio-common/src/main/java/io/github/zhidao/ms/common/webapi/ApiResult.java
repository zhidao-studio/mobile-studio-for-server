package io.github.zhidao.ms.common.webapi;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.beans.ConstructorProperties;
import java.beans.Transient;
import java.io.Serializable;
import java.util.Objects;
import java.util.stream.Stream;

@Data
@Getter
@Setter
@Slf4j
public class ApiResult<E> implements Serializable {

    private String code;

    private String msg;

    private E data;

    public static <E> ApiResult<E> ok() {
        return ok(null);
    }

    public static <E> ApiResult<E> ok(E data) {
        return build(ApiCode.SUCCESS, data);
    }

    public static <E> ApiResult<E> err(ApiCode code) {
        return err(code, code.getMsg());
    }

    public static <E> ApiResult<E> err(ApiCode code, String msg) {
        return err(code.getCode(), msg);
    }

    public static <E> ApiResult<E> err(String msg) {
        return err(ApiCode.SERVER_ERROR.getCode(), msg);
    }

    public static <E> ApiResult<E> err(String msg, String data) {
        return (ApiResult<E>) build(ApiCode.SERVER_ERROR.getCode(), msg, data);
    }

    public static <E> ApiResult<E> build(ApiCode code, E data) {
        return build(code.getCode(), code.getMsg(), data);
    }

    public static <E> ApiResult<E> build(String code, String msg, E data) {
        return new ApiResult<>(code, msg, data);
    }

    public static <E> ApiResult<E> err(String msg, E data) {
        return build(ApiCode.SERVER_ERROR.getCode(), msg, data);
    }

    public static <E> ApiResult<E> err(ApiCode code, E data) {
        return build(code.getCode(), code.getMsg(), data);
    }

    public static <E> ApiResult<E> build(ApiCode code) {
        return build(code, null);
    }

    public static <E> ApiResult<E> with(Throwable e) {
        if (e != null && e instanceof ApiException) {
            return err(((ApiException) e).getCode(), e.getMessage());
        }
        if (e != null) {
            return err(ApiCode.SERVER_ERROR, e.getMessage());
        }
        return err(ApiCode.SERVER_ERROR);
    }

    @ConstructorProperties({"code", "msg", "data"})
    public ApiResult(String code, String msg, E data) {
        if (!ApiCode.SUCCESS.getCode().equals(code)) {
            log.error("msg: {} , data: {}", msg, data);
        }
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Transient
    protected ApiCode[] getOkCodes(){
        return new ApiCode[]{ApiCode.SUCCESS};
    }

    @Transient
    public boolean isSuccess() {
        return Stream.of(getOkCodes()).anyMatch(respOKCode -> Objects.equals(this.code, respOKCode.getCode()));
    }

    @Transient
    public boolean isError() {
        return !isSuccess();
    }

    public E getData() {
        if (data instanceof Exception) {
            try {
                Throwable exceptionData = ((Throwable) data);
                //堆栈转为完整字符串
                String stackTraceContent = StrUtil.concat(true, "\n message:", ExceptionUtil.getMessage(exceptionData), "\n stacktrace:", ExceptionUtil.stacktraceToString(exceptionData));
                data = (E) stackTraceContent;
            } catch (Exception e) {
                log.error("将异常堆栈进行格式化输出，发生异常{}", e);
            }
        }
        return data;
    }



}
