package io.github.zhidao.ms.um.dto;

import io.github.zhidao.ms.common.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

/**
 * 角色表（支持角色层次）DTO
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	/** 角色ID */
	@Schema(description = "角色ID")
	private String roleId;
	/** 角色名称 */
	@Schema(description = "角色名称")
	private String roleName;
	/** 父级角色ID（根角色为NULL） */
	@Schema(description = "父级角色ID（根角色为NULL）")
	private String parentRoleId;
	/** 角色层级（根角色0，子角色逐层+1） */
	@Schema(description = "角色层级（根角色0，子角色逐层+1）")
	private Integer roleLevel;
	/** 企业ID */
	@Schema(description = "企业ID")
	private String companyId;
}
