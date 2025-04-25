package io.github.zhidao.ms.common.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseDTO implements Serializable {

    private static final long serialVersionUID = 9058592757458562584L;

    /** ID */
    private String id ;

    /** 创建人 */
    private String createUser ;

    /** 创建时间 */
    private LocalDateTime createTime ;

    /** 更新人 */
    private String updateUser ;

    /** 更新时间 */
    private LocalDateTime updateTime ;

    /** 是否有效 */
    private String valid ;

    /** 是否删除 */
    private String deleted ;


}
