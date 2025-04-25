package io.github.zhidao.ms.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * - 公共枚举
 *
 * @author zhanls 2023/2/19 16:24
 **/
@AllArgsConstructor
@Getter
public enum CommEnum implements BaseEnum {

    /** 是 */
    YES("1","是"),
    /** 否 */
    NO("0","否");

    private String code;

    private String name;

}
