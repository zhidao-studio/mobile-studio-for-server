package io.github.zhidao.ms.um.entity;

import io.github.zhidao.ms.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户与用户组关联表Entity
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "um_user_group_user")
public class UserGroupUser extends BaseEntity {

    private static final long serialVersionUID = 1L;
	/** 用户组ID */
	@Column(name="group_id")
	private String groupId;
	/** 用户ID */
	@Column(name="user_id")
	private String userId;
	/** 企业ID */
	@Column(name="company_id")
	private String companyId;
    /** id 构造器*/
    public UserGroupUser(String id) {
       super.setId(id);
    }
}
