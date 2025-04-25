package io.github.zhidao.ms.common.webapi;

public class ApiException extends RuntimeException {
    private String code;

    public ApiException(ApiCode apiCode) {
        super(apiCode.getMsg());
        this.code = apiCode.getCode();
    }

    public ApiException(ApiCode apiCode,Object... args) {
        super(String.format(apiCode.getMsg(),args));
        this.code = apiCode.getCode();
    }

    public ApiException(String msg,ApiCode apiCode,Object... args) {
        super(String.format(msg == null ? apiCode.getMsg() : msg, args));
        this.code = apiCode.getCode();
    }

    public String getCode() {
        return code;
    }
}
