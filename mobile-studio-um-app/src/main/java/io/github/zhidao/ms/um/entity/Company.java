package io.github.zhidao.ms.um.entity;

import io.github.zhidao.ms.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 公司企业表Entity
 *
 * @author zhanls 2025年04月25日
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "um_company")
public class Company extends BaseEntity {

    private static final long serialVersionUID = 1L;
	/** 企业ID */
	@Column(name="company_id")
	private String companyId;
	/** 企业名称 */
	@Column(name="company_name")
	private String companyName;
	/** 企业类型 */
	@Column(name="company_type")
	private String companyType;
    /** id 构造器*/
    public Company(String id) {
       super.setId(id);
    }
}
