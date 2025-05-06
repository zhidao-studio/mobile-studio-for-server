package io.github.zhidao.ms.um.controller;

import io.github.zhidao.ms.common.dto.PageDTO;
import io.github.zhidao.ms.common.webapi.ApiResult;
import io.github.zhidao.ms.um.dto.PermissionDTO;
import io.github.zhidao.ms.um.service.PermissionService;
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
 * 权限表（支持权限层次） API
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@RestController
@Tag(name = "权限表（支持权限层次）")
@RequestMapping(value = "v1/permission")
@Slf4j
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	/**
     * 新增或修改权限表（支持权限层次）功能
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "新增或修改权限表（支持权限层次）功能")
	public ApiResult<PermissionDTO> insertPermission(@RequestBody @Validated PermissionDTO permissionDTO) {
		Integer result = permissionService.insertOrUpdate(permissionDTO);
		return result > 0 ? ApiResult.ok() : ApiResult.err("失败");
	}


	/**
     * 按主键删除 权限表（支持权限层次）
	 * @author ZHANLS 2025年05月06日
     */
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "按主键删除权限表（支持权限层次）")
	public ApiResult<PermissionDTO> deletePermissionById(@PathVariable String id) {
		Integer result = permissionService.deleteById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("删除失败");
	}

	/**
     * 按主键更新权限表（支持权限层次）
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "按主键更新权限表（支持权限层次）")
	public ApiResult<PermissionDTO> updatePermissionById(@RequestBody @Validated PermissionDTO permissionDTO) {
		Integer result = permissionService.updateById(permissionDTO);
		return result > 0 ? ApiResult.ok() : ApiResult.err("更新失败");
	}

	/**
     * 按主键置为无效
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "/disable/{id}")
	@Operation(summary = "按主键置为无效")
	public ApiResult<PermissionDTO> disablePermissionById(@PathVariable String id) {
		Integer result = permissionService.updateToInValidateById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("操作失败");
	}

	/**
     * 按主键置为有效
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "/enable/{id}")
	@Operation(summary = "按主键置为有效")
	public ApiResult<PermissionDTO> enablePermissionById(@PathVariable String id) {
		Integer result = permissionService.updateToValidateById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("操作失败");
	}

	/**
     * 按主键查询权限表（支持权限层次）
	 * @author ZHANLS 2025年05月06日
     */
	@GetMapping(value = "/select/{id}")
	@Operation(summary = "按主键查询权限表（支持权限层次）")
	public ApiResult<PermissionDTO> selectPermissionById(@PathVariable String id) {
		return ApiResult.ok(permissionService.selectById(id));
	}

	/**
     * 根据非空属性查询全部权限表（支持权限层次）
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "/list",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "查询全部权限表（支持权限层次）")
	public ApiResult<List<PermissionDTO>> listPermission(@RequestBody PermissionDTO permissionDTO) throws IllegalAccessException {
		List<PermissionDTO> permissionDtoList = permissionService.selectListByObject(permissionDTO);
		return ApiResult.ok(permissionDtoList);
	}

	/**
     * 根据条件分页查询全部权限表（支持权限层次）
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "/pageList",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "根据条件分页查询全部权限表（支持权限层次）")
	public ApiResult<PageDTO<PermissionDTO>> pageList(@RequestBody @Validated PageDTO<PermissionDTO> pageDTO) throws IllegalAccessException {
		Page<PermissionDTO> page = PageHelper.startPage(pageDTO.getPageNum(), pageDTO.getPageSize());
		List<PermissionDTO> permissionDtoList = permissionService.selectListByObject(pageDTO.getCondition());
		return ApiResult.ok(new PageDTO<>(page, permissionDtoList));
	}
}
