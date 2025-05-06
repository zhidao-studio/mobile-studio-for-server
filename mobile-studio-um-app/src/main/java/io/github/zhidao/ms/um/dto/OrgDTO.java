package io.github.zhidao.ms.um.dto;

import io.github.zhidao.ms.common.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

/**
 * 组织表DTO
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrgDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	/** 组织ID */
	@Schema(description = "组织ID")
	private String orgId;
	/** 组织名称 */
	@Schema(description = "组织名称")
	private String orgName;
	/** 父级组织ID */
	@Schema(description = "父级组织ID")
	private String parentOrgId;
	/** 企业ID */
	@Schema(description = "企业ID")
	private String companyId;
}
