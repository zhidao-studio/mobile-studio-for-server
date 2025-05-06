package io.github.zhidao.ms.um.controller;

import io.github.zhidao.ms.common.dto.PageDTO;
import io.github.zhidao.ms.common.webapi.ApiResult;
import io.github.zhidao.ms.um.dto.RoleDTO;
import io.github.zhidao.ms.um.service.RoleService;
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
 * 角色表（支持角色层次） API
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@RestController
@Tag(name = "角色表（支持角色层次）")
@RequestMapping(value = "v1/role")
@Slf4j
public class RoleController {

	@Autowired
	private RoleService roleService;

	/**
     * 新增或修改角色表（支持角色层次）功能
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "新增或修改角色表（支持角色层次）功能")
	public ApiResult<RoleDTO> insertRole(@RequestBody @Validated RoleDTO roleDTO) {
		Integer result = roleService.insertOrUpdate(roleDTO);
		return result > 0 ? ApiResult.ok() : ApiResult.err("失败");
	}


	/**
     * 按主键删除 角色表（支持角色层次）
	 * @author ZHANLS 2025年05月06日
     */
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "按主键删除角色表（支持角色层次）")
	public ApiResult<RoleDTO> deleteRoleById(@PathVariable String id) {
		Integer result = roleService.deleteById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("删除失败");
	}

	/**
     * 按主键更新角色表（支持角色层次）
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "按主键更新角色表（支持角色层次）")
	public ApiResult<RoleDTO> updateRoleById(@RequestBody @Validated RoleDTO roleDTO) {
		Integer result = roleService.updateById(roleDTO);
		return result > 0 ? ApiResult.ok() : ApiResult.err("更新失败");
	}

	/**
     * 按主键置为无效
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "/disable/{id}")
	@Operation(summary = "按主键置为无效")
	public ApiResult<RoleDTO> disableRoleById(@PathVariable String id) {
		Integer result = roleService.updateToInValidateById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("操作失败");
	}

	/**
     * 按主键置为有效
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "/enable/{id}")
	@Operation(summary = "按主键置为有效")
	public ApiResult<RoleDTO> enableRoleById(@PathVariable String id) {
		Integer result = roleService.updateToValidateById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("操作失败");
	}

	/**
     * 按主键查询角色表（支持角色层次）
	 * @author ZHANLS 2025年05月06日
     */
	@GetMapping(value = "/select/{id}")
	@Operation(summary = "按主键查询角色表（支持角色层次）")
	public ApiResult<RoleDTO> selectRoleById(@PathVariable String id) {
		return ApiResult.ok(roleService.selectById(id));
	}

	/**
     * 根据非空属性查询全部角色表（支持角色层次）
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "/list",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "查询全部角色表（支持角色层次）")
	public ApiResult<List<RoleDTO>> listRole(@RequestBody RoleDTO roleDTO) throws IllegalAccessException {
		List<RoleDTO> roleDtoList = roleService.selectListByObject(roleDTO);
		return ApiResult.ok(roleDtoList);
	}

	/**
     * 根据条件分页查询全部角色表（支持角色层次）
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "/pageList",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "根据条件分页查询全部角色表（支持角色层次）")
	public ApiResult<PageDTO<RoleDTO>> pageList(@RequestBody @Validated PageDTO<RoleDTO> pageDTO) throws IllegalAccessException {
		Page<RoleDTO> page = PageHelper.startPage(pageDTO.getPageNum(), pageDTO.getPageSize());
		List<RoleDTO> roleDtoList = roleService.selectListByObject(pageDTO.getCondition());
		return ApiResult.ok(new PageDTO<>(page, roleDtoList));
	}
}
