package io.github.zhidao.ms.um.dto;

import io.github.zhidao.ms.common.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

/**
 * 权限表（支持权限层次）DTO
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PermissionDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	/** 权限ID */
	@Schema(description = "权限ID")
	private String permissionId;
	/** 权限名称 */
	@Schema(description = "权限名称")
	private String permissionName;
	/** 权限类型（0:菜单 1:操作 2:数据） */
	@Schema(description = "权限类型（0:菜单 1:操作 2:数据）")
	private String type;
	/** 父权限ID（顶级权限为NULL） */
	@Schema(description = "父权限ID（顶级权限为NULL）")
	private String parentPermissionId;
	/** 企业ID */
	@Schema(description = "企业ID")
	private String companyId;
}
