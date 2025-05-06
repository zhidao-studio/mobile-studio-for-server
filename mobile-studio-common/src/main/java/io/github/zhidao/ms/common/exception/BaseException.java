package io.github.zhidao.ms.common.exception;

import java.io.Serial;
import java.io.Serializable;

/**
 * - 基础异常
 *
 * @author zhanls 2023/1/24 15:48
 **/
public class BaseException extends RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = 4597372192247591163L;

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
