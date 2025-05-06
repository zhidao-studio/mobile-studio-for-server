package io.github.zhidao.ms.um.entity;

import io.github.zhidao.ms.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 角色互斥表（支持静态/动态互斥）Entity
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "um_role_exclusion")
public class RoleExclusion extends BaseEntity {

    private static final long serialVersionUID = 1L;
	/** 互斥角色ID */
	@Column(name="exclusion_role_id")
	private String exclusionRoleId;
	/** 角色ID */
	@Column(name="role_id")
	private String roleId;
	/** 互斥类型（0:静态互斥 1:动态互斥） */
	@Column(name="exclusion_type")
	private Integer exclusionType;
	/** 互斥说明 */
	@Column(name="exclusion_desc")
	private String exclusionDesc;
	/** 企业ID */
	@Column(name="company_id")
	private String companyId;
    /** id 构造器*/
    public RoleExclusion(String id) {
       super.setId(id);
    }
}
