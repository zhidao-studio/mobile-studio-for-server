package io.github.zhidao.ms.um.controller;

import io.github.zhidao.ms.common.dto.PageDTO;
import io.github.zhidao.ms.common.webapi.ApiResult;
import io.github.zhidao.ms.um.dto.OrgDTO;
import io.github.zhidao.ms.um.service.OrgService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * 组织表 API
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@RestController
@Tag(name = "组织表")
@RequestMapping(value = "v1/org")
@Slf4j
public class OrgController {

	@Autowired
	private OrgService orgService;

	/**
     * 新增或修改组织表功能
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "新增或修改组织表功能")
	public ApiResult<OrgDTO> insertOrg(@RequestBody @Validated OrgDTO orgDTO) {
		Integer result = orgService.insertOrUpdate(orgDTO);
		return result > 0 ? ApiResult.ok() : ApiResult.err("失败");
	}


	/**
     * 按主键删除 组织表
	 * @author ZHANLS 2025年05月06日
     */
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "按主键删除组织表")
	public ApiResult<OrgDTO> deleteOrgById(@PathVariable String id) {
		Integer result = orgService.deleteById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("删除失败");
	}

	/**
     * 按主键更新组织表
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "按主键更新组织表")
	public ApiResult<OrgDTO> updateOrgById(@RequestBody @Validated OrgDTO orgDTO) {
		Integer result = orgService.updateById(orgDTO);
		return result > 0 ? ApiResult.ok() : ApiResult.err("更新失败");
	}

	/**
     * 按主键置为无效
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "/disable/{id}")
	@Operation(summary = "按主键置为无效")
	public ApiResult<OrgDTO> disableOrgById(@PathVariable String id) {
		Integer result = orgService.updateToInValidateById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("操作失败");
	}

	/**
     * 按主键置为有效
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "/enable/{id}")
	@Operation(summary = "按主键置为有效")
	public ApiResult<OrgDTO> enableOrgById(@PathVariable String id) {
		Integer result = orgService.updateToValidateById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("操作失败");
	}

	/**
     * 按主键查询组织表
	 * @author ZHANLS 2025年05月06日
     */
	@GetMapping(value = "/select/{id}")
	@Operation(summary = "按主键查询组织表")
	public ApiResult<OrgDTO> selectOrgById(@PathVariable String id) {
		return ApiResult.ok(orgService.selectById(id));
	}

	/**
     * 根据非空属性查询全部组织表
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "/list",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "查询全部组织表")
	public ApiResult<List<OrgDTO>> listOrg(@RequestBody OrgDTO orgDTO) throws IllegalAccessException {
		List<OrgDTO> orgDtoList = orgService.selectListByObject(orgDTO);
		return ApiResult.ok(orgDtoList);
	}

	/**
     * 根据条件分页查询全部组织表
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "/pageList",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "根据条件分页查询全部组织表")
	public ApiResult<PageDTO<OrgDTO>> pageList(@RequestBody @Validated PageDTO<OrgDTO> pageDTO) throws IllegalAccessException {
		Page<OrgDTO> page = PageHelper.startPage(pageDTO.getPageNum(), pageDTO.getPageSize());
		List<OrgDTO> orgDtoList = orgService.selectListByObject(pageDTO.getCondition());
		return ApiResult.ok(new PageDTO<>(page, orgDtoList));
	}
}
