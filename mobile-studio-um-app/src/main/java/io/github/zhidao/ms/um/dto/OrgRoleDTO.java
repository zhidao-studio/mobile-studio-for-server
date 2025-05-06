package io.github.zhidao.ms.um.dto;

import io.github.zhidao.ms.common.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

/**
 * 组织角色关联表DTO
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrgRoleDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	/** 组织ID */
	@Schema(description = "组织ID")
	private String orgId;
	/** 角色ID */
	@Schema(description = "角色ID")
	private String roleId;
	/** 企业ID */
	@Schema(description = "企业ID")
	private String companyId;
}
