package io.github.zhidao.ms.um.dto;

import io.github.zhidao.ms.common.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

/**
 * 岗位表（支持岗位层次）DTO
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PositionDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	/** 岗位ID */
	@Schema(description = "岗位ID")
	private String positionId;
	/** 岗位名称 */
	@Schema(description = "岗位名称")
	private String positionName;
	/** 上级岗位ID（顶级岗位为NULL） */
	@Schema(description = "上级岗位ID（顶级岗位为NULL）")
	private String parentPositionId;
	/** 企业ID */
	@Schema(description = "企业ID")
	private String companyId;
}
