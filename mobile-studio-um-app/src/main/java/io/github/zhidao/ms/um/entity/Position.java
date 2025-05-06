package io.github.zhidao.ms.um.entity;

import io.github.zhidao.ms.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 岗位表（支持岗位层次）Entity
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "um_position")
public class Position extends BaseEntity {

    private static final long serialVersionUID = 1L;
	/** 岗位ID */
	@Column(name="position_id")
	private String positionId;
	/** 岗位名称 */
	@Column(name="position_name")
	private String positionName;
	/** 上级岗位ID（顶级岗位为NULL） */
	@Column(name="parent_position_id")
	private String parentPositionId;
	/** 企业ID */
	@Column(name="company_id")
	private String companyId;
    /** id 构造器*/
    public Position(String id) {
       super.setId(id);
    }
}
