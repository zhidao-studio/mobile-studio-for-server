package io.github.zhidao.ms.um.entity;

import io.github.zhidao.ms.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户与岗位关联表Entity
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "um_user_position")
public class UserPosition extends BaseEntity {

    private static final long serialVersionUID = 1L;
	/** 用户ID */
	@Column(name="user_id")
	private String userId;
	/** 岗位ID */
	@Column(name="position_id")
	private String positionId;
	/** 企业ID */
	@Column(name="company_id")
	private String companyId;
    /** id 构造器*/
    public UserPosition(String id) {
       super.setId(id);
    }
}
