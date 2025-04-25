package io.github.zhidao.ms.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * - 性别
 *
 * @author zhanls 2023/2/19 16:24
 **/
@AllArgsConstructor
@Getter
public enum Gender implements BaseEnum {

    /** 是 */
    MALE("1","男"),
    /** 否 */
    FEMALE("0","女"),

    UNKNOWN("-1","未知");

    private String code;

    private String name;


}
