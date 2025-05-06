package io.github.zhidao.ms.um.controller;

import io.github.zhidao.ms.common.dto.PageDTO;
import io.github.zhidao.ms.common.webapi.ApiResult;
import io.github.zhidao.ms.um.dto.RoleExclusionDTO;
import io.github.zhidao.ms.um.service.RoleExclusionService;
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
 * 角色互斥表（支持静态/动态互斥） API
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@RestController
@Tag(name = "角色互斥表（支持静态/动态互斥）")
@RequestMapping(value = "v1/roleExclusion")
@Slf4j
public class RoleExclusionController {

	@Autowired
	private RoleExclusionService roleExclusionService;

	/**
     * 新增或修改角色互斥表（支持静态/动态互斥）功能
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "新增或修改角色互斥表（支持静态/动态互斥）功能")
	public ApiResult<RoleExclusionDTO> insertRoleExclusion(@RequestBody @Validated RoleExclusionDTO roleExclusionDTO) {
		Integer result = roleExclusionService.insertOrUpdate(roleExclusionDTO);
		return result > 0 ? ApiResult.ok() : ApiResult.err("失败");
	}


	/**
     * 按主键删除 角色互斥表（支持静态/动态互斥）
	 * @author ZHANLS 2025年05月06日
     */
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "按主键删除角色互斥表（支持静态/动态互斥）")
	public ApiResult<RoleExclusionDTO> deleteRoleExclusionById(@PathVariable String id) {
		Integer result = roleExclusionService.deleteById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("删除失败");
	}

	/**
     * 按主键更新角色互斥表（支持静态/动态互斥）
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "按主键更新角色互斥表（支持静态/动态互斥）")
	public ApiResult<RoleExclusionDTO> updateRoleExclusionById(@RequestBody @Validated RoleExclusionDTO roleExclusionDTO) {
		Integer result = roleExclusionService.updateById(roleExclusionDTO);
		return result > 0 ? ApiResult.ok() : ApiResult.err("更新失败");
	}

	/**
     * 按主键置为无效
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "/disable/{id}")
	@Operation(summary = "按主键置为无效")
	public ApiResult<RoleExclusionDTO> disableRoleExclusionById(@PathVariable String id) {
		Integer result = roleExclusionService.updateToInValidateById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("操作失败");
	}

	/**
     * 按主键置为有效
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "/enable/{id}")
	@Operation(summary = "按主键置为有效")
	public ApiResult<RoleExclusionDTO> enableRoleExclusionById(@PathVariable String id) {
		Integer result = roleExclusionService.updateToValidateById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("操作失败");
	}

	/**
     * 按主键查询角色互斥表（支持静态/动态互斥）
	 * @author ZHANLS 2025年05月06日
     */
	@GetMapping(value = "/select/{id}")
	@Operation(summary = "按主键查询角色互斥表（支持静态/动态互斥）")
	public ApiResult<RoleExclusionDTO> selectRoleExclusionById(@PathVariable String id) {
		return ApiResult.ok(roleExclusionService.selectById(id));
	}

	/**
     * 根据非空属性查询全部角色互斥表（支持静态/动态互斥）
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "/list",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "查询全部角色互斥表（支持静态/动态互斥）")
	public ApiResult<List<RoleExclusionDTO>> listRoleExclusion(@RequestBody RoleExclusionDTO roleExclusionDTO) throws IllegalAccessException {
		List<RoleExclusionDTO> roleExclusionDtoList = roleExclusionService.selectListByObject(roleExclusionDTO);
		return ApiResult.ok(roleExclusionDtoList);
	}

	/**
     * 根据条件分页查询全部角色互斥表（支持静态/动态互斥）
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "/pageList",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "根据条件分页查询全部角色互斥表（支持静态/动态互斥）")
	public ApiResult<PageDTO<RoleExclusionDTO>> pageList(@RequestBody @Validated PageDTO<RoleExclusionDTO> pageDTO) throws IllegalAccessException {
		Page<RoleExclusionDTO> page = PageHelper.startPage(pageDTO.getPageNum(), pageDTO.getPageSize());
		List<RoleExclusionDTO> roleExclusionDtoList = roleExclusionService.selectListByObject(pageDTO.getCondition());
		return ApiResult.ok(new PageDTO<>(page, roleExclusionDtoList));
	}
}
