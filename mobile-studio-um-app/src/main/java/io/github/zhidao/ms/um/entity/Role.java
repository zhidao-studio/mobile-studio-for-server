package io.github.zhidao.ms.um.entity;

import io.github.zhidao.ms.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 角色表（支持角色层次）Entity
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "um_role")
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;
	/** 角色ID */
	@Column(name="role_id")
	private String roleId;
	/** 角色名称 */
	@Column(name="role_name")
	private String roleName;
	/** 父级角色ID（根角色为NULL） */
	@Column(name="parent_role_id")
	private String parentRoleId;
	/** 角色层级（根角色0，子角色逐层+1） */
	@Column(name="role_level")
	private Integer roleLevel;
	/** 企业ID */
	@Column(name="company_id")
	private String companyId;
    /** id 构造器*/
    public Role(String id) {
       super.setId(id);
    }
}
