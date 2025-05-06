package io.github.zhidao.ms.um.dto;

import io.github.zhidao.ms.common.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

/**
 * 角色权限关联表DTO
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolePermissionDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	/** 角色ID */
	@Schema(description = "角色ID")
	private String roleId;
	/** 权限ID */
	@Schema(description = "权限ID")
	private String permissionId;
	/** 企业ID */
	@Schema(description = "企业ID")
	private String companyId;
}
