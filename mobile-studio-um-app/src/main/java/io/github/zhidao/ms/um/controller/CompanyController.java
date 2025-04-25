package io.github.zhidao.ms.um.controller;

import io.github.zhidao.ms.common.dto.PageDTO;
import io.github.zhidao.ms.common.webapi.ApiResult;
import io.github.zhidao.ms.um.dto.CompanyDTO;
import io.github.zhidao.ms.um.service.CompanyService;
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
 * 公司企业表 API
 *
 * @author zhanls 2025年04月25日
 * @version 1.0
 */
@RestController
@Tag(name = "公司企业表")
@RequestMapping(value = "v1/company")
@Slf4j
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	/**
     * 新增或修改公司企业表功能
	 * @author zhanls 2025年04月25日
     */
	@PostMapping(value = "",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "新增或修改公司企业表功能")
	public ApiResult<CompanyDTO> insertCompany(@RequestBody @Validated CompanyDTO companyDTO) {
		Integer result = companyService.insertOrUpdate(companyDTO);
		return result > 0 ? ApiResult.ok() : ApiResult.err("失败");
	}


	/**
     * 按主键删除 公司企业表
	 * @author zhanls 2025年04月25日
     */
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "按主键删除公司企业表")
	public ApiResult<CompanyDTO> deleteCompanyById(@PathVariable String id) {
		Integer result = companyService.deleteById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("删除失败");
	}

	/**
     * 按主键更新公司企业表
	 * @author zhanls 2025年04月25日
     */
	@PutMapping(value = "",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "按主键更新公司企业表")
	public ApiResult<CompanyDTO> updateCompanyById(@RequestBody @Validated CompanyDTO companyDTO) {
		Integer result = companyService.updateById(companyDTO);
		return result > 0 ? ApiResult.ok() : ApiResult.err("更新失败");
	}

	/**
     * 按主键置为无效
	 * @author zhanls 2025年04月25日
     */
	@PutMapping(value = "/disable/{id}")
	@Operation(summary = "按主键置为无效")
	public ApiResult<CompanyDTO> disableCompanyById(@PathVariable String id) {
		Integer result = companyService.updateToInValidateById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("操作失败");
	}

	/**
     * 按主键置为有效
	 * @author zhanls 2025年04月25日
     */
	@PutMapping(value = "/enable/{id}")
	@Operation(summary = "按主键置为有效")
	public ApiResult<CompanyDTO> enableCompanyById(@PathVariable String id) {
		Integer result = companyService.updateToValidateById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("操作失败");
	}

	/**
     * 按主键查询公司企业表
	 * @author zhanls 2025年04月25日
     */
	@GetMapping(value = "/select/{id}")
	@Operation(summary = "按主键查询公司企业表")
	public ApiResult<CompanyDTO> selectCompanyById(@PathVariable String id) {
		return ApiResult.ok(companyService.selectById(id));
	}

	/**
     * 根据非空属性查询全部公司企业表
	 * @author zhanls 2025年04月25日
     */
	@PostMapping(value = "/list",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "查询全部公司企业表")
	public ApiResult<List<CompanyDTO>> listCompany(@RequestBody CompanyDTO companyDTO) throws IllegalAccessException {
		List<CompanyDTO> companyDtoList = companyService.selectListByObject(companyDTO);
		return ApiResult.ok(companyDtoList);
	}

	/**
     * 根据条件分页查询全部公司企业表
	 * @author zhanls 2025年04月25日
     */
	@PostMapping(value = "/pageList",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "根据条件分页查询全部公司企业表")
	public ApiResult<PageDTO<CompanyDTO>> pageList(@RequestBody @Validated PageDTO<CompanyDTO> pageDTO) throws IllegalAccessException {
		Page<CompanyDTO> page = PageHelper.startPage(pageDTO.getPageNum(), pageDTO.getPageSize());
		List<CompanyDTO> companyDtoList = companyService.selectListByObject(pageDTO.getCondition());
		return ApiResult.ok(new PageDTO<>(page, companyDtoList));
	}
}
