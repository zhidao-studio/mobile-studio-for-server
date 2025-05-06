package io.github.zhidao.ms.um.entity;

import io.github.zhidao.ms.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 组织角色关联表Entity
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "um_org_role")
public class OrgRole extends BaseEntity {

    private static final long serialVersionUID = 1L;
	/** 组织ID */
	@Column(name="org_id")
	private String orgId;
	/** 角色ID */
	@Column(name="role_id")
	private String roleId;
	/** 企业ID */
	@Column(name="company_id")
	private String companyId;
    /** id 构造器*/
    public OrgRole(String id) {
       super.setId(id);
    }
}
