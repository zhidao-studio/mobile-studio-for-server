package io.github.zhidao.ms.um.dto;

import io.github.zhidao.ms.common.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

/**
 * 公司企业表DTO
 *
 * @author zhanls 2025年04月25日
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	/** 企业ID */
	@Schema(description = "企业ID")
	private String companyId;
	/** 企业名称 */
	@Schema(description = "企业名称")
	private String companyName;
	/** 企业类型 */
	@Schema(description = "企业类型")
	private String companyType;
}
