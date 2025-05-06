package io.github.zhidao.ms.um.entity;

import io.github.zhidao.ms.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 权限表（支持权限层次）Entity
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "um_permission")
public class Permission extends BaseEntity {

    private static final long serialVersionUID = 1L;
	/** 权限ID */
	@Column(name="permission_id")
	private String permissionId;
	/** 权限名称 */
	@Column(name="permission_name")
	private String permissionName;
	/** 权限类型（0:菜单 1:操作 2:数据） */
	@Column(name="type")
	private String type;
	/** 父权限ID（顶级权限为NULL） */
	@Column(name="parent_permission_id")
	private String parentPermissionId;
	/** 企业ID */
	@Column(name="company_id")
	private String companyId;
    /** id 构造器*/
    public Permission(String id) {
       super.setId(id);
    }
}
