package io.github.zhidao.ms.um.controller;

import io.github.zhidao.ms.common.dto.PageDTO;
import io.github.zhidao.ms.common.webapi.ApiResult;
import io.github.zhidao.ms.um.dto.OrgRoleDTO;
import io.github.zhidao.ms.um.service.OrgRoleService;
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
 * 组织角色关联表 API
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@RestController
@Tag(name = "组织角色关联表")
@RequestMapping(value = "v1/orgRole")
@Slf4j
public class OrgRoleController {

	@Autowired
	private OrgRoleService orgRoleService;

	/**
     * 新增或修改组织角色关联表功能
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "新增或修改组织角色关联表功能")
	public ApiResult<OrgRoleDTO> insertOrgRole(@RequestBody @Validated OrgRoleDTO orgRoleDTO) {
		Integer result = orgRoleService.insertOrUpdate(orgRoleDTO);
		return result > 0 ? ApiResult.ok() : ApiResult.err("失败");
	}


	/**
     * 按主键删除 组织角色关联表
	 * @author ZHANLS 2025年05月06日
     */
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "按主键删除组织角色关联表")
	public ApiResult<OrgRoleDTO> deleteOrgRoleById(@PathVariable String id) {
		Integer result = orgRoleService.deleteById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("删除失败");
	}

	/**
     * 按主键更新组织角色关联表
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "按主键更新组织角色关联表")
	public ApiResult<OrgRoleDTO> updateOrgRoleById(@RequestBody @Validated OrgRoleDTO orgRoleDTO) {
		Integer result = orgRoleService.updateById(orgRoleDTO);
		return result > 0 ? ApiResult.ok() : ApiResult.err("更新失败");
	}

	/**
     * 按主键置为无效
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "/disable/{id}")
	@Operation(summary = "按主键置为无效")
	public ApiResult<OrgRoleDTO> disableOrgRoleById(@PathVariable String id) {
		Integer result = orgRoleService.updateToInValidateById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("操作失败");
	}

	/**
     * 按主键置为有效
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "/enable/{id}")
	@Operation(summary = "按主键置为有效")
	public ApiResult<OrgRoleDTO> enableOrgRoleById(@PathVariable String id) {
		Integer result = orgRoleService.updateToValidateById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("操作失败");
	}

	/**
     * 按主键查询组织角色关联表
	 * @author ZHANLS 2025年05月06日
     */
	@GetMapping(value = "/select/{id}")
	@Operation(summary = "按主键查询组织角色关联表")
	public ApiResult<OrgRoleDTO> selectOrgRoleById(@PathVariable String id) {
		return ApiResult.ok(orgRoleService.selectById(id));
	}

	/**
     * 根据非空属性查询全部组织角色关联表
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "/list",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "查询全部组织角色关联表")
	public ApiResult<List<OrgRoleDTO>> listOrgRole(@RequestBody OrgRoleDTO orgRoleDTO) throws IllegalAccessException {
		List<OrgRoleDTO> orgRoleDtoList = orgRoleService.selectListByObject(orgRoleDTO);
		return ApiResult.ok(orgRoleDtoList);
	}

	/**
     * 根据条件分页查询全部组织角色关联表
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "/pageList",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "根据条件分页查询全部组织角色关联表")
	public ApiResult<PageDTO<OrgRoleDTO>> pageList(@RequestBody @Validated PageDTO<OrgRoleDTO> pageDTO) throws IllegalAccessException {
		Page<OrgRoleDTO> page = PageHelper.startPage(pageDTO.getPageNum(), pageDTO.getPageSize());
		List<OrgRoleDTO> orgRoleDtoList = orgRoleService.selectListByObject(pageDTO.getCondition());
		return ApiResult.ok(new PageDTO<>(page, orgRoleDtoList));
	}
}
