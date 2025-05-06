package io.github.zhidao.ms.um.dto;

import io.github.zhidao.ms.common.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

/**
 * 角色互斥表（支持静态/动态互斥）DTO
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleExclusionDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	/** 互斥角色ID */
	@Schema(description = "互斥角色ID")
	private String exclusionRoleId;
	/** 角色ID */
	@Schema(description = "角色ID")
	private String roleId;
	/** 互斥类型（0:静态互斥 1:动态互斥） */
	@Schema(description = "互斥类型（0:静态互斥 1:动态互斥）")
	private Integer exclusionType;
	/** 互斥说明 */
	@Schema(description = "互斥说明")
	private String exclusionDesc;
	/** 企业ID */
	@Schema(description = "企业ID")
	private String companyId;
}
