package io.github.zhidao.ms.um.entity;

import io.github.zhidao.ms.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 角色权限关联表Entity
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "um_role_permission")
public class RolePermission extends BaseEntity {

    private static final long serialVersionUID = 1L;
	/** 角色ID */
	@Column(name="role_id")
	private String roleId;
	/** 权限ID */
	@Column(name="permission_id")
	private String permissionId;
	/** 企业ID */
	@Column(name="company_id")
	private String companyId;
    /** id 构造器*/
    public RolePermission(String id) {
       super.setId(id);
    }
}
