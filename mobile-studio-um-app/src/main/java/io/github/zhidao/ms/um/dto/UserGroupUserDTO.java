package io.github.zhidao.ms.um.dto;

import io.github.zhidao.ms.common.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

/**
 * 用户与用户组关联表DTO
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserGroupUserDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	/** 用户组ID */
	@Schema(description = "用户组ID")
	private String groupId;
	/** 用户ID */
	@Schema(description = "用户ID")
	private String userId;
	/** 企业ID */
	@Schema(description = "企业ID")
	private String companyId;
}
