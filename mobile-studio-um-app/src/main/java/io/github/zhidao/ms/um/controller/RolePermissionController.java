package io.github.zhidao.ms.um.controller;

import io.github.zhidao.ms.common.dto.PageDTO;
import io.github.zhidao.ms.common.webapi.ApiResult;
import io.github.zhidao.ms.um.dto.RolePermissionDTO;
import io.github.zhidao.ms.um.service.RolePermissionService;
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
 * 角色权限关联表 API
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@RestController
@Tag(name = "角色权限关联表")
@RequestMapping(value = "v1/rolePermission")
@Slf4j
public class RolePermissionController {

	@Autowired
	private RolePermissionService rolePermissionService;

	/**
     * 新增或修改角色权限关联表功能
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "新增或修改角色权限关联表功能")
	public ApiResult<RolePermissionDTO> insertRolePermission(@RequestBody @Validated RolePermissionDTO rolePermissionDTO) {
		Integer result = rolePermissionService.insertOrUpdate(rolePermissionDTO);
		return result > 0 ? ApiResult.ok() : ApiResult.err("失败");
	}


	/**
     * 按主键删除 角色权限关联表
	 * @author ZHANLS 2025年05月06日
     */
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "按主键删除角色权限关联表")
	public ApiResult<RolePermissionDTO> deleteRolePermissionById(@PathVariable String id) {
		Integer result = rolePermissionService.deleteById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("删除失败");
	}

	/**
     * 按主键更新角色权限关联表
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "按主键更新角色权限关联表")
	public ApiResult<RolePermissionDTO> updateRolePermissionById(@RequestBody @Validated RolePermissionDTO rolePermissionDTO) {
		Integer result = rolePermissionService.updateById(rolePermissionDTO);
		return result > 0 ? ApiResult.ok() : ApiResult.err("更新失败");
	}

	/**
     * 按主键置为无效
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "/disable/{id}")
	@Operation(summary = "按主键置为无效")
	public ApiResult<RolePermissionDTO> disableRolePermissionById(@PathVariable String id) {
		Integer result = rolePermissionService.updateToInValidateById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("操作失败");
	}

	/**
     * 按主键置为有效
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "/enable/{id}")
	@Operation(summary = "按主键置为有效")
	public ApiResult<RolePermissionDTO> enableRolePermissionById(@PathVariable String id) {
		Integer result = rolePermissionService.updateToValidateById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("操作失败");
	}

	/**
     * 按主键查询角色权限关联表
	 * @author ZHANLS 2025年05月06日
     */
	@GetMapping(value = "/select/{id}")
	@Operation(summary = "按主键查询角色权限关联表")
	public ApiResult<RolePermissionDTO> selectRolePermissionById(@PathVariable String id) {
		return ApiResult.ok(rolePermissionService.selectById(id));
	}

	/**
     * 根据非空属性查询全部角色权限关联表
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "/list",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "查询全部角色权限关联表")
	public ApiResult<List<RolePermissionDTO>> listRolePermission(@RequestBody RolePermissionDTO rolePermissionDTO) throws IllegalAccessException {
		List<RolePermissionDTO> rolePermissionDtoList = rolePermissionService.selectListByObject(rolePermissionDTO);
		return ApiResult.ok(rolePermissionDtoList);
	}

	/**
     * 根据条件分页查询全部角色权限关联表
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "/pageList",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "根据条件分页查询全部角色权限关联表")
	public ApiResult<PageDTO<RolePermissionDTO>> pageList(@RequestBody @Validated PageDTO<RolePermissionDTO> pageDTO) throws IllegalAccessException {
		Page<RolePermissionDTO> page = PageHelper.startPage(pageDTO.getPageNum(), pageDTO.getPageSize());
		List<RolePermissionDTO> rolePermissionDtoList = rolePermissionService.selectListByObject(pageDTO.getCondition());
		return ApiResult.ok(new PageDTO<>(page, rolePermissionDtoList));
	}
}
