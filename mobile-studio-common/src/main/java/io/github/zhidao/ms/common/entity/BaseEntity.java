package io.github.zhidao.ms.common.entity;


import lombok.Data;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * - 基础Entity，映射表结构的基本七要素，业务Entity继承此类
 *
 * @author zhanls 2023/1/24 15:36
 **/
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -122513509793898143L;

    /** ID */
    @Id
    @Column(name = "id")
    private String id ;

    /** 创建人 */
    @Column(name = "create_user")
    private String createUser ;

    /** 创建时间 */
    @Column(name = "create_time")
    private LocalDateTime createTime ;

    /** 更新人 */
    @Column(name = "update_user")
    private String updateUser ;

    /** 更新时间 */
    @Column(name = "update_time")
    private LocalDateTime updateTime ;

    /** 是否有效 */
    @Column(name = "valid")
    private String valid ;

    /** 是否删除 */
    @Column(name = "deleted")
    private String deleted ;

}
