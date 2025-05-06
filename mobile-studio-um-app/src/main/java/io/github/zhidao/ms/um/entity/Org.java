package io.github.zhidao.ms.um.entity;

import io.github.zhidao.ms.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 组织表Entity
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "um_org")
public class Org extends BaseEntity {

    private static final long serialVersionUID = 1L;
	/** 组织ID */
	@Column(name="org_id")
	private String orgId;
	/** 组织名称 */
	@Column(name="org_name")
	private String orgName;
	/** 父级组织ID */
	@Column(name="parent_org_id")
	private String parentOrgId;
	/** 企业ID */
	@Column(name="company_id")
	private String companyId;
    /** id 构造器*/
    public Org(String id) {
       super.setId(id);
    }
}
